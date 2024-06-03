package com.example.its.webUI.Controller.Statistic;

import com.example.its.logic.StatisticService;
import com.example.its.state.StateManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class StatisticController {

    private final StateManager stateManager;
    private final StatisticService statisticService;

    @GetMapping("/statistic")
    public String statistic(Model model) {

        model.addAttribute("count3MostCommentinIssueService",statisticService.count3MostCommentinIssueService(stateManager.getUser()));
        model.addAttribute("countAvgofCommentService",statisticService.countAvgofCommentService(stateManager.getUser()));
        return "statistic";
    }

}
