package kea.yaw.the24hourexam.repository;

import kea.yaw.the24hourexam.model.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {
}
