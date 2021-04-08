package cat.itb.servlettest.controllers;

import cat.itb.servlettest.model.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControladorHola
{
    @GetMapping("/usuari")
    public User exempleUsuari(@RequestParam(value = "nom", defaultValue = "User") String name) { return new User(name); }

    @GetMapping("/usuari/{nom}")
    public User exempleUsuariREST(@PathVariable("nom") String name) { return exempleUsuari(name); }
}
