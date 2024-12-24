package APP.Infra.Exceptions;

public class IllegalActionException extends RuntimeException {

    public IllegalActionException() {
        super("Procedimento não permitido, verifique os dados");
    }

    public IllegalActionException(String message) {
        super(message);
    }

}
