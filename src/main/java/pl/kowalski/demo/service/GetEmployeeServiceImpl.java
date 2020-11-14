package pl.kowalski.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kowalski.demo.Dao.JdbcTemplate.EmployeeDaoImpl;
import pl.kowalski.demo.service.Interfaces.GetEmployeeService;

import java.util.List;

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
}
