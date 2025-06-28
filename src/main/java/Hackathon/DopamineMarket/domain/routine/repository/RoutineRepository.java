package Hackathon.DopamineMarket.domain.routine.repository;

import Hackathon.DopamineMarket.domain.routine.domain.Routine;
import Hackathon.DopamineMarket.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutineRepository extends JpaRepository<Routine, Long> {
    List<Routine> findAllByUser(User user);
}
