package cat.itb.springforum.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserForum extends DatabaseItem
{
    public static final String ADMIN_ROLE = "Admin";
    public static final String USER_ROLE = "User";

    private String email, username, password;
    private String role;

    private final List<Feedback> feedbackHistory = new ArrayList<>();

    public void addFeedback(Feedback feedback) { feedbackHistory.add(feedback); }

    public void deleteFeedback(Feedback feedback) { feedbackHistory.remove(feedback); }

    public UserForum()
    {
        email = "noemail@gmail.com";
        username = "anom";
        password = new BCryptPasswordEncoder().encode("123");
        role = USER_ROLE;
    }

    public UserForum(String email, String username, String password, String role)
    {
        this.email = email;
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.role = role;
    }
}
