package kevat2025.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EkaController {
    @RequestMapping("/")
    @ResponseBody
    public String returnMessage() {
        return "Eka SP sovellukseni!";
    }

    @RequestMapping("/sayHello")
    @ResponseBody
    public String returnGreeting(
            @RequestParam(name = "nimesi", required = false, defaultValue = "Muumi") String etunimi,
            @RequestParam int ika) {
        return "Hei " + etunimi + ", " + ika + " vuotta";
    }

    @RequestMapping("/index")
    @ResponseBody
    public String returnIndex() {
        return "This is the main page";
    }

    @RequestMapping("/contact")
    @ResponseBody
    public String returnContact() {
        return "This is the contact page";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String returnHello(
            @RequestParam(name = "location") String location,
            @RequestParam(name = "name") String name) {
        return "Welcome to the " + location + " " + name + "!";
    }

}
