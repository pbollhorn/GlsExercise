package app.exceptions;

public class DaoExeception extends RuntimeException {
    public DaoExeception(String message) {
        super(message);
    }
}
