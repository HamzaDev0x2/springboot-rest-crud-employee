package hamzadev.local.rest_sevice_04.rest;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(String message)
    {
        super(message);
    }


    public EmployeeNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public EmployeeNotFoundException(Throwable cause)
    {
        super(cause);
    }
}
