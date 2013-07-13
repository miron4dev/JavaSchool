package com.tsystems.demail.Validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("phoneValidation")
public class PhoneValidation implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        if(new com.tsystems.demail.Validation.Validator().phoneChecking(o.toString()) == false){
            FacesMessage msg = new FacesMessage("Phone number format is not recognized. Example: +79123456789");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}
