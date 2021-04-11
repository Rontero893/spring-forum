package cat.itb.servlettest.controllers;

import cat.itb.servlettest.model.entities.UserTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControladorHola
{
    @GetMapping("/usuari")
    public UserTest exempleUsuari(@RequestParam(value = "nom", defaultValue = "User") String name) { return new UserTest(name); }

    @GetMapping("/usuari/{nom}")
    public UserTest exempleUsuariREST(@PathVariable("nom") String name) { return exempleUsuari(name); }
}
