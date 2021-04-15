package cat.itb.springforum.model.services;

import cat.itb.springforum.model.entities.Feedback;
import cat.itb.springforum.model.entities.UserForum;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Data
public class FeedbackDataService
{
    private UserForum currentUser;

    private List<Feedback> feedbackList;

    @Autowired
    private UserForumService userForumService;

    public List<Feedback> getFeedbackList()
    {
        refreshFeedbackList();
        return feedbackList;
    }

    public Feedback getFeedback(String id)
    {
        for (Feedback feedback : feedbackList)
        {
            if (feedback.getId().equals(id)) return feedback;
        }
        return null;
    }

    public void addFeedback(Feedback feedback) { currentUser.addFeedback(feedback); }

    public void addFeedback(Feedback feedback, UserForum user) { user.addFeedback(feedback); }

    public void deleteFeedback(String id)
    {
        Feedback feedback = getFeedback(id);
        //TODO: check if this is a copy or original
        Objects.requireNonNull(userForumService.getUser(feedback.getUserId())).deleteFeedback(feedback);
    }

    private void refreshFeedbackList()
    {
        feedbackList = new ArrayList<>();
        for (UserForum user : userForumService.getUsers()) feedbackList.addAll(user.getFeedbackHistory());
    }
}
