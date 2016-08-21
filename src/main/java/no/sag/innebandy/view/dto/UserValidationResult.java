package no.sag.innebandy.view.dto;

public class UserValidationResult
{
    private boolean errors;
    private String nameErrorMsg;
    private String phoneErrorMsg;

    public String getNameErrorMsg() {
        return nameErrorMsg;
    }

    public void setNameErrorMsg(String nameErrorMsg) {
        this.nameErrorMsg = nameErrorMsg;
    }

    public String getPhoneErrorMsg() {
        return phoneErrorMsg;
    }

    public void setPhoneErrorMsg(String phoneErrorMsg) {
        this.phoneErrorMsg = phoneErrorMsg;
    }

    public boolean getErrors() {
        return errors;
    }

    public void setErrors(boolean errors) {
        this.errors = errors;
    }
}
