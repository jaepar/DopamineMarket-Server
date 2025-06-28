package Hackathon.DopamineMarket.domain.routine.controller;

import Hackathon.DopamineMarket.domain.routine.dto.request.PostRoutineCreateRequest;
import Hackathon.DopamineMarket.domain.routine.dto.response.GetRoutineListResponse;
import Hackathon.DopamineMarket.domain.routine.dto.response.PostRoutineCreateResponse;
import Hackathon.DopamineMarket.domain.routine.service.RoutineService;
import Hackathon.DopamineMarket.global.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routines")
@RequiredArgsConstructor
public class RoutineController {

    private final RoutineService routineService;

    @PostMapping
    public BaseResponse<PostRoutineCreateResponse> createRoutine(@RequestBody PostRoutineCreateRequest request) {
        return BaseResponse.ok(routineService.createRoutine(request));
    }

    @GetMapping
    public BaseResponse<GetRoutineListResponse> getRoutineList(@RequestParam(name = "userId") Long userId) {
        return BaseResponse.ok(routineService.getRoutines(userId));
    }

    @PostMapping("/{routineId}/complete")
    public BaseResponse<Void> completeRoutine(@PathVariable(name = "routineId") Long routineId) {
        routineService.completeRoutine(routineId);
        return BaseResponse.ok(null);
    }

}
