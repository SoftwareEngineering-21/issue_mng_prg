package com.example.its.webUI.Controller;
import com.example.its.status.StatusManager;
import com.example.its.logic.Exception.LoginRequiredException;
import com.example.its.logic.Exception.LoginUnrequiredException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
public class MainController {

    private final StatusManager statusManager;
    @GetMapping("/")
    public String root(){
        if(statusManager.getUser()!=null)
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

    public static void isUserLogin(StatusManager statusManager) throws LoginRequiredException {
        if(statusManager.getUser()== null)
            throw new LoginRequiredException();

    }

    public static void isLoginAvailable(StatusManager statusManager)throws LoginUnrequiredException{
        if(statusManager.getUser()!=null)
            throw new LoginUnrequiredException();
    }




}

