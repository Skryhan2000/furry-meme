package com.loneliness.client.controller.command_impl.dividend;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.Dividend;
import com.loneliness.entity.InitialData;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class DividendValidation implements Command<Dividend , Set<ConstraintViolation<Dividend >>> {
    @Override
    public Set<ConstraintViolation<Dividend >>  execute(Dividend request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}