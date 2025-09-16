package ford.app.productApp.product;

import java.util.Collection;

public interface ProductService {

    Product addProduct(Product product) throws ProductException, InvalidProductDataException;

    Product getProductById(Integer productId) throws ProductNotFoundException;

    Collection<Product> getAllProducts() throws ProductNotFoundException;

    Product updateProductPriceById(Integer productId, Double price) throws ProductNotFoundException, InvalidProductDataException;

    Product updateStock(Integer productId, Integer quantity) throws ProductNotFoundException, InvalidProductDataException;

    String deleteProduct(Integer productId) throws ProductNotFoundException;

    Product searchProductByName(String keyword) throws ProductNotFoundException;

    Collection<Product> getAllProductsByName(String name) throws ProductNotFoundException;

    Collection<Product> getAllProductsByStock(Integer stock) throws ProductNotFoundException;

    Collection<Product> getAllProductsByPriceRange(Double min, Double max) throws ProductNotFoundException;

    Collection<Product>getAllProductByNameAndPrice(String name,Double price) throws ProductNotFoundException;


    Collection<Product>getProductsByName(String name) throws ProductNotFoundException;


    //ElectronicProduct addElectronicProduct(ElectronicProduct electronicProduct) throws ProductException,InvalidProductDataException;
}
