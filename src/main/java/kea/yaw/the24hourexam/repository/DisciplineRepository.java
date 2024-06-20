package kea.yaw.the24hourexam.repository;

import kea.yaw.the24hourexam.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
     Optional<Discipline> findByName(String name);
}