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

    @GetMapping("/product/discount/up")
    public List<Product> getAllOrderByDiscountAsc(){
        return productrepository.findByDiscountOrderAsc();
    }

    @GetMapping("/product/discount/down")
    public List<Product> getAllOrderByDiscountDesc(){
        return productrepository.findByDiscountOrderDesc();
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

    @GetMapping("/product/category/{category}/FP/Asc")
    public List<Product> findByCategoryFPAsc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryFPAsc(category);
    }

    @GetMapping("/product/category/{category}/FP/Desc")
    public List<Product> findByCategoryFPDesc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryFPDesc(category);
    }

    @GetMapping("/product/category/{category}/SP/Asc")
    public List<Product> findByCategorySPAsc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategorySPAsc(category);
    }

    @GetMapping("/product/category/{category}/SP/Desc")
    public List<Product> findByCategorySPDesc(@PathVariable(value="category" )Integer category) {
        return productrepository.findByCategorySPDesc(category);
    }

    @GetMapping("/product/category/{category}/D/Asc")
    public List<Product> findByCategoryDAsc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryDAsc(category);
    }

    @GetMapping("/product/category/{category}/D/Desc")
    public List<Product> findByCategoryDDesc(@PathVariable(value="category" )Integer category) {
        return productrepository.findByCategoryDDesc(category);
    }

        // By category availability mapping

    @GetMapping("/product/category/true/{category}")
    public List<Product> findByCategoryInstock(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndInstock(category);
    }
    @GetMapping("/product/category/true/{category}/SP/Asc")
    public List<Product> findByCategoryAndInstockOrderBySPAsc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndInstockOrderBySPAsc(category);
    }
    @GetMapping("/product/category/true/{category}/SP/Desc")
    public List<Product> findByCategoryInstockOrderBySPDesc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndInstockOrderBySPDesc(category);
    }


    @GetMapping("/product/category/true/{category}/FP/Asc")
    public List<Product> findByCategoryInstockOrderByFPAsc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndInstockOrderByFPAsc(category);
    }
    @GetMapping("/product/category/true/{category}/FP/Desc")
    public List<Product> findByCategoryInstockOrderByFPDesc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndInstockOrderByFPDesc(category);
    }

    @GetMapping("/product/category/true/{category}/D/Asc")
    public List<Product> findByCategoryInstockOrderByDAsc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndInstockOrderByDAsc(category);
    }
    @GetMapping("/product/category/true/{category}/D/Desc")
    public List<Product> findByCategoryInstockOrderByDDesc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndInstockOrderByDDesc(category);
    }



    @GetMapping("/product/category/false/{category}")
    public List<Product> findByCategoryOutstock(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndOutstock(category);
    }
    @GetMapping("/product/category/false/{category}/SP/Asc")
    public List<Product> findByCategoryAndOutstockOrderBySPAsc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndOutstockOrderBySPAsc(category);
    }
    @GetMapping("/product/category/false/{category}/SP/Desc")
    public List<Product> findByCategoryOustockOrderBySPDesc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndOutstockOrderBySPDesc(category);
    }
    @GetMapping("/product/category/false/{category}/FP/Asc")
    public List<Product> findByCategoryAndOutstockOrderByFPAsc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndOutstockOrderByFPAsc(category);
    }
    @GetMapping("/product/category/false/{category}/FP/Desc")
    public List<Product> findByCategoryOutstockOrderByFPDesc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndOutstockOrderByFPDesc(category);
    }
    @GetMapping("/product/category/false/{category}/D/Asc")
    public List<Product> findByCategoryOutstockOrderByDAsc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndOutstockOrderByDAsc(category);
    }
    @GetMapping("/product/category/false/{category}/D/Desc")
    public List<Product> findByCategoryOutstockOrderByDDesc(@PathVariable(value="category" )Integer category){
        return productrepository.findByCategoryAndOutstockOrderByDDesc(category);
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

    @DeleteMapping("/product/delete/{Id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable(value = "Id")Integer Id){
        Product product = productrepository.findById(Id)
                .orElseThrow(()-> new ResourceNotFoundException("Products","id","id"));

        productrepository.delete(product);

        return ResponseEntity.ok().build();
    }




}
