package com.tsystems.demail.Validation;

import com.tsystems.demail.Service.RegistrationService;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("uNameValidation")
public class UNameValidation implements Validator{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        if(new com.tsystems.demail.Validation.Validator().userNameChecking(o.toString()) == false){
            FacesMessage msg = new FacesMessage("Username must be between 6 and 30 characters and contain only letters (a-z) and numbers, and ending with @demail.com (length not include).");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
