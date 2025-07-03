package hamzadev.local.rest_sevice_04.rest;

import hamzadev.local.rest_sevice_04.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    //define endpoint for /students - returns a list of students
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        List<Student> students=new  ArrayList<Student>();
        students.add(new Student("ABBASSI","Hamza"));
        students.add(new Student("TAQI","Abderrahim"));
        students.add(new Student("LEO","Messi"));

        return students;
    }
}
