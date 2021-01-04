/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Entity;

import javax.persistence.*;

/**
 *
 * @author fakdi
 */
@Entity
@Table(name="patients")
public class Patient {
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="tcNo")
    private String tcNo;
    
    @Column(name="firstName")
    private String firstName;
    
    @Column(name="lastName")
    private String lastName;
    
    public Patient(String tcNo,String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.tcNo = tcNo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tcNo
     */
    public String getTcNo() {
        return tcNo;
    }

    /**
     * @param tcNo the tcNo to set
     */
    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
