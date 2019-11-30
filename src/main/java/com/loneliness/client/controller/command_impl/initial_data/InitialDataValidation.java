package com.loneliness.client.controller.command_impl.initial_data;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.InitialData;
import com.loneliness.entity.ReportingPeriod;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class InitialDataValidation implements Command<InitialData, Set<ConstraintViolation<InitialData>>> {
    @Override
    public Set<ConstraintViolation<InitialData>>  execute(InitialData request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}