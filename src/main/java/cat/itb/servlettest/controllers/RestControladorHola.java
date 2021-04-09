package cat.itb.servlettest.controllers;

import cat.itb.servlettest.model.entities.ForumUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControladorHola
{
    @GetMapping("/usuari")
    public ForumUser exempleUsuari(@RequestParam(value = "nom", defaultValue = "User") String name) { return new ForumUser(name); }

    @GetMapping("/usuari/{nom}")
    public ForumUser exempleUsuariREST(@PathVariable("nom") String name) { return exempleUsuari(name); }
}
