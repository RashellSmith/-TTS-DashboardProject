package tts.backend.dashboardapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tts.backend.dashboardapi.model.Supplier;

import java.util.List;


@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {

}
