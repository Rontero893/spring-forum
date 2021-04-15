package cat.itb.springforum.controllers;

import cat.itb.springforum.model.entities.Feedback;
import cat.itb.springforum.model.services.FeedbackDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataControllerREST
{
    @Autowired
    private FeedbackDataService feedbackDataService;

    @GetMapping("/feedback/get")
    public Feedback getJsonFeedback(@RequestParam("id") String id) { return feedbackDataService.getFeedback(id); }

    @GetMapping("/feedback/get/{id}")
    public Feedback getJsonFeedbackREST(@PathVariable("id") String id) { return getJsonFeedback(id); }
}
