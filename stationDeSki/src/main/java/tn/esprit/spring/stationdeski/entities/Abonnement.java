package tn.esprit.spring.stationdeski.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Abonnement")
public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAbonnement")
    private Integer idAbonnement; // Clé primaire
    private Long numAbonnement;
    //@Temporal(TemporalType.DATE)
    private Date dateDebut;
    //private Localate dateDebut;
    private Date dateFin;
    //private Localate dateFin;
    private float prixAbon;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement TypeAbonnement;


// Constructeur et accesseurs (getters) et mutateurs (setters)
}
