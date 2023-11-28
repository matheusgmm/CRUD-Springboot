package application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "alternativa")
public class Alternativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String texto;

    @Column(nullable = false)
    private Boolean isCorreta;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return this.id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public String getTexto() {
        return this.texto;
    }

    public void setIsCorreta(boolean isCorreta) {
        this.isCorreta = isCorreta;
    }
    public boolean getIsCorreta() {
        return this.isCorreta;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
    public Questao getQuestao() {
        return this.questao;
    }
}
