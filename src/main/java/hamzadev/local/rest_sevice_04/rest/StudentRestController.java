package hamzadev.local.rest_sevice_04.rest;

import hamzadev.local.rest_sevice_04.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private  List<Student> students;

    @PostConstruct
    public void init()
    {
        students=new  ArrayList<Student>();
        System.out.println("Array list of students created");
        students.add(new Student("ABBASSI","Hamza"));
        students.add(new Student("TAQI","Abderrahim"));
        students.add(new Student("LEO","Messi"));
        System.out.println("3 students added");

    }

    //define endpoint for /students - returns a list of students
    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }
    //define endpoint for /students/{idStudent} - returns a student based on his list index
    @GetMapping("/students/{studentId}")
    public Student getStudents(@PathVariable int studentId)
    {
        //check student id against list size
        if(students.size()<=studentId || studentId<0)
            throw new StudentNotFoundException("Student id not found : "+ studentId);
        return students.get(studentId);
    }

    //add exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
    {
        //create a student error response
        StudentErrorResponse response=new StudentErrorResponse();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exc.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        //Return a response entity
        return new ResponseEntity<StudentErrorResponse>(response, HttpStatus.NOT_FOUND);
    }

    //add another exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc)
    {
        //create a student error response
        StudentErrorResponse response=new StudentErrorResponse();

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exc.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        //Return a response entity
        return new ResponseEntity<StudentErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }
}










