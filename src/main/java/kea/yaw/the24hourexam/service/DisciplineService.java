package kea.yaw.the24hourexam.service;

import kea.yaw.the24hourexam.model.Discipline;
import kea.yaw.the24hourexam.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {


   private  final DisciplineRepository disciplineRepository;

        public DisciplineService(DisciplineRepository disciplineRepository) {
            this.disciplineRepository = disciplineRepository;
        }

    public  List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();

    }
}
