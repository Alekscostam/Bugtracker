package pl.kowalski.bugtracker.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kowalski.bugtracker.Service.RegisterServiceImpl;
import pl.kowalski.bugtracker.Service.Get.GetEmployeeServiceImpl;

@RestController
public class EmployeeRestController {

    GetEmployeeServiceImpl getEmployeeService;
    RegisterServiceImpl dmlService;

    @Autowired
    public EmployeeRestController(GetEmployeeServiceImpl getEmployeeService, RegisterServiceImpl dmlService) {
        this.getEmployeeService = getEmployeeService;
        this.dmlService = dmlService;
    }

    @GetMapping("/generateCode")
    public String generateCode(){

        return  getEmployeeService.generateInstitutionCode();
    }




}
