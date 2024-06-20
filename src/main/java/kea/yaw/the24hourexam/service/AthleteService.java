package kea.yaw.the24hourexam.service;

import kea.yaw.the24hourexam.model.Athlete;
import kea.yaw.the24hourexam.repository.AthleteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;

    public AthleteService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }


    public List<Athlete> getAllAthletes() {
        return  athleteRepository.findAll();
    }


    public Optional<Athlete> findById(Long id) {
        Optional <Athlete> athlete =  athleteRepository.findById(id);
        if(athlete.isPresent()){
            return athlete;
    } else {
        return Optional.empty();
    }
    }
}
