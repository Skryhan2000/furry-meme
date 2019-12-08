package com.loneliness.client.controller.command_impl.company_representative;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.CompanyRepresentatives;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class CompanyRepresentativesValidation implements Command<CompanyRepresentatives, Set<ConstraintViolation<CompanyRepresentatives >>> {
    @Override
    public Set<ConstraintViolation<CompanyRepresentatives>>  execute(CompanyRepresentatives request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}