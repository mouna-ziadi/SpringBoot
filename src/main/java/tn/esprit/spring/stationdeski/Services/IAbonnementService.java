package tn.esprit.spring.stationdeski.Services;

import tn.esprit.spring.stationdeski.entities.Abonnement;
import tn.esprit.spring.stationdeski.entities.TypeAbonnement;

import java.util.List;
import java.util.Set;

public interface IAbonnementService {

    List<Abonnement> retrieveAllAbonnements();

    Abonnement addAbonnement(Abonnement e);

    Abonnement updateAbonnement (Abonnement e);

    Abonnement retrieveAbonnement (Integer idAbonnement);

    void deleteAbonnement( Integer idAbonnement);
    Set<Abonnement> getAbonnementByType(TypeAbonnement type);


}
