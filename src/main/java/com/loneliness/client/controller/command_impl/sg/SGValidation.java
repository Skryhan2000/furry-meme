package com.loneliness.client.controller.command_impl.sg;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.SG;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class SGValidation implements Command<SG, Set<ConstraintViolation<SG>>> {
    @Override
    public Set<ConstraintViolation<SG>>  execute(SG request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}