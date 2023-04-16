package tn.esprit.spring.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.stationdeski.entities.Couleur;
import tn.esprit.spring.stationdeski.entities.Piste;
import tn.esprit.spring.stationdeski.entities.Skieur;
import tn.esprit.spring.stationdeski.repositories.PisteRepository;
import tn.esprit.spring.stationdeski.repositories.SkieurRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
public class PisteService implements IPisteService{

    PisteRepository pisteRepository;
    SkieurRepository skieurRepository;
    @Override
    public List<Piste> retrieveAllPistes() {
        return (List<Piste>) pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste e) {
        return pisteRepository.save(e);
    }

    @Override
    public Piste updatePiste(Piste e) {
        return pisteRepository.save(e);
    }

    @Override
    public Piste retrievePiste(Integer idPiste) {
        return pisteRepository.findById(idPiste).get();
    }

    @Override
    public void deletePiste(Integer idPiste) {
        pisteRepository.deleteById(idPiste);
    }

   // @Override
   /* public HashMap<Couleur,Integer> nombreSkieursParCouleurPiste() {
        HashMap<Couleur,Integer> nombreSkieursParCouleur = new HashMap<>();

        List<Piste> pistes = new ArrayList<>();
        for (Piste piste : pistes) {
            Couleur couleurPiste = piste.getCouleur();
            int nombreSkieurs = pisteRepository.getPistesBySkieurs(couleurPiste);
            if (nombreSkieursParCouleur.containsKey(couleurPiste)) {

                nombreSkieursParCouleur.put(couleurPiste, nombreSkieursParCouleur.get(couleurPiste) + nombreSkieurs);
            } else {

                nombreSkieursParCouleur.put(couleurPiste, nombreSkieurs);
            }
        }
        return nombreSkieursParCouleur;
    }*/

    @Override
    public HashMap<Couleur,Integer> nombreSkieursParCouleurPiste() {
        HashMap<Couleur,Integer> nombreSkieursParCouleur = new HashMap<>();

        //Couleur couleurs[]= Couleur.values()
        int nbskieurs =0;
        for (Couleur c: Couleur.values()) {

            nbskieurs = skieurRepository.skieurByCouleurPiste(c).size();
                nombreSkieursParCouleur.put(c, nbskieurs);

        }
        return nombreSkieursParCouleur;
    }
}
