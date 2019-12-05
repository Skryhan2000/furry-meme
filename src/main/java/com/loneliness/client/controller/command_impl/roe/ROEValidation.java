package com.loneliness.client.controller.command_impl.roe;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.ROE;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ROEValidation implements Command<ROE, Set<ConstraintViolation<ROE>>> {
    @Override
    public Set<ConstraintViolation<ROE>>  execute(ROE request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}