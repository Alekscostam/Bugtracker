package pl.kowalski.bugtracker.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


    @GetMapping("/Login")
    public String startLoginPage() {
        return "Login";
    }

    @GetMapping("/errorLogin")
    public ModelAndView errorLoginPage() {
        ModelAndView mav = new ModelAndView("Login");
        mav.addObject("error", "incorrect data!");
        return mav;
    }
}
