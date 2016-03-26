package com.mobikit.mobikit.login;

public class User {

    public String name;
    String username;
    String password;
    int age;

    public User(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this("", -1, username, password);
    }
}
