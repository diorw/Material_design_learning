package com.example.corodinatelayout;

/**
 * Created by wda on 2017/5/24.
 */
public class UsersBeen  {
    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private int sculpure;//头像
    private int gender;//性别
    private String description;//个人描述

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSculpure() {
        return sculpure;
    }

    public void setSculpure(int sculpure) {
        this.sculpure = sculpure;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
