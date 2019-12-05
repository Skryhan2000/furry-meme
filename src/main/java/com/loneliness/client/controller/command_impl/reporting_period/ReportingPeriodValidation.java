package com.loneliness.client.controller.command_impl.reporting_period;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.ROE;
import com.loneliness.entity.ReportingPeriod;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ReportingPeriodValidation implements Command<ReportingPeriod, Set<ConstraintViolation<ReportingPeriod>>> {
    @Override
    public Set<ConstraintViolation<ReportingPeriod>>  execute(ReportingPeriod request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}