package Hackathon.DopamineMarket.domain.app.repository;

import Hackathon.DopamineMarket.domain.app.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {
    boolean existsByUserUserIdAndAppName(Long userId, String appName);
}
