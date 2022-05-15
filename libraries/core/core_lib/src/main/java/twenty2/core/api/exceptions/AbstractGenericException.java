package twenty2.core.api.exceptions;

public abstract class AbstractGenericException extends AbstractApiException {
    private final String message;
    private final Throwable throwable;

    public AbstractGenericException(String message, Throwable throwable ) {
        this.message = message;
        this.throwable = throwable;
    }

    @Override
    public Object getBody() {
        return ErrorModel.builder()
                .message( message )
                .exception( throwable )
                .build();
    }
}
