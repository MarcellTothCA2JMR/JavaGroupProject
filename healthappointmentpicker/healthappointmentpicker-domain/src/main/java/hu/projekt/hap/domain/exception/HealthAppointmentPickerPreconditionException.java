package hu.projekt.hap.domain.exception;

public class HealthAppointmentPickerPreconditionException extends RuntimeException {

    private final String errorMessage;

    public HealthAppointmentPickerPreconditionException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}