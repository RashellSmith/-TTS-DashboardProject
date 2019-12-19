package tts.backend.dashboardapi.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories")
@EntityListeners(AuditingEntityListener.class)

public class Category implements Serializable{

    public Category() {
    }

    public Category(Integer category, String categoryName, List product){
        this.category = category;
        this.categoryName = categoryName;
        this.product = product;
    }

    @Id
    @Column(name="category")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category;

    @OneToMany(mappedBy = "category")
    private List<Product> product;

    @Column(name="category_name")
    @NotBlank(message = "Product name is mandatory")
    private String categoryName;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
