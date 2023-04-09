package tn.esprit.spring.stationdeski.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.stationdeski.Services.IMoniteurService;
import tn.esprit.spring.stationdeski.Services.IPisteService;
import tn.esprit.spring.stationdeski.Services.ISkieurService;
import tn.esprit.spring.stationdeski.entities.Piste;
import tn.esprit.spring.stationdeski.entities.Skieur;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/skieur")
public class SkieurRestController {
    ISkieurService skieurService;
    IPisteService pisteService;
    @GetMapping("/retrieve-all-skieurs")
    public List<Skieur> getSkieurs(){
        List<Skieur> listSkieurs = skieurService.retrieveAllSkieurs();
        return listSkieurs;
    }

    @GetMapping("/retrieve-skieur/{skieur-id}")
    public Skieur retrieveSkieur(@PathVariable("skieur-id")Integer skieurId){
        return skieurService.retrieveSkieur(skieurId);
    }
    @PostMapping("/add-skieur")
    public Skieur addSkieur(@RequestBody Skieur m) {
        Skieur skieur = skieurService.addSkieur(m);
        return skieur;
    }

    @DeleteMapping("/remove-skieur/{skieur-id}")
    public void removeSkieur(@PathVariable("skieur-id") Integer skieurId) {
        skieurService.deleteSkieur(skieurId);
    }
    @PutMapping("/update-skieur")
    public Skieur updateSkieur(@RequestBody Skieur m) {
        Skieur skieur= skieurService.updateSkieur(m);
        return skieur;
    }

    @PutMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    public Skieur assignSkieurToPiste(@PathVariable("numSkieur") Long numSkieur, @PathVariable("numPiste") Long numPiste) {
     Skieur s = skieurService.assignSkieurToPiste(numSkieur,numPiste);
      return  s;
    }
    }

