package cat.itb.servlettest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class ConfiguracioSeguretatWeb extends WebSecurityConfigurerAdapter
{
    @Autowired
    private ElMeuUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/", "/inici", "/hola")
                .permitAll()

                .antMatchers("/secret").authenticated()

                .antMatchers("/topsecret").hasRole("espia")

                .and()
                .formLogin()
                .permitAll()

                .and()
                .logout()
                .permitAll();
    }

}
