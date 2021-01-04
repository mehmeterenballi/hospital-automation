/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Entity;

import java.util.Date;

/**
 *
 * @author fakdi
 */
public class PatientDetail {
    private String tcNo;
    private String patientName;
    private String patientLastName;
    private String doctorName;
    private String doctorLastName;
    private String appointmentDate;
    private String polyclinicName;

    public PatientDetail(String tcNo, String patientName, String patientLastName, String doctorName, String doctorLastName, String appointmentDate, String polyclinicName) {
        this.tcNo = tcNo;
        this.patientName = patientName;
        this.patientLastName = patientLastName;
        this.doctorName = doctorName;
        this.doctorLastName = doctorLastName;
        this.appointmentDate = appointmentDate;
        this.polyclinicName = polyclinicName;
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
     * @return the patientName
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * @param patientName the patientName to set
     */
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    /**
     * @return the patientLastName
     */
    public String getPatientLastName() {
        return patientLastName;
    }

    /**
     * @param patientLastName the patientLastName to set
     */
    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    /**
     * @return the doctorName
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * @param doctorName the doctorName to set
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**
     * @return the doctorLastName
     */
    public String getDoctorLastName() {
        return doctorLastName;
    }

    /**
     * @param doctorLastName the doctorLastName to set
     */
    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }

    /**
     * @return the appointmentDate
     */
    public String getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * @param appointmentDate the appointmentDate to set
     */
    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
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
}
