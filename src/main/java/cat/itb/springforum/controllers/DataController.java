package cat.itb.springforum.controllers;

import cat.itb.springforum.model.entities.Feedback;
import cat.itb.springforum.model.entities.UserForum;
import cat.itb.springforum.model.services.FeedbackDataService;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Setter
public class DataController
{
    private final FeedbackDataService feedbackDataService;

    public DataController(FeedbackDataService feedbackDataService) {this.feedbackDataService = feedbackDataService;}

    @PostMapping("/feedback/user")
    public String setUser(@ModelAttribute("userForm") UserForum emp)
    {
        feedbackDataService.setCurrentUser(emp);
        return "redirect::/list";
    }

    @GetMapping("/feedback/list")
    public String setFeedbackList(Model m)
    {
        m.addAttribute("llistaEmpleats", feedbackDataService.getFeedbackList());
        return "llistat";
    }

    @GetMapping("/feedback/new")
    public String prepareNewFeedback(Model m)
    {
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
        m.addAttribute("empleatForm", new Feedback());
        return "new-empleat";
    }

    @PostMapping("/feedback/new/submit")
    public String addNewFeedbackSubmit(@ModelAttribute("empleatForm") Feedback emp)
    {
        feedbackDataService.addFeedback(emp);
        return "redirect:/feedback/list";
    }

    @GetMapping("/feedback/eliminar")
    public String deleteFeedbackPetition(@RequestParam("id") String id)
    {
        feedbackDataService.deleteFeedback(id);
        return "redirect:/feedback/list";
    }

    @GetMapping("/feedback/eliminar/{id}")
    public String deleteFeedbackPetitionREST(@PathVariable("id") String id) { return deleteFeedbackPetition(id); }

    //endregion
}
