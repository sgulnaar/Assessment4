package com.pnc.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Customer")
public class Customer {


    @Column(name = "SSN")
    @Id
    private int SSN;

//    @Column(name = "firstname")
   private String firstName;
//    @Column(name = "lasttname")
   private String lastName;
//    @Column(name = "zipCode")
   private String zipCode;

//    @Column(name = "creditCardNo")
   private long creditCardNo;

    protected Customer(){}

    public Customer(long creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public long getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(long creditCardNo) {
        this.creditCardNo = creditCardNo;
    }
}
