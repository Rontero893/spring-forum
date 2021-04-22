package cat.itb.springforum.security;

import cat.itb.springforum.model.entities.UserForum;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ForumUserDetails userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/", "/login", "/register", "/error", "/h2-console/**")
                .permitAll()

                .antMatchers("/feedback/delete/**").hasRole(UserForum.SecurityRole.ADMIN.name())

                .antMatchers("/feedback/new/**").authenticated()

                .and()
                .formLogin()
                .permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();

        http.csrf().disable(); //per h2-console
        http.headers().frameOptions().disable(); //per h2-console

    }

}
