package repository;

import db.DatabaseConnection;
import model.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {

    private Connection con;

    public PatientRepository(Connection con) {
        this.con = con;
    }
    public List<Patient> getAll() throws SQLException {

        List<Patient> list = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM patients");

        while (rs.next()) {
            list.add(new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("full_name"),
                    rs.getString("phone")
            ));
        }
        return list;
    }
    public Patient getById(int id) throws SQLException {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Patient(
                    rs.getInt("patient_id"),
                    rs.getString("full_name"),
                    rs.getString("phone")
            );
        }
        return null;
    }
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}

