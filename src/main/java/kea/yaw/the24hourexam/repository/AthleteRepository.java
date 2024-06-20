package kea.yaw.the24hourexam.repository;

import kea.yaw.the24hourexam.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    Optional<Athlete> findByName(String name);
}
