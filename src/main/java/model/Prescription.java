package model;

import java.util.List;

public class Prescription {

    private Patient patient;
    private List<Medicine> medicines;

    public Prescription(Patient patient, List<Medicine> medicines) {
        this.patient = patient;
        this.medicines = medicines;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }
}

