package com.bootstrapserver.repository;

import com.bootstrapserver.model.User;
import com.bootstrapserver.util.DBConnection;

import java.sql.*;

public class UserRepository {
    DBConnection dbConn;

    public UserRepository() {this.dbConn = new DBConnection();}

    public User getUser(String username){
        User user=null;
        Connection conn = dbConn.getConnection();
        String statement = "SELECT * FROM user_details NATURAL JOIN access_details WHERE username="+username;
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while (rs.next()){
                user = new User(rs.getString("username"), rs.getString("password"),
                        rs.getInt("access_level"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void saveUser(User user){
        Connection conn = dbConn.getConnection();
        String userDetailsStmt = "INSERT INTO user_details (username, password) VALUES (?, ?)";
        String userAccessStmt = "INSERT INTO peer_details (username) VALUES (?)";
        String peerDetailStmt = "INSERT INTO access_details (username, access_level) VALUES (?, ?)";
        try {
            PreparedStatement userStmt = conn.prepareStatement(userDetailsStmt);
            userStmt.setString(1, user.getUsername());
            userStmt.setString(2, user.getPassword());
            userStmt.execute();
            userStmt.close();

            PreparedStatement accessStmt = conn.prepareStatement(userAccessStmt);
            accessStmt.setString(1, user.getUsername());
            accessStmt.execute();
            accessStmt.close();

            PreparedStatement peerStmt = conn.prepareStatement(peerDetailStmt);
            peerStmt.setString(1, user.getUsername());
            peerStmt.setInt(2, user.getAccess_level());
            peerStmt.execute();
            peerStmt.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setupUserTable(){
        Connection conn = dbConn.getConnection();
        String userTableStmt = "CREATE TABLE user_details(" +
                "username VARCHAR(20)," +
                "password VARCHAR (40) NOT NULL," +
                "PRIMARY KEY (username))";
        String accessTableStmt = "CREATE TABLE access_details(" +
                "username VARCHAR(20)," +
                "access_level int NOT NULL," +
                "CONSTRAINT check_access_level CHECK (access_level IN (1,2)))";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(userTableStmt);
            stmt.execute(accessTableStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
