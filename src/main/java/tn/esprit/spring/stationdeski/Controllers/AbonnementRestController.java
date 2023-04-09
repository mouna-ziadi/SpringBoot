package tn.esprit.spring.stationdeski.Controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.stationdeski.Services.IAbonnementService;
import tn.esprit.spring.stationdeski.entities.Abonnement;
import tn.esprit.spring.stationdeski.entities.TypeAbonnement;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/abonnement")
@Tag(name="Abonnement Managment")
public class AbonnementRestController {


    IAbonnementService abonnementService;
    // http://127.0.0.1:8092/stationSki/swagger-ui/retrieve-all-abonnements
    @GetMapping("/retrieve-all-abonnements")
    @Operation(description = "afficher tous les abonnements")
    public List<Abonnement> getAbonnements(){
        List<Abonnement> listAbonnements = abonnementService.retrieveAllAbonnements();
        return listAbonnements;
    }

    // http://127.0.0.1:8092/stationSki/swagger-ui/retrieve-abonnement/2
    @Operation(description = "afficher l'abonnemnt par son id")
    @GetMapping("/retrieve-abonnement/{abonnement-id}")
    public Abonnement retrieveMoniteur(@PathVariable("abonnement-id")Integer abonnementId){
        return abonnementService.retrieveAbonnement(abonnementId);
    }
    // http://127.0.0.1:8092/stationSki/swagger-ui/add-abonnement
    @Operation(description = "ajouter un abonnement")
    @PostMapping("/add-abonnement")
    public Abonnement addMoniteur(@RequestBody Abonnement m) {
        Abonnement moniteur = abonnementService.addAbonnement(m);
        return moniteur;
    }

    // http://127.0.0.1:8092/stationSki/swagger-ui/add-abonnement
    @Operation(description = "ajouter un abonnement")
    @DeleteMapping("/remove-moniteur/{abonnement-id}")
    public void removeMoniteur(@PathVariable("abonnement-id") Integer moniteurId) {
        abonnementService.deleteAbonnement(moniteurId);
    }

    // http://127.0.0.1:8092/stationSki/swagger-ui/update-abonnement
    @Operation(description = "update abonnement")
    @PutMapping("/update-abonnement")
    public Abonnement updateMoniteur(@RequestBody Abonnement m) {
        Abonnement abonnement= abonnementService.updateAbonnement(m);
        return abonnement;
    }
   /* @GetMapping
    public Set<Abonnement> getAbonnements (TypeAbonnement type){
        Set<Abonnement> ab = abonnementService.getAbonnementByType(type);
        return ab;
    }*/

    // http://127.0.0.1:8092/stationSki/swagger-ui/getAbonnementByType/type
    @Operation(description = "get abonnement par type")
    @GetMapping("/getAbonnementByType/{type}")
    public Set<Abonnement> getAbonnementByType(@PathVariable("type") TypeAbonnement type){
        return abonnementService.getAbonnementByType(type);
    }
}
