package pl.kowalski.bugtracker.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Service.GetEmployeeServiceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {


    private final GetEmployeeServiceImpl getEmployeeService;

    @Autowired
    public MyUserDetailsService(GetEmployeeServiceImpl getEmployeeService) {
        this.getEmployeeService = getEmployeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {

        Optional<Employee> employeeByEmail = getEmployeeService.findEmployeeByEmail(email);
        if (employeeByEmail.isEmpty()) {

            throw new EmailNotFoundException("email not found");

        }

        return new User(
                employeeByEmail.get().getEmail(), employeeByEmail.get().getPassword(), true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}
