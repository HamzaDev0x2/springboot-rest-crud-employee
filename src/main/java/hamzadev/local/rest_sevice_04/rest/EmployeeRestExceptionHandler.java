package hamzadev.local.rest_sevice_04.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleRunTimeException(EmployeeNotFoundException exception, HttpServletRequest request)
    {
        EmployeeErrorResponse employeeErrorResponse=new EmployeeErrorResponse();

        employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        employeeErrorResponse.setMessage(exception.getMessage());
        employeeErrorResponse.setTimestamp(System.currentTimeMillis());
        employeeErrorResponse.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        employeeErrorResponse.setPath(request.getRequestURI());

           return new ResponseEntity<>(employeeErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundException(Exception exception, HttpServletRequest request)
    {
        EmployeeErrorResponse employeeErrorResponse=new EmployeeErrorResponse();

        employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        employeeErrorResponse.setMessage(exception.getMessage());
        employeeErrorResponse.setTimestamp(System.currentTimeMillis());
        employeeErrorResponse.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        employeeErrorResponse.setPath(request.getRequestURI());

        return new ResponseEntity<>(employeeErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
