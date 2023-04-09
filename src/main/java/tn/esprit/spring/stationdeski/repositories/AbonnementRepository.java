package tn.esprit.spring.stationdeski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.stationdeski.entities.Abonnement;
import tn.esprit.spring.stationdeski.entities.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;

public interface AbonnementRepository extends CrudRepository<Abonnement, Integer> {
    Abonnement findByTypeAbonnement(TypeAbonnement type);
    //Abonnement findByDateDebutBetween(LocalDate dateDebut, LocalDate dateFin);

    List<Abonnement> findByDateFinBefore(LocalDate dateFin);

    List<Abonnement> findByDateDebutBeforeAndDateFinAfter(LocalDate x, LocalDate y);

}
