package tn.esprit.spring.stationdeski.Services;

import tn.esprit.spring.stationdeski.entities.Cours;

import java.util.List;

public interface ICoursService {

    List<Cours> retrieveAllCours();

    Cours addCours(Cours e);

    Cours updateCours (Cours e);

    Cours retrieveCours (Integer idCours);

    void deleteCours( Integer idCours);
}
