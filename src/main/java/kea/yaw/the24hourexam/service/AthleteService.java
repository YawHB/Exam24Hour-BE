package kea.yaw.the24hourexam.service;

import kea.yaw.the24hourexam.model.Athlete;
import kea.yaw.the24hourexam.model.Discipline;
import kea.yaw.the24hourexam.repository.AthleteRepository;
import kea.yaw.the24hourexam.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class AthleteService {

    private final AthleteRepository athleteRepository;
    private final DisciplineRepository disciplineRepository;

    public AthleteService(AthleteRepository athleteRepository, DisciplineRepository disciplineRepository) {
        this.athleteRepository = athleteRepository;
        this.disciplineRepository = disciplineRepository;
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

    public Optional<Athlete> createAthlete(Athlete athlete) {
        // Fetch the disciplines from the database
        //
      fetchAndSetDisciplines(athlete);

        // Save the athlete object
        return Optional.of(athleteRepository.save(athlete));
    }

    public Optional<Athlete> updateAthlete(Long id, Athlete athlete) {
        Optional<Athlete> athleteEntity = athleteRepository.findById(id);
        if (athleteEntity.isPresent()) {

            fetchAndSetDisciplines(athlete);

            Athlete originalAthlete = athleteEntity.get();
            originalAthlete.setName(athlete.getName());
            originalAthlete.setSex(athlete.getSex());
            originalAthlete.setAge(athlete.getAge());
            originalAthlete.setClub(athlete.getClub());
            originalAthlete.setDisciplines(athlete.getDisciplines());
            return Optional.of(athleteRepository.save(originalAthlete));
        } else {
            return Optional.empty();
        }
    }

    private void fetchAndSetDisciplines(Athlete athlete) {
        Set<Discipline> disciplines = athlete.getDisciplines().stream()
                .map(discipline -> disciplineRepository.findByName(discipline.getName()).orElse(discipline))
                .collect(Collectors.toSet());
        athlete.setDisciplines(disciplines);
    }

    public Optional<Athlete> findByName(String name) {
        Optional<Athlete> athlete = athleteRepository.findByName(name);
        if (athlete.isPresent()) {
            return athlete;
        } else {
            return Optional.empty();
        }
    }
}
