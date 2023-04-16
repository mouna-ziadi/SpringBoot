package tn.esprit.spring.stationdeski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring.stationdeski.entities.Couleur;
import tn.esprit.spring.stationdeski.entities.Piste;

import java.util.List;

public interface PisteRepository extends CrudRepository<Piste,Integer> {
    Piste findByNumPiste(Long numPiste);



}
