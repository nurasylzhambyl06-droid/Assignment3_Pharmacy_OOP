package service;

import exceptions.DatabaseOperationException;
import model.Patient;
import repository.PatientRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PatientService {

    private Connection con;
    private PatientRepository repo = new PatientRepository(con);

    public List<Patient> getAllPatients() throws DatabaseOperationException {
        try {
            return repo.getAll();
        } catch (SQLException e) {
            throw new DatabaseOperationException("Cannot load patients");
        }
    }
}

