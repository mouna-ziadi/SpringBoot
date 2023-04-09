package tn.esprit.spring.stationdeski.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.stationdeski.Services.IInscriptionService;
import tn.esprit.spring.stationdeski.Services.IMoniteurService;
import tn.esprit.spring.stationdeski.entities.Inscription;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/inscription")
public class InscriptionRestController {
    IInscriptionService inscriptionService;
    @GetMapping("/retrieve-all-inscriptions")
    public List<Inscription> getInscriptions(){
        List<Inscription> listInscriptions = inscriptionService.retrieveAllInscriptions();
        return listInscriptions;
    }

    @GetMapping("/retrieve-inscription/{inscription-id}")
    public Inscription retrieveInscription(@PathVariable("inscription-id")Integer inscriptionId){
        return inscriptionService.retrieveInscription(inscriptionId);
    }
    @PostMapping("/add-inscription")
    public Inscription addInscription(@RequestBody Inscription m) {
        Inscription inscription = inscriptionService.addInscription(m);
        return inscription;
    }

    @DeleteMapping("/remove-inscription/{inscription-id}")
    public void removeInscription(@PathVariable("inscription-id") Integer inscriptionId) {
        inscriptionService.deleteInscription(inscriptionId);
    }
    @PutMapping("/update-inscription")
    public Inscription updateInscription(@RequestBody Inscription m) {
        Inscription inscription= inscriptionService.updateInscription(m);
        return inscription;
    }
}
