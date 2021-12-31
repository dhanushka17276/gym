/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.intvaria.entity;

/**
 *
 * @author Dhanushka
 */
public class LoggedUser {
    
    Long userId;

    public LoggedUser(Long userId) {
        this.userId = userId;
    }

    public LoggedUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
}
