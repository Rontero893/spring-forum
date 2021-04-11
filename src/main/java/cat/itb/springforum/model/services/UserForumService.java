package cat.itb.springforum.model.services;

import cat.itb.springforum.model.entities.UserForum;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserForumService
{
    private static final List<UserForum> users = new ArrayList<>();

    public static void add(final UserForum e) { users.add(e); }

    public static List<UserForum> getUsers() { return users; }

    public static UserForum getUser(final String id)
    {
        for (UserForum user : users) { if (user.getId().equals(id)) return user; }
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
        users.addAll(
                Collections.singletonList(
                        new UserForum("ricardo.montserrat.7e3@itb.cat", "Ricardo", "12345", UserForum.Role.ADMIN)
                ));
    }
}
