package com.example.its.webUI.statistic;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "graph";
    }
    
    @PostMapping("/updateGraph1")
    public String updateGraph1( @RequestParam("category") String category, @RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime) throws ParseException{
        //TODO: process POST request
        
        return entity;
    }
    
}
