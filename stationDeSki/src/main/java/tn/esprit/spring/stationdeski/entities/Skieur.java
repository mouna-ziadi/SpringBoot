package tn.esprit.spring.stationdeski.entities;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.util.Date;
        import java.util.Set;

@Entity
@Table( name = "Skieur")
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSkieur")
    private Integer idSkieur; // Clé primaire
    private Long numSkieur;
    private String nomS;
    private String prenomS;
    private Date dateNaissance;
    private String ville;

    @ManyToMany(mappedBy = "skieurs")
    private Set<Piste> pistes;
    @OneToMany(mappedBy = "sikeur")
    private Set<Inscription> inscriptions;
    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;

// Constructeur et accesseurs (getters) et mutateurs (setters)
}