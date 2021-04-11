package cat.itb.springforum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String login() { return "redirect::/login"; }

    @GetMapping("/register")
    public String register() { return "redirect::/register"; }
}
