package com.loneliness.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class UserData implements Serializable {
    public enum Type{
        ADMIN,MANAGER, NO_TYPE;
    }
    private int id;
    @NotNull(message = "Тип должен быть задан. ")
    private Type type;
    @NotNull(message = "Логин должен быть задан. ")
    private String login;
    @NotNull(message = "Пароль должен быть задан. ")
    @Size(message = "Пародь должен быть больше 2 символов" , min = 2)
    private String password;
    @NotNull(message = "Должен быть задан email")
    @Email(message = "Email должен быть действительным")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public void setType(String type){
        type=type.replace(" ","_");
        type=type.toUpperCase();
        this.type=Type.valueOf(type);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public UserData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id &&
                type == userData.type &&
                login.equals(userData.login) &&
                password.equals(userData.password) &&
                email.equals(userData.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, login, password, email);
    }
}
