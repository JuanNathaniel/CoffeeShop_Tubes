/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * SINGLETON USER
 */
public class SingletonUserManager {

    private static SingletonUserManager instance;
    private User user;
    
    public static SingletonUserManager getInstance() {
        if (instance == null) {
            instance = new SingletonUserManager();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
