package hamzadev.local.rest_sevice_04.rest;

import hamzadev.local.rest_sevice_04.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void init() {
        students = new ArrayList<Student>();
        System.out.println("Array list of students created");
        students.add(new Student("ABBASSI", "Hamza"));
        students.add(new Student("TAQI", "Abderrahim"));
        students.add(new Student("LEO", "Messi"));
        System.out.println("3 students added");

    }

    //define endpoint for /students - returns a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    //define endpoint for /students/{idStudent} - returns a student based on his list index
    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId) {

        return students.get(studentId);
    }
}

