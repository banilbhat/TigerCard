package exceptions;

public class CustomException extends Exception {
    String message;
    
    public CustomException(String str) {
        this.message = str;
    }
    
    public String toString() {
        return ("Custom Exception Occurred : " + message);
    }

}
