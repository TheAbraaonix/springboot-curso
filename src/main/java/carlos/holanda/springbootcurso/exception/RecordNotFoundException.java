package carlos.holanda.springbootcurso.exception;

public class RecordNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(String ex) {
        super(ex);
    }
}
