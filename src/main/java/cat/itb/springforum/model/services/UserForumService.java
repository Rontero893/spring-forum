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
    private static final List<UserForum> users = new ArrayList<>();

    public static void add(final UserForum e)
    {
        e.setPassword(new BCryptPasswordEncoder().encode(e.getPassword()));
        users.add(e);
    }

    public static void deleteFeedback(Feedback feedback)
    {
        users.forEach(user -> user.deleteFeedback(feedback));
    }

    public static List<UserForum> getUsers() { return users; }

    public static UserForum getUser(final String id)
    {
        for (UserForum user : users) { if (user.getId().equals(id)) return user; }
        return null;
    }

    public static UserForum getUserByUsername(final String username)
    {
        System.out.println(username);
        for (UserForum user : users) { if (user.getUsername().equals(username)) return user; }
        return null;
    }

    public static void deleteUser(final String id)
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

    public static void modifyUser(UserForum e)
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
        UserForum admin = new UserForum("ricardo.montserrat.7e3@itb.cat", "admin", "123", UserForum.ADMIN_ROLE);
        UserForum user = new UserForum("javier.romero@itb.cat", "user", "123", UserForum.USER_ROLE);

        admin.addFeedback(new Feedback(admin.getId(), "Pretty good idea!", Feedback.Reaction.Happy, "http://wwww.youtube.com", "2005/01/21"));
        user.addFeedback(new Feedback(user.getId(), "Pretty good idea!", Feedback.Reaction.Happy, "http://wwww.youtube.com", "2005/01/21"));
        user.addFeedback(new Feedback(user.getId(), "Pretty good idea!", Feedback.Reaction.Happy, "http://wwww.youtube.com", "2005/01/21"));

        users.addAll(Arrays.asList(admin, user));
    }
}
