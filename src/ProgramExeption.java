public class ProgramExeption extends RuntimeException{
    public ProgramExeption() {
    }

    public ProgramExeption(String message) {
        super(message);
    }

    public ProgramExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ProgramExeption(Throwable cause) {
        super(cause);
    }

    public ProgramExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
