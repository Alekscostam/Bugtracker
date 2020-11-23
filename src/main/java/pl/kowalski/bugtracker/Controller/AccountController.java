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
import pl.kowalski.bugtracker.model.Dto.EmployeeDto;
import pl.kowalski.bugtracker.service.DmlServiceImpl;

@Controller
public class AccountController {


    DmlServiceImpl dmlService;

    @Autowired
    public AccountController(DmlServiceImpl dmlService) {
        this.dmlService = dmlService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/Register")
    public ModelAndView register(@ModelAttribute("employeeDto") EmployeeDto employeeDto, String message) {


        ModelAndView mav = new ModelAndView("Register");
        mav.addObject("employeeDto", employeeDto);
        mav.addObject("message", message);

        return mav;
    }


    @PostMapping("/Register")
    public ModelAndView postEmployee(EmployeeDto employeeDto) {
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
                boolean result = dmlService.addNewEmployee(employeeDto);
                if(result){
                    message = "success!";
                    mav.setViewName("redirect:/Login");
                }
                else
                    message = "Email exist!";

            } else {
                message = "Password are not the same!";

            }

        }

        mav.addObject("employeeDto", employeeDto);
        mav.addObject("message", message);
        return mav;

    }

}
