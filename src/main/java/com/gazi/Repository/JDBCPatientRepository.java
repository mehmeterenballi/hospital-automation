/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Repository;

import com.gazi.Entity.Patient;
import com.gazi.Entity.PatientDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author fakdi
 */
public class JDBCPatientRepository {

    Connection connection;
    DbHelper helper;
    Statement statement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public JDBCPatientRepository() throws SQLException {
        try {
            helper = new DbHelper();
            connection = helper.getConnection();
            System.out.println("Connection is success.");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public ArrayList<Patient> getAllPatients() throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select patients.firstName,patients.lastName,patients.tcNo from patients");
            ArrayList<Patient> patients = new ArrayList<>();
            while (resultSet.next()) {
                patients.add(new Patient(resultSet.getString("tcNo"), resultSet.getString("firstName"),
                        resultSet.getString("lastName")));
            }
            return patients;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            //statement.close();
            connection.close();
        }
        return null;
    }

    public ArrayList<PatientDetail> getAllPatientDetails() throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select patients.firstName,patients.lastName,patients.tcNo,appointments.date,doctors.firstName as doctorname,doctors.lastName as doctorlastname,polyclinics.name\n"
                    + "from patients join appointments on appointments.patientid = patients.id\n"
                    + "join doctors on doctors.id = appointments.doctorid\n"
                    + "join polyclinics on polyclinics.id = appointments.polyclinicid");
            ArrayList<PatientDetail> patients = new ArrayList<>();
            while (resultSet.next()) {
                patients.add(new PatientDetail(resultSet.getString("tcNo"), resultSet.getString("firstName"),
                        resultSet.getString("lastName"), resultSet.getString("doctorname"), resultSet.getString("doctorlastname"), resultSet.getString("date"),
                        resultSet.getString("name")));
            }

            return patients;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            //statement.close();
            connection.close();
        }
        return null;
    }

    public ArrayList<PatientDetail> getAllPatientDetailByTcNo(String tcNo) throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select patients.firstName,patients.lastName,patients.tcNo,appointments.date,doctors.firstName as doctorname,doctors.lastName as doctorlastname,polyclinics.name\n"
                    + "from patients join appointments on appointments.patientid = patients.id\n"
                    + "join doctors on doctors.id = appointments.doctorid\n"
                    + "join polyclinics on polyclinics.id = appointments.polyclinicid where patients.tcNo = " + tcNo);
            ArrayList<PatientDetail> patients = new ArrayList<>();
            while (resultSet.next()) {
                patients.add(new PatientDetail(resultSet.getString("tcNo"), resultSet.getString("firstName"),
                        resultSet.getString("lastName"), resultSet.getString("doctorname"), resultSet.getString("doctorlastname"), resultSet.getString("date"),
                        resultSet.getString("name")));
            }

            return patients;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            //statement.close();
            connection.close();
        }
        return null;
    }

    public void addPatient(Patient patient) throws SQLException {
        String sql = "insert into patients (tcNo,firstName,lastName) values(?,?,?)";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

        preparedStatement.setString(1, patient.getTcNo());
        preparedStatement.setString(2, patient.getFirstName());
        preparedStatement.setString(3, patient.getLastName());
        int result = preparedStatement.executeUpdate();

        //statement.close();
        connection.close();
    }

    public void deletePatient(String tc) throws SQLException {
        String sql = "delete from patients where tcNo = ?";
        preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, tc);

        int result = preparedStatement.executeUpdate();

        //statement.close();
        connection.close();
    }

    public ArrayList<Patient> getAllPatientsWithDoctorsAndDates() throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT patients.id, patients.tcNo, patients.firstName,\n"
                    + " patients.lastName,doctors.firstName,doctors.lastName,\n"
                    + " appointments.date,polyclinics.name\n"
                    + "FROM patients\n"
                    + "JOIN appointments ON patients.id=appointments.patientid\n"
                    + "JOIN doctors ON appointments.doctorid = doctors.id\n"
                    + "JOIN polyclinics ON appointments.polyclinicid = polyclinics.id");
            ArrayList<Patient> patients = new ArrayList<>();
            while (resultSet.next()) {
                patients.add(new Patient(resultSet.getString("patients.tcNo"), resultSet.getString("polyclinics.name"),
                        resultSet.getString("doctors.firstName")));

                System.out.println(resultSet.getString("doctors.firstName") + resultSet.getString("patients.tcNo") + resultSet.getString("polyclinics.name"));
            }
            return patients;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            //statement.close();
            connection.close();
        }
        return null;
    }

}
