package cat.itb.springforum.controllers;

import cat.itb.springforum.model.entities.Feedback;
import cat.itb.springforum.model.entities.UserForum;
import cat.itb.springforum.model.services.FeedbackDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DataController
{
    @Autowired
    private FeedbackDataService feedbackDataService;

    @PostMapping("/feedback/user")
    public String setUser(@ModelAttribute("userForm") UserForum emp)
    {
        feedbackDataService.setCurrentUser(emp);
        return "redirect::/list";
    }

    @GetMapping("/feedback/list")
    public String setFeedbackList(Model m)
    {
        m.addAttribute("feedbackList", feedbackDataService.getFeedbackList());
        return "list";
    }

    @GetMapping("/feedback/new")
    public String prepareNewFeedback(Model m)
    {
        //cal instanciar l'empleat, pq sino el CommandObject no existeix al formulari
        m.addAttribute("feedbackForm", new Feedback());
        return "new-feedback";
    }

    @PostMapping("/feedback/new/submit")
    public String addNewFeedbackSubmit(@ModelAttribute("feedbackForm") Feedback emp)
    {
        feedbackDataService.addFeedback(emp);
        return "redirect:/feedback/list";
    }

    @GetMapping("/feedback/delete")
    public String deleteFeedbackPetition(@RequestParam("id") String id)
    {
        feedbackDataService.deleteFeedback(id);
        return "redirect:/feedback/list";
    }

    @GetMapping("/feedback/delete/{id}")
    public String deleteFeedbackPetitionREST(@PathVariable("id") String id) { return deleteFeedbackPetition(id); }

    //endregion
}
