package kea.yaw.the24hourexam.controller;

import kea.yaw.the24hourexam.model.Athlete;
import kea.yaw.the24hourexam.service.AthleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/name/{name}")
    public ResponseEntity<Athlete> getSingleAthlete(@PathVariable String name) {

        Optional<Athlete> athlete = athleteService.findByName(name);
        if (athlete.isPresent()) {
            return ResponseEntity.ok(athlete.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Athlete> createAthlete(@RequestBody Athlete athlete) {
        Optional<Athlete> newAthlete = athleteService.createAthlete(athlete);
        if (newAthlete.isPresent()) {
            return ResponseEntity.status(201).body(newAthlete.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Athlete> updateAthlete(@PathVariable Long id, @RequestBody Athlete athlete) {
        Optional<Athlete> updatedAthlete = athleteService.updateAthlete(id, athlete);
        if (updatedAthlete.isPresent()) {
            return ResponseEntity.ok(updatedAthlete.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAthlete(@PathVariable Long id) {
        Optional<Athlete> deletedAthlete = athleteService.deleteAthlete(id);
        if (deletedAthlete.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
