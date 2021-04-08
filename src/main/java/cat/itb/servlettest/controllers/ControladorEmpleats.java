package cat.itb.servlettest.controllers;


import cat.itb.servlettest.model.entities.Empleat;
import cat.itb.servlettest.model.services.EmpleatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControladorEmpleats
{
    private final EmpleatService servei;

    public ControladorEmpleats(EmpleatService servei) {this.servei = servei;}

    @GetMapping("/empleats/list")
    public String llistar(Model m)
    {
        m.addAttribute("llistaEmpleats", servei.llistat());
        return "llistat";
    }

    @GetMapping("/empleats/new")
    public String afegirEmpleat(Model m)
    {
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
        m.addAttribute("empleatForm", new Empleat());
        return "new-empleat";
    }

    @PostMapping("empleats/new/submit")
    public String afegirSubmit(@ModelAttribute("empleatForm") Empleat emp)
    {
        servei.afegir(emp);
        return "redirect:/empleats/list";
    }

    @PostMapping("empleats/edit/submit")
    public String modificarSubmit(@ModelAttribute("empleatForm") Empleat emp)
    {
        servei.substituir(emp);
        return "redirect:/empleats/list";
    }

    @GetMapping("empleats/edit/{id}")
    public String modificarREST(@PathVariable("id") int id, Model m)
    {
        m.addAttribute("empleatForm", servei.consultaPerId(id));
        return "new-empleat";
    }

    @GetMapping("empleats/edit")
    public String modificar(@RequestParam("id") int id, Model m) { return modificarREST(id, m); }

    @GetMapping("empleats/eliminar")
    public String eliminar(@RequestParam("id") int id)
    {
        servei.eliminarPerId(id);
        return "redirect:/empleats/list";
    }

    @GetMapping("empleats/eliminar/{id}")
    public String eliminarREST(@PathVariable("id") int id) { return eliminar(id); }
}