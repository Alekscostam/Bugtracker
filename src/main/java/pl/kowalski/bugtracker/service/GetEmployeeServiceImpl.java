package pl.kowalski.bugtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.bugtracker.Dao.JdbcTemplate.EmployeeDaoImpl;
import pl.kowalski.bugtracker.model.Entity.Employee;
import pl.kowalski.bugtracker.service.Interfaces.GetEmployeeService;

@Service
public class GetEmployeeServiceImpl implements GetEmployeeService {

    EmployeeDaoImpl employeeDao;

    @Autowired
    public GetEmployeeServiceImpl(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public String getEmployeeNamesByBugId(Long bugId) {

        StringBuilder allEmployees = new StringBuilder("");
        employeeDao.findEmployeeNamesByBugId(bugId).forEach(employee-> allEmployees.append(" ").append(employee));


        return allEmployees.toString();
    }

    @Override
    public boolean checkUserHaveThisTask(Long bugId, Employee employee) {
        return false;
    }
}
