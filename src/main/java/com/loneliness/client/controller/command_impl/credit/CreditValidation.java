package com.loneliness.client.controller.command_impl.credit;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.Credit;
import com.loneliness.entity.Dividend;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class CreditValidation implements Command<Credit , Set<ConstraintViolation<Credit >>> {
    @Override
    public Set<ConstraintViolation<Credit>>  execute(Credit request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}