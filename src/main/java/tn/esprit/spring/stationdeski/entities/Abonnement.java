package tn.esprit.spring.stationdeski.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "Abonnement")
public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAbonnement")
    private Integer idAbonnement; // Clé primaire
    private Long numAbonnement;
    //@Temporal(TemporalType.DATE)
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    //private Localate dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    //private Localate dateFin;
    private float prixAbon;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;



    // Constructeur et accesseurs (getters) et mutateurs (setters)
}
