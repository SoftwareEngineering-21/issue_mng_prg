package com.example.its.webUI.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    @GetMapping("/")
    public String root(){
        return "redirect:/projects";
    }

    @GetMapping("/demo")
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        return "test/testLayout";
    }



}

