package kea.yaw.the24hourexam.controller;

import kea.yaw.the24hourexam.model.Athlete;
import kea.yaw.the24hourexam.service.AthleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/athletes")
public class AthleteController {


   private final AthleteService athleteService;

    public AthleteController(AthleteService athleteService) {
        this.athleteService = athleteService;
    }


    @GetMapping()
    public ResponseEntity<List<Athlete>> getAllAthletes() {
       return ResponseEntity.ok(athleteService.getAllAthletes());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Athlete> getSingleAthlete(@PathVariable Long id) {

        Optional<Athlete> athlete = athleteService.findById(id);
        if (athlete.isPresent()) {
            return ResponseEntity.ok(athlete.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
