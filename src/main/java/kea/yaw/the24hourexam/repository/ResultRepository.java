package kea.yaw.the24hourexam.repository;

import kea.yaw.the24hourexam.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
