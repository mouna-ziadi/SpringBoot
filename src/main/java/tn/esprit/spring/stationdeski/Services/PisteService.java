package tn.esprit.spring.stationdeski.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring.stationdeski.entities.Piste;
import tn.esprit.spring.stationdeski.repositories.PisteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PisteService implements IPisteService{

    PisteRepository pisteRepository;
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
}
