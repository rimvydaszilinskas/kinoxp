package antelopes.kinoxp.controllers;

import org.springframework.web.bind.annotation.PostMapping;

public class LoginController {


    @PostMapping("/login")
    public String login() {

        return "login";
    }
}
