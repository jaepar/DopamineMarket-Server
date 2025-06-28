package Hackathon.DopamineMarket.domain.user.repository;

import Hackathon.DopamineMarket.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
