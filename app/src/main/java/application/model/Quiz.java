package application.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "quiz")
public class Quiz{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "quiz")
    private Set<Questao> questoes = new HashSet<>();

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    public void setQuestao(Set<Questao> questao){
        this.questoes = questao;
    }
    public Set<Questao> getQuestao(){
        return this.questoes;
    }
}