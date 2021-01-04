/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Repository;

import com.gazi.Entity.Doctor;
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
public class JDBCDoctorRepository {

    Connection connection;
    DbHelper helper;
    Statement statement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public JDBCDoctorRepository() throws SQLException {
        try {
            helper = new DbHelper();
            connection = helper.getConnection();
            System.out.println("Connection is success.");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public ArrayList<Doctor> getAllDoctors() throws SQLException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select firstName,lastName from doctors");
            ArrayList<Doctor> doctors = new ArrayList<>();
            while (resultSet.next()) {
                doctors.add(new Doctor(resultSet.getString("firstName"), 
                        resultSet.getString("lastName")));
                
                System.out.println(resultSet.getString("firstName") + resultSet.getString("lastName"));
            }
            return doctors;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            //statement.close();
            connection.close();
        }
        return null;
    }
    
    public void addDoctor(Doctor doctor) throws SQLException{
            String sql = "insert into doctors (firstName,lastName,doctorCode) values(?,?,?)";
        preparedStatement = (PreparedStatement)connection.prepareStatement(sql);
        preparedStatement.setString(1,doctor.getFirstName());
        preparedStatement.setString(2,doctor.getLastName());
        preparedStatement.setString(3,doctor.getDoctorCode());
        int result = preparedStatement.executeUpdate();
        //statement.close();
        connection.close();
    }
 
}
