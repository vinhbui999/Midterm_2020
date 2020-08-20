package com.example.midterm;

import java.util.Date;

public class HelperInfor {

    String HName;
    String Gender;
    String DOB;
    String Address;
    String Notes;
    Float Rating;
    Integer avatar=0;
    String phone;
    boolean available = false;

    public HelperInfor(String HName, String gender, String DOB, String address, String notes, Float rating) {
        this.HName = HName;
        Gender = gender;
        this.DOB = DOB;
        Address = address;
        Notes = notes;
        Rating = rating;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHName() {
        return HName;
    }

    public void setHName(String HName) {
        this.HName = HName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public Float getRating() {
        return Rating;
    }

    public void setRating(Float rating) {
        Rating = rating;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
