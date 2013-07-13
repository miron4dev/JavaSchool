package com.tsystems.demail.Validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;

@FacesValidator("bDateValidation")
public class BDateValidation implements Validator{

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        Date birth_day = (Date)o;
        Date now = new Date();
        if(birth_day == null){
            FacesMessage msg = new FacesMessage("Field cannot be null.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

        if(birth_day.getTime() > now.getTime()){
            FacesMessage msg = new FacesMessage("Are you not born yet? o_O");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
