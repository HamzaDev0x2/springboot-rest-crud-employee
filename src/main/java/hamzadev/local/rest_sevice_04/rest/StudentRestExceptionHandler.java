package hamzadev.local.rest_sevice_04.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
    {
        //create a student error response
        StudentErrorResponse response=new StudentErrorResponse();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exc.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        System.out.println("Global exception handler");

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
        System.out.println("Global exception handler");

        //Return a response entity
        return new ResponseEntity<StudentErrorResponse>(response, HttpStatus.BAD_REQUEST);
    }
}
