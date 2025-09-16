package ford.app.productApp.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //ProductDao IS-A JpaRepository
    // Custom Query
    //1.Named Query
    //JPL will be written looking at method name
    //SELECT product from Product product WHERE product.name=?(1)
    Collection<Product> findByName(String name);

    Collection<Product> findByNameContaining(String name);//wraps %name% :substring match

    //Select product from Product product where product.name like %?1% order by product.price asc
    Collection<Product> findByNameContainingOrderByPriceDesc(String name);


    Collection<Product> findByNameContainingIgnoreCaseOrderByPriceDesc(String name);


    @Query("select product from Product product where product.name like %?1% order by product.stock asc")
    Collection<Product> searchProductByNameContainingOrderByStockAsc(String name);


    Collection<Product> findProductsByPriceBetween(Double min, Double max);

    Collection<Product> findProductsByPriceGreaterThanEqual(Double minPrice);

    Collection<Product> findProductsByPriceLessThanEqual(Double maxPrice);

    Collection<Product> findProductsByStockLessThanEqual(Integer stock);

    @Query("select product from Product product where product.name=:name and product.price<=:price")
    Collection<Product> getProductsByNameAndPrice(@Param("name") String name, @Param("price") Double price);

    @NativeQuery("Select * from product where name=:pname")
    Collection<Product> searchByName(@Param("pname") String name);

    @Modifying
    @Query("Delete from Product product where product.id=:pid")
    void deleteProductById(@Param("pid") Integer id);






}
