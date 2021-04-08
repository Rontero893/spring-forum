package cat.itb.servlettest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorHola
{
    @GetMapping("/hola")
    public String exemple(@RequestParam("nom") String name, @RequestParam("cognom") String lastName, Model m)
    {
        m.addAttribute("personName", "Hola " + name + " " + lastName + "!");
        return "/hola";
    }

    @GetMapping("/hola/{nom}-{cognom}")
    public String exempleREST(@PathVariable("nom") String name, @PathVariable("cognom") String lastName, Model m) { return exemple(name, lastName, m); }

    @GetMapping("/hola/{nom}/{cognom}")
    public String exempleREST2(@PathVariable("nom") String name, @PathVariable("cognom") String lastName, Model m) { return exemple(name, lastName, m); }
}
