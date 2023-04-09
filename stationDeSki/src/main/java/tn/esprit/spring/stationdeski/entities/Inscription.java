package tn.esprit.spring.stationdeski.entities;


        import javax.persistence.*;
        import java.io.Serializable;

@Entity
@Table( name = "Inscription")
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idInscription")
    private Integer idInscription; // Clé primaire
    private Long numInscription;
    private int numSemaine;
    @ManyToOne
    private Skieur sikeur;
    @ManyToOne
    private Cours cours;

// Constructeur et accesseurs (getters) et mutateurs (setters)
}
