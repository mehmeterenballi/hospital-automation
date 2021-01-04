/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gazi.Repository;

import com.mysql.cj.util.StringUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author fakdi
 */
public class JDBCAppManagerRepository {

    Connection connection;
    DbHelper helper;
    Statement statement;
    ResultSet resultSet;

    public JDBCAppManagerRepository() throws SQLException {
        try {
            helper = new DbHelper();
            connection = helper.getConnection();
            System.out.println("Connection is success.");
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
    }

    public boolean validateUser(String userName, String password) throws SQLException {
        if (StringUtils.isEmptyOrWhitespaceOnly(userName) || StringUtils.isEmptyOrWhitespaceOnly(password)) {
            return false;
        }
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select userName,password from appmanagers");
            while (resultSet.next()) {
                if (userName.equals(resultSet.getString("userName")) && password.equals(resultSet.getString("password"))) {
                    return true;
                }
            }
            return false;
        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
        }
        return false;
    }

}
