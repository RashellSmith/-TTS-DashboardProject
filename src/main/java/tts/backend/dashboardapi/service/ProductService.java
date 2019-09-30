package tts.backend.dashboardapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import tts.backend.dashboardapi.model.Category;
import tts.backend.dashboardapi.model.Product;
import tts.backend.dashboardapi.repository.CategoryRepository;
import tts.backend.dashboardapi.repository.ProductRepository;
import tts.backend.dashboardapi.repository.SupplierRepository;

import javax.transaction.Transactional;

@Transactional
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                     CategoryRepository categoryRepository,
                     SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
    }
//
//    Product addProductWithNewCategory(Product product, Category category){
//productRepository.insertProduct(product);
//categoryRepository.insertCategory(category);
//}

}
