package com.example.its.webUI.Controller;
import com.example.its.status.StatusManager;
import com.example.its.webUI.Controller.Exception.LoginException;
import com.example.its.webUI.Controller.Exception.LoginUnrequiredException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    @GetMapping("/")
    public String root(){
        if(StatusManager.getInstance().getUser()!=null)
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

    public static void isUserLogin() throws LoginException {
        if(StatusManager.getInstance().getUser()== null)
            throw new LoginException();

    }

    public static void isLoginAvailable()throws LoginUnrequiredException{
        if(StatusManager.getInstance().getUser()!=null)
            throw new LoginUnrequiredException();
    }




}

