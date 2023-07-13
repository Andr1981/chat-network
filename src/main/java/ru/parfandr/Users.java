package ru.parfandr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Users {
    private String login;
    private String password;
    private String name;
    private String lastname;
    private String country;
    public Map<String, ArrayList<String>> regUserData = new HashMap<>();

    public Users(String login, String password, String name, String lastname, String country) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.country = country;
    }

    public Users() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
