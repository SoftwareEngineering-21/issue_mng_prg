package com.example.its.webUI.Controller;
import com.example.its.state.StateManager;
import com.example.its.logic.Exception.LoginRequiredException;
import com.example.its.logic.Exception.LoginUnrequiredException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final StateManager stateManager;
    @GetMapping("/")
    public String root(){
        if(stateManager.getUser()!=null)
            return "redirect:/projects";
        else{
            return "redirect:/login";
        }
    }

    @GetMapping("/demo")
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String test(@RequestParam(name = "tester", required = false)String tester , Model model ) {
        model.addAttribute("toggle", Arrays.asList("a", "b"));
        return "test/testLayout";
    }

    public static void isUserLogin(StateManager stateManager) throws LoginRequiredException {
        if(stateManager.getUser()== null)
            throw new LoginRequiredException();

    }

    public static void isLoginAvailable(StateManager stateManager)throws LoginUnrequiredException{
        if(stateManager.getUser()!=null)
            throw new LoginUnrequiredException();
    }




}

