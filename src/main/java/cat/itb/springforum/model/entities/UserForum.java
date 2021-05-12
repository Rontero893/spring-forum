package cat.itb.springforum.model.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "user")
public class UserForum
{
    public enum SecurityRole { ADMIN, USER }

    @Id
    @GeneratedValue
    private Long id;

    private String email, username, password;
    private SecurityRole role;

    @OneToMany(mappedBy = "user")
    private List<Feedback> feedbackHistory = new ArrayList<>();

    public void addFeedback(Feedback feedback) { feedbackHistory.add(feedback); }

    public void deleteFeedback(Feedback feedback) { feedbackHistory.remove(feedback); }

    public String getRole() { return role.name(); }

    public UserForum()
    {
        email = "noemail@gmail.com";
        username = "anom";
        password = new BCryptPasswordEncoder().encode("123");
        role = SecurityRole.USER;
    }

    public UserForum(String email, String username, String password, SecurityRole role)
    {
        this.email = email;
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.role = SecurityRole.ADMIN;
    }
}
