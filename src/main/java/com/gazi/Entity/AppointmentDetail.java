/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Entity;

import java.sql.Date;


/**
 *
 * @author fakdi
 */
public class AppointmentDetail {
    private String doctorCode;
    private String patiendTcNo;
    private String polyclinicName;
    private Date appointmentDate;

    public AppointmentDetail(String doctorCode, String patiendTcNo, String polyclinicName, Date AppointmentDate) {
        this.doctorCode = doctorCode;
        this.patiendTcNo = patiendTcNo;
        this.polyclinicName = polyclinicName;
        this.appointmentDate = AppointmentDate;
    }
     public AppointmentDetail(String doctorCode, String patiendTcNo, String polyclinicName) {
        this.doctorCode = doctorCode;
        this.patiendTcNo = patiendTcNo;
        this.polyclinicName = polyclinicName;
    }
    


    /**
     * @return the doctorCode
     */
    public String getDoctorCode() {
        return doctorCode;
    }

    /**
     * @param doctorCode the doctorCode to set
     */
    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    /**
     * @return the patiendTcNo
     */
    public String getPatiendTcNo() {
        return patiendTcNo;
    }

    /**
     * @param patiendTcNo the patiendTcNo to set
     */
    public void setPatiendTcNo(String patiendTcNo) {
        this.patiendTcNo = patiendTcNo;
    }

    /**
     * @return the polyclinicName
     */
    public String getPolyclinicName() {
        return polyclinicName;
    }

    /**
     * @param polyclinicName the polyclinicName to set
     */
    public void setPolyclinicName(String polyclinicName) {
        this.polyclinicName = polyclinicName;
    }

    /**
     * @return the AppointmentDate
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * @param AppointmentDate the AppointmentDate to set
     */
    public void setAppointmentDate(Date AppointmentDate) {
        this.appointmentDate = AppointmentDate;
    }
}
