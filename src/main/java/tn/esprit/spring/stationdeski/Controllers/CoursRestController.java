package tn.esprit.spring.stationdeski.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.stationdeski.Services.ICoursService;
import tn.esprit.spring.stationdeski.Services.IMoniteurService;
import tn.esprit.spring.stationdeski.entities.Cours;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/cours")
public class CoursRestController {
    ICoursService courService;
    @GetMapping("/retrieve-all-cours")
    public List<Cours> getCours(){
        List<Cours> listCours = courService.retrieveAllCours();
        return listCours;
    }

    @GetMapping("/retrieve-cour/{cour-id}")
    public Cours retrieveCours(@PathVariable("cour-id")Integer courId){
        return courService.retrieveCours(courId);
    }
    @PostMapping("/add-cour")
    public Cours addCours(@RequestBody Cours m) {
        Cours cour = courService.addCours(m);
        return cour;
    }

    @DeleteMapping("/remove-cour/{cour-id}")
    public void removeCours(@PathVariable("cour-id") Integer courId) {
        courService.deleteCours(courId);
    }
    @PutMapping("/update-cour")
    public Cours updateMoniteur(@RequestBody Cours m) {
        Cours cour= courService.updateCours(m);
        return cour;
    }
}
