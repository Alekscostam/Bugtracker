package pl.kowalski.bugtracker.Security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter   {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/Register","/generateCode").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .usernameParameter("email")
                .loginPage("/Login").permitAll()
                .defaultSuccessUrl("/AllBugs",true)
                .failureUrl("/errorLogin")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/Login").permitAll();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**","/*.js");
    }

}