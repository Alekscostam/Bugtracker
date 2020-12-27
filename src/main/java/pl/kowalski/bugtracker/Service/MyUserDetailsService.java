package pl.kowalski.bugtracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Service.Get.GetEmployeeServiceImpl;

import java.util.Collections;
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

            throw new EmailNotFoundException("Email not found!");

        }

        return new User(
                employeeByEmail.get().getEmail(), employeeByEmail.get().getPassword(),
                true, true, true, true,
                Collections.singletonList(new SimpleGrantedAuthority("USER")));
    }
}
