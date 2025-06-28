package Hackathon.DopamineMarket.domain.app.repository;

import Hackathon.DopamineMarket.domain.app.domain.App;
import Hackathon.DopamineMarket.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppRepository extends JpaRepository<App, Long> {
    boolean existsByUserUserIdAndAppName(Long userId, String appName);
    List<App> findAllByUser(User user);
}
