package service;

import exceptions.DatabaseOperationException;
import model.Medicine;
import repository.MedicineRepository;

import java.sql.SQLException;
import java.util.List;

public class MedicineService {

    private MedicineRepository repo = new MedicineRepository();

    public Medicine getMostExpensiveMedicine() throws SQLException {
        List<Medicine> medicines = repo.getAll();
        Medicine max = medicines.get(0);
        for (Medicine m : medicines) {
            if (m.getPrice() > max.getPrice()) {
                max = m;
            }
        }
        return max;
    }
    public List<Medicine> getAllMedicines() throws DatabaseOperationException {
        try {
            return repo.getAll();
        } catch (SQLException e) {
            throw new DatabaseOperationException("Cannot load medicines");
        }
    }
}

