package Hackathon.DopamineMarket.domain.user.domain;

import Hackathon.DopamineMarket.domain.app.domain.App;
import Hackathon.DopamineMarket.domain.routine.domain.Routine;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "nickname", nullable = false, length = 100)
    private String nickname;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "coin", nullable = false)
    private int coin = 0;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Routine> routines = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<App> apps = new ArrayList<>();
}
