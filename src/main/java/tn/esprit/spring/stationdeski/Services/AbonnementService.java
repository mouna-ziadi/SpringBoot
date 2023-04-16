package tn.esprit.spring.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.stationdeski.entities.Abonnement;
import tn.esprit.spring.stationdeski.entities.Skieur;
import tn.esprit.spring.stationdeski.entities.TypeAbonnement;
import tn.esprit.spring.stationdeski.repositories.AbonnementRepository;
import tn.esprit.spring.stationdeski.repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
@AllArgsConstructor
public class AbonnementService implements IAbonnementService{

    AbonnementRepository abonnementRepository;

    SkieurRepository skieurRepository;
    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return (List<Abonnement>) abonnementRepository.findAll();
    }

    @Override
    public Abonnement addAbonnement(Abonnement e) {
        return abonnementRepository.save(e);
    }

    @Override
    public Abonnement updateAbonnement(Abonnement e) {
        return abonnementRepository.save(e);
    }

    @Override
    public Abonnement retrieveAbonnement(Integer idAbonnement) {
        return abonnementRepository.findById(idAbonnement).get();
    }

    @Override
    public void deleteAbonnement(Integer idAbonnement) {
        abonnementRepository.deleteById(idAbonnement);
    }

    @Override
    public Set<Abonnement> getAbonnementByType(TypeAbonnement type) {
       Set<Abonnement> ab = (Set<Abonnement>) abonnementRepository.findByTypeAbonnement(type);
       return ab;
    }

   // @Scheduled(cron = "*/15 * * * * *")
    /*public void retrieveSubscriptions(){
        LocalDate dateFin = LocalDate.now().plusDays(7);
        List<Abonnement> list = abonnementRepository.findByDateFinBefore(dateFin);
        for (Abonnement ab : list) {
            Skieur s = skieurRepository.findById(ab.getIdAbonnement()).orElse(null);
            if (s != null) {
                System.out.println("Skieur " +s.getNomS() + " " + s.getPrenomS() + "Num Skieur " + s.getNumSkieur());
            }
        }

    }*/
   // @Scheduled(cron = "*/15 * * * * *")
    /*public void retrieveSubscriptions1(){
        LocalDate today = LocalDate.now();
        LocalDate dateExpera = today.plusDays(7);

        for (Abonnement ab : abonnementRepository.findByDateFinBefore(dateExpera)) {
            Skieur s = skieurRepository.findById(ab.getIdAbonnement()).orElse(null);
            if (s != null) {
                System.out.println("Skieur " +s.getNomS() + " " + s.getPrenomS() + "Num Skieur " + s.getNumSkieur());
            }
        }

    }*/

   // @Scheduled(cron = "*/15 * * * * *")
   /* public void showMonthlyRecurringRevenue() {
        LocalDate now = LocalDate.now();
        List<Abonnement> abonnements = abonnementRepository.findByDateDebutBeforeAndDateFinAfter(now, now);

        float revenuMensuel = 0;
        for (Abonnement abonnement : abonnements) {
            revenuMensuel += abonnement.getPrixAbon();
        }

        System.out.println("Le revenu récurrent mensuel est:" + revenuMensuel);
    }*/


}
