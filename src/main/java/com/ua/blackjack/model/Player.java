package com.ua.blackjack.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
* the same as user
* */
@Entity
@Table(name = "players")
public class Player  extends BasicPlayer{
    private String userName;
    private String password;

    public Player() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
