package tn.esprit.spring.stationdeski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.stationdeski.entities.Cours;
import tn.esprit.spring.stationdeski.entities.Inscription;

public interface InscriptionRepository extends CrudRepository<Inscription,Integer> {
    Long countInscriptionByCours(Cours cours);

    // Inscription findInscriptionBy (Long numInscription);
}
