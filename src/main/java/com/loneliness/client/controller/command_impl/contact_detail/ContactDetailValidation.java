package com.loneliness.client.controller.command_impl.contact_detail;

import com.loneliness.client.controller.Command;
import com.loneliness.client.controller.ControllerException;
import com.loneliness.client.service.DataValidationFactory;
import com.loneliness.entity.ContactDetail;
import com.loneliness.entity.Credit;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ContactDetailValidation implements Command<ContactDetail, Set<ConstraintViolation<ContactDetail >>> {
    @Override
    public Set<ConstraintViolation<ContactDetail>>  execute(ContactDetail request) throws ControllerException {
        return DataValidationFactory.getValidatorFactory().validate(request);
    }
}