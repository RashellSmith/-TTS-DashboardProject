package tts.backend.dashboardapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tts.backend.dashboardapi.exception.ResourceNotFoundException;
import tts.backend.dashboardapi.model.Product;

import tts.backend.dashboardapi.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    @Autowired
    ProductRepository productrepository;


    @GetMapping("/product/page{page}")
    public Page<Product> getAllProduct(@PathVariable(value="page")Integer page){
         Pageable pageable = PageRequest.of(page, 20);
        Page<Product> page1 = productrepository.findAll(pageable);
        return page1;
       // return productrepository.findAll(pageable);
    }
    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productrepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(value="id")Integer id){
        return productrepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("products","id","id"));
    }

    //By category Mapping
    @GetMapping("/product/category/{category}")
    public List<Product> findByCategory(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategory(category);
    }


    // By category availability mapping
    @GetMapping("/product/category/true/{category}")
    public List<Product> findByCategoryInstock(@PathVariable(value="category" )Integer category){

        return productrepository.findByCategoryAndInstock(category);
    }

    @GetMapping("/product/category/false/{category}")
    public List<Product> findByCategoryOutstock(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndOutstock(category);

    }

    //By full price mapping
    @GetMapping("/product/price/up")
    public List<Product> findByOrderByFullPriceDesc(){
        return productrepository.findByFullPriceOrderDesc();
    };

    @GetMapping("/product/price/down")
    public List<Product> findByOrderByFullPriceAsc(){
        return productrepository.findByFullPriceOrderAsc();
    };

    //By sale price mapping
    @GetMapping("/product/sale/up")
    public List<Product> findByOrderBySalePriceDesc(){
        return productrepository.findBySalePriceOrderDesc();
    };

    @GetMapping("/product/sale/down")
    public List<Product> findByOrderBySalePriceAsc(){
        return productrepository.findBySalePriceOrderAsc();
    };

    // by discount mapping
//    @GetMapping("/product/discount/down")
//    public List<Product> findByOrderByDiscountDesc(){
//        return productrepository.findByDiscountOrderDesc();
//    };
//    @GetMapping("/product/discount/up")
//    public List<Product> findByOrderByDiscountAsc(){
//        return productrepository.findByDiscountOrderAsc();
//    };


    @PostMapping("/product/new")
    public Product creatProduct(@RequestBody Product product){
        return productrepository.save(product);
    }


    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product){
        Product tempProduct = productrepository.findById(product.getId())
                .orElseThrow(()-> new ResourceNotFoundException("products","id","id"));
        tempProduct.setProductName(product.getProductName());
        tempProduct.setAvailability(product.isAvailability());
        tempProduct.setCategory(product.getCategory());
        tempProduct.setFullPrice(product.getFullPrice());
        tempProduct.setSalePrice(product.getSalePrice());

         Product updatedProduct = productrepository.save(tempProduct);
         return updatedProduct;
    }

    @DeleteMapping("/Product/delete/{ID}")
    public ResponseEntity<?> deleteSupplier(@PathVariable(value = "Id")Integer Id){
        Product product = productrepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Products","id","id"));

        productrepository.delete(product);

        return ResponseEntity.ok().build();
    }




}
