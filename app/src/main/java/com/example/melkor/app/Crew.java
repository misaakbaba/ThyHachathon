package com.example.melkor.app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crew {


    @SerializedName("mail")
    @Expose
    public String mail;

    @SerializedName("password")
    @Expose
    public String password;


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
