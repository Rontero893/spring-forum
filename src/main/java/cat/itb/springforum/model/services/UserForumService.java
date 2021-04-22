package cat.itb.springforum.model.services;

import cat.itb.springforum.model.entities.Feedback;
import cat.itb.springforum.model.entities.UserForum;
import cat.itb.springforum.model.repositories.RepositoryUserForum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserForumService
{
    @Autowired
    private RepositoryUserForum repositoryUserForum;

    public void add(final UserForum e)
    {
        e.setPassword(new BCryptPasswordEncoder().encode(e.getPassword()));
        repositoryUserForum.save(e);
    }

    public List<UserForum> getUsers()
    {
        return new ArrayList<>() {{ repositoryUserForum.findAll().iterator().forEachRemaining(this::add); }};
    }

    public UserForum getUser(final long id)
    {
        return repositoryUserForum.findById(id).orElse(null);
    }

    public UserForum getUserByUsername(final String username)
    {
        for (UserForum userForum : repositoryUserForum.findAll())
        {
            if (userForum.getUsername().equals(username)) return userForum;
        }
        return null;
    }

    public void deleteUser(final long id) { repositoryUserForum.deleteById(id); }

    public void modifyUser(UserForum e) { repositoryUserForum.save(e); }

    @PostConstruct
    public void init()
    {
        UserForum admin = new UserForum("ricardo.montserrat.7e3@itb.cat", "admin", "123", UserForum.SecurityRole.ADMIN);
        UserForum user = new UserForum("javier.romero@itb.cat", "user", "123", UserForum.SecurityRole.USER);

        admin.addFeedback(new Feedback(admin, "Pretty good idea!", Feedback.Reaction.Happy, "http://wwww.youtube.com", "2005/01/21"));
        user.addFeedback(new Feedback(user, "Pretty good idea!", Feedback.Reaction.Happy, "http://wwww.youtube.com", "2005/01/21"));
        user.addFeedback(new Feedback(user, "Pretty good idea!", Feedback.Reaction.Happy, "http://wwww.youtube.com", "2005/01/21"));

        repositoryUserForum.saveAll(Arrays.asList(admin, user));
    }
}
