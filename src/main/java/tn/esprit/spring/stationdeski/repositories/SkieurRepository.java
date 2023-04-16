package tn.esprit.spring.stationdeski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring.stationdeski.entities.Abonnement;
import tn.esprit.spring.stationdeski.entities.Couleur;
import tn.esprit.spring.stationdeski.entities.Skieur;

import java.util.List;

public interface SkieurRepository extends CrudRepository<Skieur,Integer> {

    Skieur findByNumSkieur(Long numSkieur);
    List<Skieur> findByAbonnement(Abonnement abonnement);

  //  int countSkieursByPistes(Couleur couleur);
  //  List<Skieur> findSkieurByPistes(Couleur couleur);

    @Query("select s from Skieur s join s.pistes p where p.couleur=:couleur")
    List<Skieur> skieurByCouleurPiste (@Param("couleur") Couleur couleur);
}
