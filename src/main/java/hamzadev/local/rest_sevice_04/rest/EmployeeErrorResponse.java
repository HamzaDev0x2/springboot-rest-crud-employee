package hamzadev.local.rest_sevice_04.rest;

public class EmployeeErrorResponse{
    int status;
    String message;
    String error;
    long timestamp;
    String path;

    public EmployeeErrorResponse(){}

    public EmployeeErrorResponse(int status, String message, String error, String path, long timestamp) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
