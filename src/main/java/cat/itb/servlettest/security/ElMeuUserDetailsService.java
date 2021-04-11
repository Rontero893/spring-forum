package cat.itb.servlettest.security;

import cat.itb.servlettest.model.entities.UserTest;
import cat.itb.servlettest.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ElMeuUserDetailsService implements UserDetailsService
{
    public static final String ADMIN_ROLE = "ADMIN";
    public static final String USER_ROLE = "USER";

    @Autowired
    private UserService serveiUsuaris;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        UserTest u = serveiUsuaris.consultaPerId(Integer.parseInt(s));
        User.UserBuilder builder;
        if (u != null)
        {
            builder = User.withUsername(s);
            builder.disabled(false);
            builder.password(u.getPassword());
            builder.authorities(new SimpleGrantedAuthority(USER_ROLE));
        } else throw new UsernameNotFoundException("Usuari no trobat");
        return builder.build();
    }
}
