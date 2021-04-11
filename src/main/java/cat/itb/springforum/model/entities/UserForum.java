package cat.itb.springforum.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UserForum extends DatabaseItem
{
    public enum Role { ADMIN, USER }

    private String email, username, password;
    private Role role;

    private final List<Feedback> feedbackHistory = new ArrayList<>();

    public void addFeedback(Feedback feedback) { feedbackHistory.add(feedback); }

    public void deleteFeedback(Feedback feedback) { feedbackHistory.remove(feedback); }

    public String getRole() { return role.name(); }

    public UserForum()
    {
        email = "noemail@gmail.com";
        username = "anom";
        password = "123";
        role = Role.USER;
    }
}
