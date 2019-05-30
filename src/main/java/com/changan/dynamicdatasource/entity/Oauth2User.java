package com.changan.dynamicdatasource.entity;

public class Oauth2User {
    private String username;

    private String email;

    private String password;

    private Boolean activated;

    private String activationkey;

    private String resetpasswordkey;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public String getActivationkey() {
        return activationkey;
    }

    public void setActivationkey(String activationkey) {
        this.activationkey = activationkey == null ? null : activationkey.trim();
    }

    public String getResetpasswordkey() {
        return resetpasswordkey;
    }

    public void setResetpasswordkey(String resetpasswordkey) {
        this.resetpasswordkey = resetpasswordkey == null ? null : resetpasswordkey.trim();
    }
}