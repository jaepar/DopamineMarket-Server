package Hackathon.DopamineMarket.domain.routine.controller;

import Hackathon.DopamineMarket.domain.routine.dto.request.PostRoutineCreateRequest;
import Hackathon.DopamineMarket.domain.routine.dto.response.PostRoutineCreateResponse;
import Hackathon.DopamineMarket.domain.routine.service.RoutineService;
import Hackathon.DopamineMarket.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routines")
@RequiredArgsConstructor
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping
    public BaseResponse<PostRoutineCreateResponse> createRoutine(@RequestBody PostRoutineCreateRequest request) {
        return BaseResponse.ok(routineService.createRoutine(request));
    }

}
