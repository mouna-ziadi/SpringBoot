package tn.esprit.spring.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.stationdeski.entities.Cours;
import tn.esprit.spring.stationdeski.entities.Inscription;
import tn.esprit.spring.stationdeski.entities.Skieur;
import tn.esprit.spring.stationdeski.repositories.CoursRepository;
import tn.esprit.spring.stationdeski.repositories.InscriptionRepository;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class InscriptionService implements IInscriptionService{

    InscriptionRepository inscriptionRepository;
    CoursRepository coursRepository;
    @Override
    public List<Inscription> retrieveAllInscriptions() {
        return (List<Inscription>) inscriptionRepository.findAll();
    }

    @Override
    public Inscription addInscription(Inscription e) {
        return inscriptionRepository.save(e);
    }

    @Override
    public Inscription updateInscription(Inscription e) {
        return inscriptionRepository.save(e);
    }

    @Override
    public Inscription retrieveInscription(Integer idInscription) {
        return inscriptionRepository.findById(idInscription).get();
    }

    @Override
    public void deleteInscription(Integer idInscription) {
        inscriptionRepository.deleteById(idInscription);
    }

   /* @Override
    public Inscription assignInscriptionToCours(Long numInscription, Long numCours) {
        Inscription i = inscriptionRepository.findInscriptionBy(numInscription);
        Cours c = coursRepository.findByNumCours(numCours);
        List<Inscription> inscriptions = (List<Inscription>) i.getCours();
        for (Inscription ins: inscriptions){
            ins.setCours(c);
        }
        return i;
    }*/



}
