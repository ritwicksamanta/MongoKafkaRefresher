package com.test.gatewayserver.auth;

import com.test.gatewayserver.validators.PasswordValidator;
import jakarta.validation.constraints.*;



@PasswordValidator
public class User {

    @NotNull
    @Size(min=4,message = "username must be at least 4 characters")
    private String user_id;
    @NotBlank
    @Pattern(
            regexp = "^[A-Za-z ]+$",
            message = "Name must contain only letters and spaces"
    )
    private String name;
    @Email(message = "email is not valid")
    private String email;
    @NotBlank
    @Pattern(
            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@_&]).{8,}$",
            message = "Password must be at least 8 characters long and include uppercase, lowercase," +
                    " number, and one special character (@ _ &)")
    private String password;


    public String getEmail() {
        return email;
    }

    public String getUserId() {
        return user_id;
    }

    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }


    User(String user_id,String name,String email, String password){
        this.user_id=user_id;
        this.name=name;
        this.email=email;
        this.password=password;
    }
}
