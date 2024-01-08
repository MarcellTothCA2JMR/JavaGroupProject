package hu.projekt.hap.domain.exception;

public class HealthAppointmentPickerConflictException extends RuntimeException{

    private final String errorMessage;

    public HealthAppointmentPickerConflictException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}