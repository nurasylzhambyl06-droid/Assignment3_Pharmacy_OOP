package org.example;

import model.BaseEntity;
import service.MedicineService;
import service.PatientService;

public class Main {

    public static void main(String[] args) {

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
    }
}

