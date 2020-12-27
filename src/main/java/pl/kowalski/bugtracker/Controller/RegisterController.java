package pl.kowalski.bugtracker.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalski.bugtracker.Model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.Model.Entity.Employee;
import pl.kowalski.bugtracker.Service.DmlServiceImpl;
import pl.kowalski.bugtracker.Service.Get.GetEmployeeServiceImpl;

import java.util.Optional;

@Controller
public class RegisterController {


    private final DmlServiceImpl dmlService;
    private final GetEmployeeServiceImpl  getEmployeeService;

    @Autowired
    public RegisterController(DmlServiceImpl dmlService, GetEmployeeServiceImpl getEmployeeService) {
        this.dmlService = dmlService;
        this.getEmployeeService = getEmployeeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/Register")
    public ModelAndView getRegister(@ModelAttribute("employeeDto") EmployeeDto employeeDto, String message) {


        ModelAndView mav = new ModelAndView("Register");
        mav.addObject("employeeDto", employeeDto);
        mav.addObject("message", message);

        return mav;
    }



    @PostMapping("/Register")
    public ModelAndView postRegister(EmployeeDto employeeDto) {

        ModelAndView mav = new ModelAndView("Register");
        String message = "";

        if (employeeDto.getEmail() == null
                || employeeDto.getFirstName() == null
                || employeeDto.getLastName() == null
                || employeeDto.getrPassword() == null
                || employeeDto.getPassword() == null
                || employeeDto.getInstitutionCode() == null
        ) message = "Fields cant be empty!";

        else {
            if (employeeDto.getrPassword().equals(employeeDto.getPassword())) {
                Optional<Employee> employeeExist = getEmployeeService.findEmployeeByEmail(employeeDto.getEmail());
                if (employeeExist.isEmpty()) {
                    dmlService.register(employeeDto);
                    message = "success!";
                    mav.setViewName("redirect:/Login");
                } else
                    message = "User exist!";

            } else
                message = "Passwords are not the same!";
        }

        mav.addObject("employeeDto", employeeDto);
        mav.addObject("message", message);
        return mav;

    }

}
