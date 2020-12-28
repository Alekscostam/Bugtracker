package pl.kowalski.bugtracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Model.Dto.BugDto;
import pl.kowalski.bugtracker.Repositories.BugRepository;
import pl.kowalski.bugtracker.Repositories.EmployeeRepository;
import pl.kowalski.bugtracker.Model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Model.Progress;
import pl.kowalski.bugtracker.Service.Get.GetEmployeeServiceImpl;

import java.security.Principal;
import java.util.Date;
import java.util.Optional;

@Service
public class DmlServiceImpl implements DmlService {

    private final BugRepository bugRepository;
    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final GetEmployeeServiceImpl getEmployeeService;

    @Autowired
    public DmlServiceImpl(BugRepository bugRepository, EmployeeRepository employeeRepository, BCryptPasswordEncoder passwordEncoder, GetEmployeeServiceImpl getEmployeeService) {
        this.bugRepository = bugRepository;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
        this.getEmployeeService = getEmployeeService;
    }

    @Override
    public boolean postBug(BugDto bugDto, Principal principal) {
        Optional<Employee> employeeByEmail = getEmployeeService.findEmployeeByEmail(principal.getName());

        if (employeeByEmail.isPresent()) {
            Bug bug = ObjectMapper.mapBugDtoToBug(bugDto, employeeByEmail.get());
            bugRepository.save(bug);
            return true;
        }
        return false;
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
