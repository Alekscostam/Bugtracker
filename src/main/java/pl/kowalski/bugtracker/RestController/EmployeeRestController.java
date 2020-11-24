package pl.kowalski.bugtracker.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kowalski.bugtracker.Service.DmlServiceImpl;
import pl.kowalski.bugtracker.Service.GetEmployeeServiceImpl;

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
