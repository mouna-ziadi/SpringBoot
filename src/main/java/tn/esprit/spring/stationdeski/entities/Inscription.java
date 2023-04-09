package tn.esprit.spring.stationdeski.entities;


        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import javax.persistence.*;
        import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Inscription")
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idInscription")
    private Integer idInscription; // Clé primaire
    private Long numInscription;
    private int numSemaine;
    @ManyToOne(cascade = CascadeType.ALL)
    private Skieur sikeur;
    @ManyToOne
    private Cours cours;

    // Constructeur et accesseurs (getters) et mutateurs (setters)
}
