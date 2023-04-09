package tn.esprit.spring.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.stationdeski.entities.*;
import tn.esprit.spring.stationdeski.repositories.AbonnementRepository;
import tn.esprit.spring.stationdeski.repositories.CoursRepository;
import tn.esprit.spring.stationdeski.repositories.PisteRepository;
import tn.esprit.spring.stationdeski.repositories.SkieurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkieurService implements ISkieurService {

    SkieurRepository skieurRepository;
    PisteRepository pisteRepository;

    CoursRepository coursRepository;

    AbonnementRepository abonnementRepository;
    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return (List<Skieur>) skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur e) {
        return skieurRepository.save(e);
    }

    @Override
    public Skieur updateSkieur(Skieur e) {
        return skieurRepository.save(e);
    }

    @Override
    public Skieur retrieveSkieur(Integer idSkieur) {
        return skieurRepository.findById(idSkieur).get();
    }

    @Override
    public void deleteSkieur(Integer idSkieur) {
        skieurRepository.deleteById(idSkieur);
    }


    @Transactional
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur s = skieurRepository.findByNumSkieur(numSkieur);
        Piste p = pisteRepository.findByNumPiste(numPiste);
        s.getPistes().add(p);
        return s;
    }

    @Transactional
    public Skieur addSkieurAndAssignToCours(Skieur skieur, Long numCours) {
        Cours c = coursRepository.findByNumCours(numCours);
        Skieur s = skieurRepository.save(skieur);
        Set<Inscription> inscriptions = s.getInscriptions();
        for(Inscription ins: inscriptions){
            ins.setCours(c);
        }
        return s;
    }

    @Transactional
    public List<Skieur> retrieveSkieursByAbonnementType(TypeAbonnement typeAbonnement) {
        Set<Abonnement> abon =(Set<Abonnement>) abonnementRepository.findByTypeAbonnement(typeAbonnement);
        Skieur s = new Skieur();
        List<Skieur> Lsk = new ArrayList<>();
        for(Abonnement ab:abon){
            Lsk = skieurRepository.findByAbonnement(ab);
        }
        return Lsk;
    }




}
