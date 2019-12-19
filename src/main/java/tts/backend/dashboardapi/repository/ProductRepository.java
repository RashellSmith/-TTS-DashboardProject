package tts.backend.dashboardapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tts.backend.dashboardapi.model.Product;


import java.awt.print.Pageable;
import java.util.List;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product,Integer> {




    @Query(value= "SELECT * FROM products u WHERE  u.category = :category ", nativeQuery = true)
    List<Product> findByCategory(@Param("category") Integer category);

    @Query(value= "SELECT * FROM products u WHERE  u.category = :category order by u.full_price asc", nativeQuery = true)
    List<Product> findByCategoryFPAsc(@Param("category") Integer category);

    @Query(value= "SELECT * FROM products u WHERE  u.category = :category order by u.full_price desc", nativeQuery = true)
    List<Product> findByCategoryFPDesc(@Param("category") Integer category);

    @Query(value= "SELECT * FROM products u WHERE  u.category = :category order by u.sale_price asc", nativeQuery = true)
    List<Product> findByCategorySPAsc(@Param("category") Integer category);

    @Query(value= "SELECT * FROM products u WHERE  u.category = :category order by u.sale_price desc", nativeQuery = true)
    List<Product> findByCategorySPDesc(@Param("category") Integer category);


    @Query(value= "SELECT * FROM products u WHERE  u.category = :category order by u.discount asc", nativeQuery = true)
    List<Product> findByCategoryDAsc(@Param("category") Integer category);

    @Query(value= "SELECT * FROM products u WHERE  u.category = :category order by u.discount asc", nativeQuery = true)
    List<Product> findByCategoryDDesc(@Param("category") Integer category);



    @Query(value="SELECT * FROM products u WHERE  u.availability= 0 and u.category = :category ", nativeQuery = true)
    List<Product> findByCategoryAndOutstock(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 0 and u.category = :category order by u.sale_price asc", nativeQuery = true)
    List<Product> findByCategoryAndOutstockOrderBySPAsc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 0 and u.category = :category order by u.sale_price desc ", nativeQuery = true)
    List<Product> findByCategoryAndOutstockOrderBySPDesc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 0 and u.category = :category order by u.full_price asc", nativeQuery = true)
    List<Product> findByCategoryAndOutstockOrderByFPAsc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 0 and u.category = :category order by u.full_price desc ", nativeQuery = true)
    List<Product> findByCategoryAndOutstockOrderByFPDesc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 0 and u.category = :category order by u.discount asc", nativeQuery = true)
    List<Product> findByCategoryAndOutstockOrderByDAsc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 0 and u.category = :category order by u.discount desc ", nativeQuery = true)
    List<Product> findByCategoryAndOutstockOrderByDDesc(@Param("category") Integer category);

    @Query(value="SELECT * FROM products u WHERE  u.availability= 1 and u.category = :category", nativeQuery = true)
    List<Product> findByCategoryAndInstock(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 1 and u.category = :category order by u.sale_price asc", nativeQuery = true)
    List<Product> findByCategoryAndInstockOrderBySPAsc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 1 and u.category = :category order by u.sale_price desc ", nativeQuery = true)
    List<Product> findByCategoryAndInstockOrderBySPDesc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 1 and u.category = :category order by u.full_price asc", nativeQuery = true)
    List<Product> findByCategoryAndInstockOrderByFPAsc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 1 and u.category = :category order by u.full_price desc ", nativeQuery = true)
    List<Product> findByCategoryAndInstockOrderByFPDesc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 1 and u.category = :category order by u.discount asc", nativeQuery = true)
    List<Product> findByCategoryAndInstockOrderByDAsc(@Param("category") Integer category);
    @Query(value="SELECT * FROM products u WHERE  u.availability= 1 and u.category = :category order by u.discount desc ", nativeQuery = true)
    List<Product> findByCategoryAndInstockOrderByDDesc(@Param("category") Integer category);


    @Query(
            value = "SELECT * FROM `products` ORDER BY `full_price` DESC;",
            nativeQuery = true)
    List<Product> findByFullPriceOrderDesc();

    @Query(
            value = "SELECT * FROM `products` ORDER BY `full_price` ASC;",
            nativeQuery = true)
    List<Product> findByFullPriceOrderAsc();

    @Query(
            value = "SELECT * FROM `products` ORDER BY `sale_price` DESC;",
            nativeQuery = true)
    List<Product> findBySalePriceOrderDesc();

    @Query(
            value = "SELECT * FROM `products` ORDER BY `sale_price` ASC;",
            nativeQuery = true)
    List<Product> findBySalePriceOrderAsc();

    @Query(
            value = "SELECT * FROM products order by discount asc;",
            nativeQuery = true)
    List<Product> findByDiscountOrderAsc();

    @Query(
            value = "SELECT * FROM products order by discount desc;",
            nativeQuery = true)
    List<Product> findByDiscountOrderDesc();

}
