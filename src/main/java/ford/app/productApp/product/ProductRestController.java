package ford.app.productApp.product;

import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product) throws ProductException,InvalidProductDataException{
        return productService.addProduct(product);
    }
//    @PostMapping("/electronic")
//    public Product addElectronicProduct(@RequestBody ElectronicProduct electronicProduct) throws ProductException,InvalidProductDataException{
//        return productService.addElectronicProduct(electronicProduct);
//    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping
    public Collection<Product> getAllProducts() throws ProductNotFoundException {
        return productService.getAllProducts();
    }

    @PatchMapping("/{id}")
    public Product updateProductPriceById(@PathVariable Integer id, @RequestParam(value="price",defaultValue = "product", required=false) Double newPrice) throws ProductNotFoundException, InvalidProductDataException {
        return productService.updateProductPriceById(id, newPrice);
    }

    @PatchMapping("/{id}/stock")
    public Product updateProductStockById(@PathVariable Integer id, @RequestParam(value="stock",defaultValue = "Product",required = false) Integer newStock) throws ProductNotFoundException, InvalidProductDataException {
        return productService.updateStock(id, newStock);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Integer id) throws ProductNotFoundException {
        return productService.deleteProduct(id);
    }

    @GetMapping("/name/{keyword}")
    public Collection<Product> searchProductByName(@PathVariable String keyword) throws ProductNotFoundException {
        return productService.getAllProductsByName(keyword);
    }

    @GetMapping("/price")
    public Collection<Product> getAllProductsByPriceRange(@RequestParam Double min , @RequestParam(value="max",required = false) Double max) throws ProductNotFoundException {
        return productService.getAllProductsByPriceRange(min, max);
    }

    @GetMapping("/stock")
    public Collection<Product> getAllProductsByStock(@RequestParam(value= "stock" ,required = false) Integer stock) throws ProductNotFoundException {
        return productService.getAllProductsByStock(stock);
    }

    @GetMapping("/nameAndPrice")
    public Collection<Product> getAllProductByNameAndPrice(@RequestParam String name,@RequestParam Double price) throws ProductNotFoundException {
        return productService.getAllProductByNameAndPrice(name,price);
    }

    @GetMapping("/searchByName")
    public Collection<Product> getProductsByName(@RequestParam String name) throws ProductNotFoundException {
        return productService.getProductsByName(name);
    }


}
