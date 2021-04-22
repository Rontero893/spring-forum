package cat.itb.springforum.model.services;

import cat.itb.springforum.model.entities.Feedback;
import cat.itb.springforum.model.repositories.RepositoryFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackDataService
{
    @Autowired
    private RepositoryFeedback repositoryFeedback;

    public List<Feedback> getFeedbackList()
    {
        return new ArrayList<>() {{ repositoryFeedback.findAll().iterator().forEachRemaining(this::add); }};
    }

    public Feedback getFeedback(long id) { return repositoryFeedback.findById(id).orElse(null); }

    public void addFeedback(Feedback feedback) { repositoryFeedback.save(feedback); }

    public void deleteFeedback(long id) { repositoryFeedback.deleteById(id); }
}
