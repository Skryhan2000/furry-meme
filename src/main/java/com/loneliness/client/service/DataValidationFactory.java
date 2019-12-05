package com.loneliness.client.service;


import com.loneliness.entity.*;


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

    public Set<ConstraintViolation<InitialData>> validate(InitialData data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<Company>> validate(Company data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<ContactDetail>> validate(ContactDetail data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<Credit>> validate(Credit data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<Dividend>> validate(Dividend data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<UserData>> validate(UserData data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<ReportingPeriod>> validate(ReportingPeriod data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<ROE>> validate(ROE data) {
        return validator.validate(data);
    }

    public Set<ConstraintViolation<SG>> validate(SG data) {
        return validator.validate(data);
    }
}
