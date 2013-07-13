/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tsystems.demail.Validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("gmailValidation")
public class GMailValidation implements javax.faces.validator.Validator
{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if(value.toString().length() > 0 && new com.tsystems.demail.Validation.Validator().gmailChecking(value.toString()) == false){
            FacesMessage msg = new FacesMessage("You can use gmail only.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}
