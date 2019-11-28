package com.loneliness.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class ContactDetail implements Serializable {
    private int contactDetailId;
    @NotNull(message = "Задайте email ")
    @Email(message = "Задайте валидный email")
    private String email;
    @NotNull(message = "Задайте номер телефона")
    private String phoneNumber;
    private String info;
    @Positive(message = "Задайте положительный id компании ")
    private int companyId;
}
