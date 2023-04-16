package tn.esprit.spring.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.stationdeski.entities.Cours;
import tn.esprit.spring.stationdeski.entities.Inscription;
import tn.esprit.spring.stationdeski.entities.Skieur;
import tn.esprit.spring.stationdeski.entities.TypeCours;
import tn.esprit.spring.stationdeski.repositories.CoursRepository;
import tn.esprit.spring.stationdeski.repositories.InscriptionRepository;
import tn.esprit.spring.stationdeski.repositories.SkieurRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@AllArgsConstructor
public class InscriptionService implements IInscriptionService{

    InscriptionRepository inscriptionRepository;
    CoursRepository coursRepository;
    SkieurRepository skieurRepository;
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


    //@Override
   /* public Inscription addInscriptionAndAssignToSkieurAndCours(Inscription inscri, Long numSkieur, Long numCours) {
        Cours cours = coursRepository.findByNumCours(numCours);
        Skieur skieur = skieurRepository.findByNumSkieur(numSkieur);
        Period p= Period.between(skieur.getDateNaissance(), LocalDate.now());
        int finalDate=p.getYears();
        Long nb=inscriptionRepository.countInscriptionByCours(cours);

        if ((finalDate < 12)&&(finalDate>5 )|| ( finalDate < 35)&&(finalDate>20)){
            if (((cours.getTypeCours().equals("COLLECTIF_ADULTE")) || cours.getTypeCours().equals("COLLECTIF_ENFANT"))) {

                if(nb>=6) {
                    inscriptionRepository.save(inscri);
                    inscri.setCours(cours);
                    inscri.setSkieur(skieur);
                }
            }
        }
        return inscri;
    }*/

    @Override
    public Inscription addInscriptionAndAssignToSkieurAndCours(Inscription inscri, Long numSkieur, Long numCours) {
        Cours cours = coursRepository.findByNumCours(numCours);
        Skieur skieur = skieurRepository.findByNumSkieur(numSkieur);
        Period periode= Period.between(skieur.getDateNaissance(), LocalDate.now());
        int age=periode.getYears();
        Long nb=inscriptionRepository.countInscriptionByCours(cours);

        if (((age < 18) &&(cours.getTypeCours().equals(TypeCours.COLLECTIF_ENFRANT)))
                ||((age>18)&&(cours.getTypeCours().equals(TypeCours.COLLECTIF_ADULTE)))){
            if(nb<6) {
                inscriptionRepository.save(inscri);
                inscri.setCours(cours);
                inscri.setSkieur(skieur);
            }
        }
        return inscri;
    }



}
