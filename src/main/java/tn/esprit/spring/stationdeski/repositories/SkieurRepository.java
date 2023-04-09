package tn.esprit.spring.stationdeski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.stationdeski.entities.Abonnement;
import tn.esprit.spring.stationdeski.entities.Skieur;

import java.util.List;

public interface SkieurRepository extends CrudRepository<Skieur,Integer> {

    Skieur findByNumSkieur(Long numSkieur);
    List<Skieur> findByAbonnement(Abonnement abonnement);
}
