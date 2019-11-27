package com.visionary.visionary.model;

import javax.validation.constraints.NotBlank;

public class SignUpDto extends PrivateUserProfileDto{
    @NotBlank
    private String repeatPassword;

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
