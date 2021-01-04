/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Entity;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author fakdi
 */
@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "date")
    private Date date;

    @Column(name = "doctorid")
    private int doctorId;

    @Column(name = "patientid")
    private int patientid;

    @Column(name = "polyclinicid")
    private int polyclinicid;
}
