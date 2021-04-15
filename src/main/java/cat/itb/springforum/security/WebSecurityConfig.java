package cat.itb.springforum.security;

import cat.itb.springforum.model.entities.UserForum;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    private final ForumUserDetails userDetailsService;

    public WebSecurityConfig(ForumUserDetails userDetailsService) { this.userDetailsService = userDetailsService; }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/", "/login", "/register")
                .permitAll()

                .antMatchers("/feedback/delete").hasRole(UserForum.Role.ADMIN.name())

                .antMatchers("/feedback/new").authenticated()

                .and()
                .formLogin()
                .permitAll()

                .and()
                .logout()
                .permitAll();
    }

}
