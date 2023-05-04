package SRC.Model.BO.Exception;

public class LoginException extends RuntimeException{
    public LoginException(String message){
        super(message);
    }
}