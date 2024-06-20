package kea.yaw.the24hourexam.repository;

import kea.yaw.the24hourexam.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  DisciplineRepository extends JpaRepository<Discipline, Long> {
    Discipline findByName(String spydkast);
}
