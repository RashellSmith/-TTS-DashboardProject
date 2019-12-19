package tts.backend.dashboardapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tts.backend.dashboardapi.model.Supplier;
import tts.backend.dashboardapi.repository.SupplierRepository;
import tts.backend.dashboardapi.exception.ResourceNotFoundException;


import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {
    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping("/supplier")
    public List<Supplier> getAllSupplier(){
        return supplierRepository.findAll();
    }


    @GetMapping("/supplier/{supplierId}")
    public Supplier getSupplierById(@PathVariable(value = "supplierId") Integer supplier){
        return supplierRepository.findById(supplier)
                .orElseThrow(() -> new ResourceNotFoundException("suppliers", "supplier", supplier));
    }

    @PostMapping("/supplier/new")
    public Supplier createSupplier(@RequestBody Supplier supplier){
        return supplierRepository.save(supplier);
    }



    @PutMapping("/supplier/update")
    public Supplier updateSupplier(@RequestBody Supplier supplier) {

        Supplier tempSupplier = supplierRepository.findById(supplier.getSupplier())
                .orElseThrow(() -> new ResourceNotFoundException("suppliers", "supplier", supplier.getSupplier()));

        tempSupplier.setSupplierName(supplier.getSupplierName());
        Supplier updatedSupplier = supplierRepository.save(tempSupplier);
        return updatedSupplier;
    }

    @DeleteMapping("/supplier/delete/{supplier}")
    public ResponseEntity<?> deleteSupplier(@PathVariable(value = "supplier") Integer supplier) {
        Supplier tempSupplier = supplierRepository.findById(supplier)
                .orElseThrow(() -> new ResourceNotFoundException("suppliers", "supplier", supplier));

        supplierRepository.delete(tempSupplier);

        return ResponseEntity.ok().build();
    }

}
