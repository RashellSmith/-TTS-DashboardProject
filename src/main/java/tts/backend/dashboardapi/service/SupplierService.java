package tts.backend.dashboardapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tts.backend.dashboardapi.model.Product;
import tts.backend.dashboardapi.model.Supplier;
import tts.backend.dashboardapi.repository.SupplierRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SupplierService {
    private SupplierRepository repository;

    @Autowired
    public SupplierService(SupplierRepository repository){
        this.repository = repository;

    }

//    public List<Product> getProductsFromServiceName(String name){
//        Optional<Supplier> supplier = repository.findByName();
//
//    }
}
