package cat.itb.springforum.model.services;

import cat.itb.springforum.model.entities.Feedback;
import cat.itb.springforum.model.entities.UserForum;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserForumService
{
    private final List<UserForum> users = new ArrayList<>();

    public void add(final UserForum e) { users.add(e); }

    public List<UserForum> getUsers() { return users; }

    public UserForum getUser(final String id)
    {
        for (UserForum user : users) { if (user.getId().equals(id)) return user; }
        return null;
    }

    public UserForum getUserByUsername(final String username)
    {
        System.out.println(username);
        for (UserForum user : users) { if (user.getUsername().equals(username)) return user; }
        return null;
    }

    public void deleteUser(final String id)
    {
        for (UserForum user : users)
        {
            if (user.getId().equals(id))
            {
                users.remove(user);
                return;
            }
        }
    }

    public void modifyUser(UserForum e)
    {
        String id = e.getId();
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).getId().equals(id))
            {
                users.set(i, e);
                return;
            }
        }
    }

    @PostConstruct
    public void init()
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserForum admin = new UserForum("ricardo.montserrat.7e3@itb.cat", "Admin", encoder.encode("123"), UserForum.Role.ADMIN);
        UserForum user = new UserForum("ricardo.montserrat.7e3@itb.cat", "User", encoder.encode("123"), UserForum.Role.USER);

        admin.addFeedback(new Feedback(admin.getId(), "Pretty good idea!", Feedback.Reaction.Happy, "http://wwww.youtube.com", "2005/01/21"));
        user.addFeedback(new Feedback(user.getId(), "Pretty good idea!", Feedback.Reaction.Happy, "http://wwww.youtube.com", "2005/01/21"));
        user.addFeedback(new Feedback(user.getId(), "Pretty good idea!", Feedback.Reaction.Happy, "http://wwww.youtube.com", "2005/01/21"));

        users.addAll(Arrays.asList(admin, user));
    }
}
