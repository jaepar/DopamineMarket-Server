package Hackathon.DopamineMarket.domain.routine.repository;

import Hackathon.DopamineMarket.domain.routine.domain.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutineRepository extends JpaRepository<Routine, Long> {

}
