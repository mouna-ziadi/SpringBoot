package tn.esprit.spring.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.stationdeski.entities.Cours;
import tn.esprit.spring.stationdeski.entities.Moniteur;
import tn.esprit.spring.stationdeski.entities.Support;
import tn.esprit.spring.stationdeski.repositories.CoursRepository;
import tn.esprit.spring.stationdeski.repositories.MoniteurRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CoursService implements ICoursService{

    CoursRepository coursRepository;
    MoniteurRepository moniteurRepository;

    @Override
    public List<Cours> retrieveAllCours() {
        return (List<Cours>) coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours e) {
        return coursRepository.save(e);
    }

    @Override
    public Cours updateCours(Cours e) {
        return coursRepository.save(e);
    }

    @Override
    public Cours retrieveCours(Integer idCours) {
        return coursRepository.findById(idCours).get();
    }

    @Override
    public void deleteCours(Integer idCours) {
        coursRepository.deleteById(idCours);
    }

    @Override
    public List<Integer> numWeeksCourseOfMoniteurBySupport(Long numMoniteur, Support support) {
        List<Integer> list =new ArrayList<>();
        Moniteur m= moniteurRepository.findMoniteurByNumMoniteur(numMoniteur);
        List<Cours> listCours =coursRepository.findCoursBySupport(support);
        for (Cours c:listCours) {
            Integer integer=coursRepository.getCoursBySupport(support);
            list.add(integer);

        }

        return list;

    }
}
