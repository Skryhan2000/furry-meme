package com.loneliness.client.controller.command_impl.company;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.Company;
import com.loneliness.entity.ContactDetail;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class CompanyValidation implements Command< Company, Set<ConstraintViolation< Company >>> {
    @Override
    public Set<ConstraintViolation< Company>>  execute( Company request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}