package pl.kowalski.bugtracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.kowalski.bugtracker.Repositories.EmployeeRepository;
import pl.kowalski.bugtracker.Model.Dto.EmployeeDto;

import pl.kowalski.bugtracker.Model.Entity.Employee;


@Service
public class RegisterServiceImpl implements RegisterService {


    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public RegisterServiceImpl(EmployeeRepository employeeRepository, BCryptPasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void register(EmployeeDto employeeDto) {
        String password = passwordEncoder.encode(employeeDto.getPassword());
        employeeDto.setPassword(password);
        Employee employee = ObjectMapper.mapEmployeeDtoToEmployee(employeeDto);

        boolean isPasswordMatch = passwordEncoder.matches(employeeDto.getPassword(), password);
        employeeRepository.save(employee);
    }
}
