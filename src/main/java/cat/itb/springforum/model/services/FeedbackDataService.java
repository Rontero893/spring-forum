package cat.itb.springforum.model.services;

import cat.itb.springforum.model.entities.Feedback;
import cat.itb.springforum.model.entities.UserForum;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class FeedbackDataService
{
    private UserForum currentUser;

    private List<Feedback> feedbackList;

    public List<Feedback> getFeedbackList()
    {
        refreshFeedbackList();
        return feedbackList;
    }

    public Feedback getFeedback(String id)
    {
        refreshFeedbackList();
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
        UserForumService.deleteFeedback(feedback);
    }

    private void refreshFeedbackList()
    {
        feedbackList = new ArrayList<>();
        for (UserForum user : UserForumService.getUsers()) feedbackList.addAll(user.getFeedbackHistory());
    }
}
