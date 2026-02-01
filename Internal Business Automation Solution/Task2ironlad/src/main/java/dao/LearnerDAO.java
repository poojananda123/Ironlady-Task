package dao;




import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Learner;
import util.DBConnection;

public class LearnerDAO {

    public void addLearner(Learner l) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO learners(name,email,phone,program,status) VALUES(?,?,?,?,?)");
            ps.setString(1, l.getName());
            ps.setString(2, l.getEmail());
            ps.setString(3, l.getPhone());
            ps.setString(4, l.getProgram());
            ps.setString(5, l.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 // LearnerDAO.java
    public List<Learner> getAllLearners() {
        List<Learner> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM learners";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Learner l = new Learner();
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
                l.setEmail(rs.getString("email"));
                l.setPhone(rs.getString("phone"));
                l.setProgram(rs.getString("program"));
                l.setStatus(rs.getString("status"));
                list.add(l);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public Learner getLearnerById(int id) {
        Learner l = new Learner();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM learners WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                l.setId(rs.getInt("id"));
                l.setName(rs.getString("name"));
                l.setEmail(rs.getString("email"));
                l.setPhone(rs.getString("phone"));
                l.setProgram(rs.getString("program"));
                l.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return l;
    }

    public void updateLearner(Learner l) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "UPDATE learners SET name=?, email=?, phone=?, program=?, status=? WHERE id=?");

            ps.setString(1, l.getName());
            ps.setString(2, l.getEmail());
            ps.setString(3, l.getPhone());
            ps.setString(4, l.getProgram());
            ps.setString(5, l.getStatus());
            ps.setInt(6, l.getId());

            ps.executeUpdate();
        } catch (Exception e) {
         
            e.printStackTrace();
        }
    }

    public void deleteLearner(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM learners WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
