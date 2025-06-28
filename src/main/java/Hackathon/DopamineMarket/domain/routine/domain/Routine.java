package Hackathon.DopamineMarket.domain.routine.domain;

import Hackathon.DopamineMarket.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "routine")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Routine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_id")
    private Long roudtineId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "routine_category", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoutineCategory category;

    @Column(name = "timer", nullable = false)
    private int timer; // 분 단위

    @Column(name = "is_daily", nullable = false)
    private boolean isDaily;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column
    private Boolean completed;

    @Builder
    public Routine(User user, String title, RoutineCategory category, int timer, boolean isDaily, LocalDateTime createdAt) {
        this.user = user;
        this.title = title;
        this.category = category;
        this.timer = timer;
        this.isDaily = isDaily;
        this.createdAt = createdAt;
        this.completed = false;
    }
}
