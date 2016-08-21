package no.sag.innebandy.view.validation;

import no.sag.innebandy.view.dto.UserValidationResult;
import org.springframework.util.StringUtils;

public class UserValidator
{
    private static final int MAX_NAME_LENGTH = 40;
    private static final String PHONE_REGEX = "^(((\\+47)|(0047))?\\s?\\d{8})$";


    public UserValidationResult validate(final String name, final String phone)
    {
        UserValidationResult validationResult = new UserValidationResult();

        if (StringUtils.isEmpty(name))
        {
            validationResult.setNameErrorMsg("Navn er påkrevd");
            validationResult.setErrors(true);
        }
        else if (name.length() > MAX_NAME_LENGTH)
        {
            validationResult.setNameErrorMsg("Maks 50 tegn er tillatt");
            validationResult.setErrors(true);
        }

        if (StringUtils.isEmpty(phone))
        {
            validationResult.setPhoneErrorMsg("Mobilnummer er påkrevd");
            validationResult.setErrors(true);
        }
        else if (!phone.matches(PHONE_REGEX))
        {
            validationResult.setPhoneErrorMsg("Ugyldig mobilnummer. Gyldig format er 8 siffer eller +47 eller 0047 etterfulgt av 8 siffer.");
            validationResult.setErrors(true);
        }

        return validationResult;
    }
}
