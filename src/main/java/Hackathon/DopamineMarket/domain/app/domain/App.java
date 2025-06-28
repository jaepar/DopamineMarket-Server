package Hackathon.DopamineMarket.domain.app.domain;

import Hackathon.DopamineMarket.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.ConnectionBuilder;

@Entity
@Table(name = "app")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_id")
    private Long appId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "app_name", nullable = false, length = 50)
    private String appName;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String url;

    @Column(name = "coin_required", nullable = false)
    private int coinRequired = 3;

    @Column(name = "is_locked")
    private Boolean isLocked;

    @Builder
    public App(User user, String appName, String url, int coinRequired, Boolean isLocked) {
        this.user = user;
        this.appName = appName;
        this.url = url;
        this.coinRequired = coinRequired;
        this.isLocked = isLocked;
    }
}
