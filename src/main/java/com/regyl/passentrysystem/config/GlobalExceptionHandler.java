package com.regyl.passentrysystem.config;

import com.regyl.passentrysystem.exception.PassEntrySystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PassEntrySystemException.class)
    public ModelAndView handlePassEntrySystemException(PassEntrySystemException e) {
        ModelAndView exceptionView = new ModelAndView("exception-view");
        var viewAttributes = exceptionView.getModel();
        viewAttributes.put("message", e.getMessage());
        return exceptionView;
    }
}
