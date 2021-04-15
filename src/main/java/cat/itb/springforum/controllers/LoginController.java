package cat.itb.springforum.controllers;

import cat.itb.springforum.model.entities.UserForum;
import cat.itb.springforum.model.services.UserForumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController
{
    @GetMapping("/login")
    public String login() { return "redirect::/login"; }

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("user", new UserForum());
        return "register";
    }

    @PostMapping("/register/submit")
    public String resgisterUser(@ModelAttribute("user") UserForum user)
    {
        UserForumService.add(user);
        return "list";
    }
}
