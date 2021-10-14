/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Deniss
 */
public class User {
    private String userFirstName;
    private String userLastName;
    private String userTelefonNumber;

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserTelefonNumber() {
        return userTelefonNumber;
    }

    public void setUserTelefonNumber(String userTelefonNumber) {
        this.userTelefonNumber = userTelefonNumber;
    }
}
