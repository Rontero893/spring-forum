package cat.itb.springforum.security;

import cat.itb.springforum.model.entities.UserForum;
import cat.itb.springforum.model.services.UserForumService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ForumUserDetails implements UserDetailsService
{
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        UserForum u = UserForumService.getUser(s);
        User.UserBuilder builder;
        if (u != null)
        {
            builder = User.withUsername(s);
            builder.disabled(false);
            builder.password(new BCryptPasswordEncoder().encode(u.getPassword()));
            builder.authorities(new SimpleGrantedAuthority(u.getRole()));
        }
        else throw new UsernameNotFoundException("User not found!");

        return builder.build();
    }
}
