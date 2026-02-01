package org.example;

import db.DatabaseConnection;
import model.BaseEntity;
import model.Medicine;
import repository.PatientRepository;
import service.MedicineService;
import service.PatientService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        try {
            Connection con = DatabaseConnection.getConnection();
            PatientRepository repo = new PatientRepository(con);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }


        PatientService patientService = new PatientService();
        MedicineService medicineService = new MedicineService();

        try {
            for (BaseEntity p : patientService.getAllPatients()) {
                System.out.println(p.getInfo());
            }

            for (BaseEntity m : medicineService.getAllMedicines()) {
                System.out.println(m.getInfo());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        BaseEntity entity = new Medicine(99, "TestMed", 100.0);
        System.out.println(entity.getInfo());

        MedicineService service = new MedicineService();
        Medicine m = service.getMostExpensiveMedicine();

        System.out.println(m.getName() + " " + m.getPrice());
    }
}

