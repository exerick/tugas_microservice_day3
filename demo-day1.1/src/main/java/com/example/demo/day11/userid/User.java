package com.example.demo.day11.userid;


public class User {
    String userId;
    String nama;

    public User(String userId, String nama) {
        this.userId = userId;
        this.nama = nama;
    }

    public User() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
