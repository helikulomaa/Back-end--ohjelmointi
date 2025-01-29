package k25.vk2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import k25.vk2.domain.Student;

import org.springframework.ui.Model;

@Controller
public class StudentController {
    public static List<Student> opiskelijat = new ArrayList<Student>();

    static {
        opiskelijat.add(new Student("Pekka", "Virtanen"));
        opiskelijat.add(new Student("Matti", "Meikäläinen"));
        opiskelijat.add(new Student("Liisa", "Virtanen"));
        opiskelijat.add(new Student("Maikki", "Mallevaara"));
    }

    @GetMapping("/helloStudents")
    public String showStudents(Model model) {
        model.addAttribute("students", opiskelijat);
        return "studentList";
    }
}
