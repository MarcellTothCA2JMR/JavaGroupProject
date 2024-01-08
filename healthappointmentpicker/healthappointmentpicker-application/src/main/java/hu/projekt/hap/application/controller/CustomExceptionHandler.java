package hu.projekt.hap.application.controller;

import hu.projekt.hap.domain.exception.HealthAppointmentPickerConflictException;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerNotFoundException;
import hu.projekt.hap.domain.exception.HealthAppointmentPickerPreconditionException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(HealthAppointmentPickerNotFoundException.class)
    public String handleCustomException(HealthAppointmentPickerNotFoundException e, Model model) {

        model.addAttribute("errorMessage", e.getErrorMessage());

        return "error";
    }

    @ExceptionHandler(HealthAppointmentPickerConflictException.class)
    public String handleCustomException(HealthAppointmentPickerConflictException e, Model model) {

        model.addAttribute("errorMessage", e.getErrorMessage());

        return "error";
    }

    @ExceptionHandler(HealthAppointmentPickerPreconditionException.class)
    public String handleCustomException(HealthAppointmentPickerPreconditionException e, Model model) {

        model.addAttribute("errorMessage", e.getErrorMessage());

        return "error";
    }
}