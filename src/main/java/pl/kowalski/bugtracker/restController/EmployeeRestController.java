package pl.kowalski.bugtracker.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kowalski.bugtracker.Dao.JdbcTemplate.EmployeeDaoImpl;
import pl.kowalski.bugtracker.model.Entity.Employee;
import pl.kowalski.bugtracker.service.DmlServiceImpl;
import pl.kowalski.bugtracker.service.GetEmployeeServiceImpl;

@RestController
public class EmployeeRestController {

    GetEmployeeServiceImpl getEmployeeService;
    DmlServiceImpl dmlService;

    @Autowired
    public EmployeeRestController(GetEmployeeServiceImpl getEmployeeService, DmlServiceImpl dmlService) {
        this.getEmployeeService = getEmployeeService;
        this.dmlService = dmlService;
    }

    @GetMapping("/generateCode")
    public String generateCode(){

        return  getEmployeeService.generateInstitutionCode();
    }




}
