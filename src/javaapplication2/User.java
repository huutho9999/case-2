/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

/**
 *
 * @author macbook
 */
public class User {
    private String UserName;
    private String PassWord;

    public User() {
    }

    public User(String UserName, String PassWord) {
        this.UserName = UserName;
        this.PassWord = PassWord;
    }

    

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }
    
    
}
