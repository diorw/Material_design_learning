package com.example.corodinatelayout;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wda on 2017/6/29.
 */
@Entity
public class User {
    @Id
    private long Id;
    @NotNull
    private String Username;
    private String email;
    private String introduce;
    private String birthday;
    private int gender;
    @Generated(hash = 1761596213)
    public User(long Id, @NotNull String Username, String email, String introduce,
            String birthday, int gender) {
        this.Id = Id;
        this.Username = Username;
        this.email = email;
        this.introduce = introduce;
        this.birthday = birthday;
        this.gender = gender;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public long getId() {
        return this.Id;
    }
    public void setId(long Id) {
        this.Id = Id;
    }
    public String getUsername() {
        return this.Username;
    }
    public void setUsername(String Username) {
        this.Username = Username;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIntroduce() {
        return this.introduce;
    }
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
    public String getBirthday() {
        return this.birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public int getGender() {
        return this.gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }


}
