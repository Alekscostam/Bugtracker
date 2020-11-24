package pl.kowalski.bugtracker.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Service.GetEmployeeServiceImpl;

import java.util.Optional;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final GetEmployeeServiceImpl getEmployeeService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(GetEmployeeServiceImpl getEmployeeService, BCryptPasswordEncoder passwordEncoder) {
        this.getEmployeeService = getEmployeeService;
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return email -> {
            Optional<Employee> employeeByEmail = getEmployeeService.findEmployeeByEmail(email);
            if (employeeByEmail.isEmpty()) {
                throw new UsernameNotFoundException("No user found with this email address");
            }

            return (UserDetails) employeeByEmail.get();
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/Register","/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/Login")
                .permitAll()
                .and()
                .logout()
                .permitAll();


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**");
    }

}