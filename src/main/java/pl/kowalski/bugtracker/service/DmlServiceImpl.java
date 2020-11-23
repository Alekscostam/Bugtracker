package pl.kowalski.bugtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Dao.Repositories.BugRepository;
import pl.kowalski.bugtracker.Dao.Repositories.EmployeeRepository;
import pl.kowalski.bugtracker.model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.model.Entity.Bug;
import pl.kowalski.bugtracker.model.Entity.Employee;
import pl.kowalski.bugtracker.model.ObjectMapper;
import pl.kowalski.bugtracker.model.Progress;
import pl.kowalski.bugtracker.service.Interfaces.DmlService;

@Service
public class DmlServiceImpl implements DmlService {

    BugRepository bugRepository;
    EmployeeRepository employeeRepository;

    @Autowired
    public DmlServiceImpl(BugRepository bugRepository, EmployeeRepository employeeRepository) {
        this.bugRepository = bugRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void addNewBug(Bug bug) {
        bug.setProgress(Progress.OPEN);
        bugRepository.save(bug);
    }

    @Override
    public boolean addNewEmployee(EmployeeDto employeeDto) {

        boolean anyMatch = employeeRepository.findAll().stream().anyMatch(employees -> employees.getEmail().equals(employeeDto.getEmail()));
        if (anyMatch) {
            return false;
        } else {
            Employee employee = ObjectMapper.mapEmployeeDtoToEmployee(employeeDto);
            employeeRepository.save(employee);
            return true;
        }

    }
}
