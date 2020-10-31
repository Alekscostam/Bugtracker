package pl.kowalski.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigatorController {

    @GetMapping
    public String start()
    {
        return "index";
    }
    @GetMapping("/sd")
    public String start1()
    {
        return "index2";
    }
    @GetMapping("/sd2")
    public String start2()
    {
        return "index3";
    }
    @GetMapping("/sd3")
    public String start3()
    {
        return "index4";
    }


}
