package application.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "questao")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "quiz_id") 
    private Quiz quiz;

    @OneToMany(mappedBy = "questao")
    private Set<Alternativa> alternativa = new HashSet<>();

    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return this.id;
    }

    public void setEnunciado(String enunciado){
        this.enunciado = enunciado;
    }
    public String getEnunciado(){
        return this.enunciado;
    }

    public void setQuiz(Quiz quiz){
        this.quiz = quiz; 
    }
    public Quiz getQuiz(){
        return this.quiz;
    }

    public void setAlternativa(Set<Alternativa> alternativa){
        this.alternativa = alternativa;
    }
    public Set<Alternativa> getAlternativa(){
        return this.alternativa;
    }
}
