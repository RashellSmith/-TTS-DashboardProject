package tts.backend.dashboardapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tts.backend.dashboardapi.exception.ResourceNotFoundException;
import tts.backend.dashboardapi.model.Category;
import tts.backend.dashboardapi.repository.CategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/category")
    public List<Category> getAllCategory(){return categoryRepository.findAll();}

    @GetMapping("/category/{category}")
    public Category getCategoryById(@PathVariable(value = "category") Integer Category){
        return categoryRepository.findById(Category)
                .orElseThrow(() -> new ResourceNotFoundException("categories", "Category", Category));
    }

    @PostMapping("/category/new")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }



    @PutMapping("/category/update")
    public Category updateCategory(@RequestBody Category category) {

        Category tempCategory= categoryRepository.findById(category.getCategory())
                .orElseThrow(() -> new ResourceNotFoundException("categories", "category",category.getCategory()));
        tempCategory.setCategoryName(category.getCategoryName());

        Category updatedCategory = categoryRepository.save(tempCategory);
        return updatedCategory;
    }

    @DeleteMapping("/category/delete/{Category}")
    public ResponseEntity<?> deleteCategory(@PathVariable(value = "category") Integer category) {
        Category tempCategory= categoryRepository.findById(category)
                .orElseThrow(() -> new ResourceNotFoundException("category", "category", category));

        categoryRepository.delete(tempCategory);

        return ResponseEntity.ok().build();
    }
}
