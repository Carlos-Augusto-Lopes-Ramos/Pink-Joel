package com.main.medula.models;

public class LoginModel {

    private String email;
    private String pswrd;

    public LoginModel (String email, String pswrd) {
        this.email = email;
        this.pswrd = pswrd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswrd() {
        return pswrd;
    }

    public void setPswrd(String pswrd) {
        this.pswrd = pswrd;
    }
}
