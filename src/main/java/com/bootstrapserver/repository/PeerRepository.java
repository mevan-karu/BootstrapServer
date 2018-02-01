package com.bootstrapserver.repository;

import com.bootstrapserver.model.Peer;
import com.bootstrapserver.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class PeerRepository {
    DBConnection dbConn;

    public PeerRepository(){
        this.dbConn = new DBConnection();
    }

    public Peer getPeer(String username){
        Connection conn = dbConn.getConnection();
        Peer peer = null;
        String statement = "SELECT * FROM peer_details WHERE username = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(statement);
            psmt.setString(1, username);
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                peer = new Peer();
                peer.setPeerAddress(rs.getString("peer_address"));
                peer.setPeerPort(rs.getInt("peer_port"));
                peer.setUsername(rs.getString("username"));
            }
            psmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peer;
    }

    public void updatePeerInfo(Peer peer){
        Connection conn = dbConn.getConnection();
        String statement = "UPDATE peer_details SET peer_address=?, peer_port=?, time_stamp=? WHERE username = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.setString(1, peer.getPeerAddress());
            stmt.setInt(2, peer.getPeerPort());
            stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            stmt.setString(4, peer.getUsername());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Peer> getPeerList(int size){
        int count = 0;
        Connection conn = dbConn.getConnection();
        ArrayList<Peer> peersList = new ArrayList<>();
        String statement = "SELECT * FROM peer_details ORDER BY time_stamp DESC";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while (rs.next() && count<size){
                Peer peer = new Peer();
                peer.setUsername(rs.getString("username"));
                peer.setPeerPort(rs.getInt("peer_port"));
                peer.setPeerAddress(rs.getString("peer_address"));
                peersList.add(peer);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return peersList;
    }

    public void setupPeerTable(){
        Connection conn = dbConn.getConnection();
        String statement = "CREATE TABLE peer_details(" +
                "username varchar(20), " +
                "peer_address varchar(15)," +
                "peer_port int," +
                "time_stamp TIMESTAMP," +
                "PRIMARY KEY (username)," +
                "FOREIGN KEY (username) references user_details) ";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(statement);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
