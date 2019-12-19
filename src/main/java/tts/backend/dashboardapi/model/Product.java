package tts.backend.dashboardapi.model;


import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;


@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)

public class Product  implements  Serializable{
    public Product() {
    }
    public Product(Integer id, String productName,Category category, double fullPrice, double salePrice, boolean availability, Supplier supplier, String discount){
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.fullPrice = fullPrice;
        this.availability = availability;
        this.supplier = supplier;
        this.discount = discount;

    }



    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    @NotBlank(message = "Product name is mandatory")
    private String productName;


    @ManyToOne
    @JoinColumn(name="category")
    @NotBlank(message = "Product name is mandatory")
    private Category category;

    @Column(name = "full_price")
    @Positive
    private double fullPrice;

    @Column(name = "sale_price")
    @Positive
    private double salePrice;

    @Column(name = "availability")
    private boolean availability;


    @ManyToOne
    @JoinColumn(name = "supplier")
    @NotBlank(message = "Product name is mandatory")
    private  Supplier supplier;

    //@Formula("full_price - sale_price/full_price")
    @Column(name="discount")
    public String discount;

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
//    public double calcDiscount(){
//        discount =(long)(((this.fullPrice - this.salePrice) / this.fullPrice *100));
//       return Math.round(discount);
//    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getFullPrice() {
//        calcDiscount();
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
//        calcDiscount();
    }

    public double getSalePrice() {
//        calcDiscount();
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
//        calcDiscount();
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}
