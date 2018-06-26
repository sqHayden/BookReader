package com.idx.reader.loginaplication;

import java.io.Serializable;

/**
 * Created by darkmi on 17-9-20.
 */

public class User implements Serializable {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {

        return id;
    }


    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String password;
    private String phoneNumber;
    public User(){
        super();
    }
    public User(String password,String phoneNumber){
        super();

        this.password = password;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
