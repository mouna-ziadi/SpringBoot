package tn.esprit.spring.stationdeski.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.stationdeski.Services.IMoniteurService;
import tn.esprit.spring.stationdeski.entities.Moniteur;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/moniteur")
public class MoniteurRestController {
    IMoniteurService moniteurService;
    @GetMapping("/retrieve-all-moniteurs")
    public List<Moniteur>getMoniteurs(){
        List<Moniteur> listMoniteurs = moniteurService.retrieveAllMoniteurs();
        return listMoniteurs;
    }

    @GetMapping("/retrieve-moniteur/{moniteur-id}")
    public Moniteur retrieveMoniteur(@PathVariable("moniteur-id")Integer moniteurId){
        return moniteurService.retrieveMoniteur(moniteurId);
    }
    @PostMapping("/add-moniteur")
    public Moniteur addMoniteur(@RequestBody Moniteur m) {
        Moniteur moniteur = moniteurService.addMoniteur(m);
        return moniteur;
    }

    @DeleteMapping("/remove-moniteur/{moniteur-id}")
    public void removeMoniteur(@PathVariable("moniteur-id") Integer moniteurId) {
        moniteurService.deleteMoniteur(moniteurId);
    }
    @PutMapping("/update-moniteur")
    public Moniteur updateMoniteur(@RequestBody Moniteur m) {
        Moniteur moniteur= moniteurService.updateMoniteur(m);
        return moniteur;
    }

    @PostMapping("/addMoniteurAndAssignToCours")
    public Moniteur addMoniteurAndAssignToCours(@RequestBody Moniteur m) {
        Moniteur moniteur = moniteurService.addMoniteurAndAssignToCours(m);
        return moniteur;
    }

}
