package tn.esprit.spring.stationdeski.Services;

import tn.esprit.spring.stationdeski.entities.Moniteur;

import java.util.List;

public interface IMoniteurService {

    List<Moniteur> retrieveAllMoniteurs();

    Moniteur addMoniteur(Moniteur e);

    Moniteur updateMoniteur (Moniteur e);

    Moniteur retrieveMoniteur (Integer idMoniteur);

    void deleteMoniteur( Integer idMoniteur);

    Moniteur addMoniteurAndAssignToCours(Moniteur moniteur);


}
