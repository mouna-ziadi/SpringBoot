package tn.esprit.spring.stationdeski.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.stationdeski.Services.IMoniteurService;
import tn.esprit.spring.stationdeski.Services.IPisteService;
import tn.esprit.spring.stationdeski.entities.Couleur;
import tn.esprit.spring.stationdeski.entities.Piste;

import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/piste")
public class PisteRestController {
    IPisteService pisteService;
    @GetMapping("/retrieve-all-pistes")
    public List<Piste> getPistes(){
        List<Piste> listPistes = pisteService.retrieveAllPistes();
        return listPistes;
    }

    @GetMapping("/retrieve-piste/{piste-id}")
    public Piste retrievePiste(@PathVariable("piste-id")Integer pisteId){
        return pisteService.retrievePiste(pisteId);
    }
    @PostMapping("/add-piste")
    public Piste addPiste(@RequestBody Piste m) {
        Piste piste = pisteService.addPiste(m);
        return piste;
    }

    @DeleteMapping("/remove-piste/{piste-id}")
    public void removePiste(@PathVariable("piste-id") Integer pisteId) {
        pisteService.deletePiste(pisteId);
    }
    @PutMapping("/update-piste")
    public Piste updateMoniteur(@RequestBody Piste m) {
        Piste piste= pisteService.updatePiste(m);
        return piste;
    }

    @GetMapping("/nombreSkieursParCouleurPiste")
    public HashMap<Couleur,Integer> nombreSkieursParCouleurPiste(){
        return pisteService.nombreSkieursParCouleurPiste();
    }
}
