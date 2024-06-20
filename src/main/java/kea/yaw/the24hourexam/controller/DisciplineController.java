package kea.yaw.the24hourexam.controller;

import kea.yaw.the24hourexam.model.Discipline;
import kea.yaw.the24hourexam.service.DisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {


    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }


    @GetMapping()
    public ResponseEntity<List<Discipline>> getAllDisciplines() {
        return ResponseEntity.ok(disciplineService.getAllDisciplines());
    }
}
