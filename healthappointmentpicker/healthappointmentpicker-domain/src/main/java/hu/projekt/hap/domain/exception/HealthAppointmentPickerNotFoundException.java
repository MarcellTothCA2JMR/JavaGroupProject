package hu.projekt.hap.domain.exception;

public class HealthAppointmentPickerNotFoundException extends RuntimeException {

    private final String errorMessage;

    public HealthAppointmentPickerNotFoundException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}