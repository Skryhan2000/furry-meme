package com.loneliness.client.controller.command_impl.validation_command;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.DifferentialIndicators;


import javax.validation.ConstraintViolation;
import java.util.Set;


public class DifferentialIndicatorsValidation implements Command<DifferentialIndicators, Set<ConstraintViolation<DifferentialIndicators>>> {
    @Override
    public Set<ConstraintViolation<DifferentialIndicators>>  execute(DifferentialIndicators request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}
