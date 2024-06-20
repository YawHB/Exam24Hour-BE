package kea.yaw.the24hourexam.controller;

import kea.yaw.the24hourexam.model.Athlete;
import kea.yaw.the24hourexam.service.AthleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
