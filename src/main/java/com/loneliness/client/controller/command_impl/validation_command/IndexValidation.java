package com.loneliness.client.controller.command_impl.validation_command;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.Index;


import javax.validation.ConstraintViolation;
import java.util.Set;

public class IndexValidation implements Command<Index, Set<ConstraintViolation<Index>>> {
    @Override
    public Set<ConstraintViolation<Index>>  execute(Index request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}
