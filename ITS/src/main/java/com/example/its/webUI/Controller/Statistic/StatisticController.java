package com.example.its.webUI.Controller.Statistic;

import com.example.its.dataClass.Project;
import com.example.its.logic.Exception.LoginRequiredException;
import com.example.its.logic.StatisticService;
import com.example.its.state.StateManager;
import com.example.its.webUI.Controller.MainController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class StatisticController {

    private final StateManager stateManager;
    private final StatisticService statisticService;

    @GetMapping("/statistic")
    public String statistic(Model model) throws LoginRequiredException {
        MainController.isUserLogin(stateManager);
        List<Integer> list = statisticService.issuePerProject(stateManager.getUser());
        for(Integer i : list){
            System.out.println(i);
        }
        model.addAttribute("issuePerProject", list);
        model.addAttribute("project", statisticService.getProjectList(stateManager.getUser()));
        return "statistic";
    }

}
