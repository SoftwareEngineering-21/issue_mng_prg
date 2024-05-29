package com.example.its.webUI.Controller.User;

import com.example.its.logic.UserService;
import com.example.its.status.StatusManager;
import com.example.its.webUI.Controller.Exception.LoginUnrequiredException;
import com.example.its.webUI.Controller.MainController;
import com.sun.tools.javac.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
//모든 유저에게 보이는 엔드 포인트
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String handleRegisterRequest(@RequestParam(name = "ID", required = false) String ID, @RequestParam(name = "password", required = false) String password, Model model) throws LoginUnrequiredException {
        MainController.isLoginAvailable();
        if (ID != null && password != null) {
            userService.createUser(ID, password);
            return "redirect:/login";
        } else if (ID != null) {
            if (userService.validateUser(ID)) {
                model.addAttribute("isValidate", userService.validateUser(ID));
                model.addAttribute("ID", ID);
            } else {
                model.addAttribute("validation", "fail");
                model.addAttribute("isValidate", false);
                model.addAttribute("ID", ID);
            }
        } else {
            model.addAttribute("isValidate", false);
        }
        // 뷰의 이름을 반환합니다. 이 경우, "register"라는 뷰를 사용할 것입니다.
        return "register";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "ID", required = false) String ID, @RequestParam(value = "password", required = false) String password, Model model) throws LoginUnrequiredException {
        MainController.isLoginAvailable();
        if (ID != null && password != null) {
            if (userService.login(ID, password)) {
                System.out.println("Login Success");
                return "redirect:/";
            } else {
                model.addAttribute("validation", "fail");
                return "login";
            }
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }


}
