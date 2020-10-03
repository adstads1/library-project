/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author adamt
 */
public class Reader {

    private int id;
    private String name;
    private int mobileNumber;
    private String email;

    public Reader(int id, String name, int mobileNumber, String email) {//constructor initializes varaibles for this class.
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public int getID() {

        return id;
    }

    public String getName() {

        return name;
    }

    public int getMobileNumber() {

        return mobileNumber;
    }

    public String getEmail() {

        return email;
    }

    public void setID(int id) {

        this.id = id;

    }

    public void setName(String name) {

        this.name = name;

    }

    public void setMobileNumber(int mobileNumber) {

        this.mobileNumber = mobileNumber;

    }

    public void setEmail(String email) {

        this.email = email;

    }

    public String toString() {

        return "Reader ID: " + id + ", Reader Name: " + name + ", Reader MobileNo: " + mobileNumber + ", Reader email: " + email;
    }
}
