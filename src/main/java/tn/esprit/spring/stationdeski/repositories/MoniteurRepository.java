package tn.esprit.spring.stationdeski.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import tn.esprit.spring.stationdeski.entities.Moniteur;




public interface MoniteurRepository extends JpaRepository<Moniteur, Integer> {
    //PagingAndSortingRepository
    //JpaRepository
    //CrudRepository

}
