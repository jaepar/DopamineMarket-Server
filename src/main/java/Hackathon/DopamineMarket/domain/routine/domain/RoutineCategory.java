package Hackathon.DopamineMarket.domain.routine.domain;

import lombok.Getter;

@Getter
public enum RoutineCategory {
    Exercise("운동"),
    LifeStyle("일상"),
    Learning("학습"),
    Diet("식단");

    private final String routineCategory;

    RoutineCategory(String routineCategory) {
        this.routineCategory = routineCategory;
    }

}
