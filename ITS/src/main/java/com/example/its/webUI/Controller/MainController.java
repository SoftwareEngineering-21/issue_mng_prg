package com.example.its.webUI.Controller;
import com.example.its.status.StatusManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    @GetMapping("/")
    public String root(){
        if(isUserLogin()!=null)
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
    public String test(@RequestParam(name = "tester", required = false)String tester  ) {
        return "test/testLayout";
    }

    public static String isUserLogin(){
        if(StatusManager.getInstance().getUser()!= null)
            return "redirect:/";
        return null;
    }




}

