package pl.kowalski.bugtracker.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Dao.Repositories.BugRepository;
import pl.kowalski.bugtracker.Dao.Repositories.EmployeeRepository;
import pl.kowalski.bugtracker.Model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.Model.Entity.Bug;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Model.ObjectMapper;
import pl.kowalski.bugtracker.Model.Progress;

@Service
public class DmlServiceImpl implements DmlService {

    private final BugRepository bugRepository;
    private final EmployeeRepository employeeRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public DmlServiceImpl(BugRepository bugRepository, EmployeeRepository employeeRepository, BCryptPasswordEncoder passwordEncoder) {
        this.bugRepository = bugRepository;
        this.employeeRepository = employeeRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void addBug(Bug bug) {
        bug.setProgress(Progress.OPEN);
        bugRepository.save(bug);
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
