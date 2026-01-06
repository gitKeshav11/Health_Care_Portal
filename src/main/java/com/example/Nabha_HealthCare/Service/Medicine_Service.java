package com.example.Nabha_HealthCare.Service;

import com.example.Nabha_HealthCare.Entity.Medicine;
import com.example.Nabha_HealthCare.Repositories.Medicine_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Medicine_Service {

    @Autowired
    private Medicine_Repo medicineRepository;

    // Add Medicine
    public void addMedicine(Medicine request) {
        medicineRepository.save(request);
    }

    // Get All Medicines
    public List<Medicine> getAll() {
        return medicineRepository.findAll()
                .stream()
                .map(m -> new Medicine(
                        m.getMedicineId(), m.getName(), m.getSalts(), m.getIngredients(),
                        m.getPrice(), m.getDisease(), m.getExpiryDate(), m.getCategory(), m.getManufacturer()
                )).toList();
    }

    // Get One Medicine
    public Medicine getMedById(Long id) {
        Medicine m = medicineRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Medicine Not Found"));

        return new Medicine(
                m.getMedicineId(), m.getName(), m.getSalts(), m.getIngredients(),
                m.getPrice(), m.getDisease(), m.getExpiryDate(), m.getCategory(),m.getManufacturer()
        );
    }

    // Update Medicine
    public Medicine update(Long id, Medicine req) {
        Medicine m = medicineRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("Medicine not found"));

        m.setName(req.getName());
        m.setSalts(req.getSalts());
        m.setIngredients(req.getIngredients());
        m.setPrice(req.getPrice());
        m.setDisease(req.getDisease());
        m.setExpiryDate(req.getExpiryDate());
        m.setCategory(req.getCategory());

        Medicine saved = medicineRepository.save(m);

        return new Medicine(
                saved.getMedicineId(), saved.getName(), saved.getSalts(),
                saved.getIngredients(), saved.getPrice(), saved.getDisease(),
                saved.getExpiryDate(), saved.getCategory(),saved.getManufacturer()
        );
    }

    // Delete Medicine
    public void delete(Long id) {
        medicineRepository.deleteById(Math.toIntExact(id));
    }

    // Search By Disease
    public List<Medicine> byDisease(String disease) {
        return medicineRepository.findByDisease(disease)
                .stream()
                .map(m -> new Medicine(m.getMedicineId(), m.getName(), m.getSalts(),
                        m.getIngredients(), m.getPrice(), m.getDisease(),
                        m.getExpiryDate(), m.getCategory(), m.getManufacturer()))
                .toList();
    }

    // Search By Name
    public Medicine searchByName(String name) {
        return (Medicine) medicineRepository.findByNameContainingIgnoreCase(name).orElseThrow(()->new RuntimeException("Medicine Not Found!"));

    }
}
