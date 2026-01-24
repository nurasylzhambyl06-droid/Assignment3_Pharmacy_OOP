package repository;

import db.DatabaseConnection;
import model.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineRepository {

    public List<Medicine> getAll() throws SQLException {
        List<Medicine> list = new ArrayList<>();
        Connection con = DatabaseConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM medicines");

        while (rs.next()) {
            list.add(new Medicine(
                    rs.getInt("medicine_id"),
                    rs.getString("medicine_name"),
                    rs.getDouble("price")
            ));
        }
        return list;
    }
}

