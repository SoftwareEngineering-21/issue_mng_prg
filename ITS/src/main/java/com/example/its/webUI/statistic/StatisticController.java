package com.example.its.webUI.statistic;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.its.logic.StatisticService;
import com.example.its.logic.Exception.LoginRequiredException;
import com.example.its.state.StateManager;
import com.example.its.webUI.Controller.MainController;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
public class StatisticController {
    private final StateManager stateManager;
    private final StatisticService statisticService;

    @GetMapping("/statistic")
    public String getMethodName(Model model) throws LoginRequiredException{
        MainController.isUserLogin(stateManager);
        Map<String, Map<String, Object>> categoryData = new HashMap<>();
        Map<String, Object> initialData = new HashMap<>();
        initialData.put("data", new int[]{});
        initialData.put("labels", new String[]{});
        categoryData.put("Category 1", initialData);
        model.addAttribute("categoryData", categoryData);
        return "graph";
    }
    

    @GetMapping("/statistic/projectid={projectID}")
    public String getMethodName(@PathVariable("projectID") int projectID, Model model)throws LoginRequiredException {
        MainController.isUserLogin(stateManager);
        Map<String, Map<String, Object>> categoryData = new HashMap<>();
        categoryData.put("Category 1", new HashMap<>());
        model.addAttribute("categoryData", categoryData);
        model.addAttribute("projectID", projectID);
        return "secondgraph";
    }
    
    @ResponseBody
    @PostMapping("/updateGraph1")
    public Map<String, Object> updateGraph1(  @RequestParam("startDate") String startDate, @RequestParam("startTime") String startTime,@RequestParam("endDate") String endDate, @RequestParam("endTime") String endTime, Model model) throws ParseException{

        return statisticService.countAllofUploadIssue(stateManager.getUser(), statisticService.convertToTimestamp(startDate, startTime), statisticService.convertToTimestamp(endDate, endTime));
        
    }
    
}
