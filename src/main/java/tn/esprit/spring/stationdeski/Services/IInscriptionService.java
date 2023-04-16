package tn.esprit.spring.stationdeski.Services;

import tn.esprit.spring.stationdeski.entities.Inscription;

import java.util.List;

public interface IInscriptionService {

    List<Inscription> retrieveAllInscriptions();

    Inscription addInscription(Inscription e);

    Inscription updateInscription (Inscription e);

    Inscription retrieveInscription (Integer idInscription);

    void deleteInscription( Integer idInscription);

    Inscription addInscriptionAndAssignToSkieurAndCours(Inscription inscri, Long numSkieur, Long numCours);

    // Inscription assignInscriptionToCours(Long numInscription, Long numCours);
}
