package com.test.gatewayserver.validators;

import com.test.gatewayserver.auth.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidatorImpl implements ConstraintValidator<PasswordValidator, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if(user==null || user.getName()==null ||user.getPassword()==null)
            return true;
        String password = user.getPassword().toLowerCase();
        String userName = user.getName().toLowerCase().replaceAll("\\s+","");//replace all blank space

        return !password.startsWith(userName);
    }
}
