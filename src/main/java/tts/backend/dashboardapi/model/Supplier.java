package tts.backend.dashboardapi.model;



import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "suppliers")
@EntityListeners(AuditingEntityListener.class)

public class Supplier implements Serializable {
    public Supplier() {
    }

    public Supplier(Integer supplier, String supplierName, List product ) {
        this.supplier = supplier;
        this.supplierName = supplierName;
        this.product = product;
    }

    @Id

    @Column(name="supplier")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplier;

    @OneToMany(mappedBy = "supplier")
    private List<Product> product;


    @Column(name="supplier_name")
    @NotBlank(message = "Product name is mandatory")
    private String supplierName;

    public Integer getSupplier() {
        return supplier;
    }

    public void setSupplier(Integer supplier) {
        this.supplier = supplier;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
