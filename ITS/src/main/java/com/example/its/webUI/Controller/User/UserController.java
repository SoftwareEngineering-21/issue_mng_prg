package com.example.its.webUI.Controller.User;

import com.example.its.dataClass.UserID;
import com.example.its.logic.UserService;
import com.example.its.state.StateManager;
import com.example.its.logic.Exception.LoginFailureException;
import com.example.its.logic.Exception.LoginUnrequiredException;
import com.example.its.webUI.Controller.MainController;
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
    private final StateManager stateManager;

    @GetMapping("/register")
    public String handleRegisterRequest(@RequestParam(name = "ID", required = false) String ID, @RequestParam(name = "password", required = false) String password, Model model) throws LoginUnrequiredException {
        MainController.isLoginAvailable(stateManager);
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
    public String login(@RequestParam(value = "ID", required = false) String ID, @RequestParam(value = "password", required = false) String password, Model model) throws LoginUnrequiredException, LoginFailureException {
        MainController.isLoginAvailable(stateManager);
        if (ID != null && password != null) {
            try {
                UserID id = userService.login(ID, password);
                stateManager.setUser(id);
                return "redirect:/";
            }
            catch(LoginFailureException e) {
                model.addAttribute("validation","fail");
                return "login";
            }
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        stateManager.setUser(null);
        return "redirect:/";
    }


}
