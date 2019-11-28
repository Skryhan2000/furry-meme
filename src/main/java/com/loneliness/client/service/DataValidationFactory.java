package com.loneliness.client.service;


import com.loneliness.entity.DifferentialIndicators;
import com.loneliness.entity.Index;

import com.loneliness.entity.UserData;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class DataValidationFactory {
    private static final DataValidationFactory dataValidationFactory = new DataValidationFactory();
    private Validator validator ;

    private DataValidationFactory(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();

    }
    public static DataValidationFactory getValidatorFactory() {
        return dataValidationFactory;
    }

    public Set<ConstraintViolation<DifferentialIndicators>> validate(DifferentialIndicators data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<Index>> validate(Index data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<UserData>> validate(UserData data) {
        return validator.validate(data);
    }


}
