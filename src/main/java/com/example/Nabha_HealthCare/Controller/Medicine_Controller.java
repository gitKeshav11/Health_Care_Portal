package com.example.Nabha_HealthCare.Controller;

import com.example.Nabha_HealthCare.Entity.Medicine;
import com.example.Nabha_HealthCare.Service.Medicine_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@CrossOrigin("*")
public class Medicine_Controller {

    @Autowired
    private Medicine_Service medicineService;

    // Add Medicine
    @PostMapping("/add")
    public void add(@RequestBody Medicine request) {
        medicineService.addMedicine(request);
    }

    // Get All Medicines
    @GetMapping("/all")
    public ResponseEntity<List<Medicine>> getAll() {
        return ResponseEntity.ok(medicineService.getAll());
    }

    // Get Single Medicine
    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedById(@PathVariable Long id) {
        return ResponseEntity.ok(medicineService.getMedById(id));
    }

    // Update Medicine
    @PutMapping("/update/{id}")
    public ResponseEntity<Medicine> update(@PathVariable Long id, @RequestBody Medicine request) {
        return ResponseEntity.ok(medicineService.update(id, request));
    }

    // Delete Medicine
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        medicineService.delete(id);
        return ResponseEntity.ok("Medicine deleted successfully");
    }

    // Search By Disease
    @GetMapping("/disease/{disease}")
    public ResponseEntity<List<Medicine>> byDisease(@PathVariable String disease) {
        List<Medicine> medicines = medicineService.byDisease(disease);
        return ResponseEntity.ok(medicines);
    }

    // Search By Name
    @GetMapping("/byName")
    public Medicine searchByName(@RequestParam String name) {
        return medicineService.searchByName(name);
    }
}
