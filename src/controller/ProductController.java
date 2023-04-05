package controller;

import model.Product;
import service.IProductService;
import service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    public IProductService productService = new ProductServiceIMPL();
    public List<Product> getListProduct(){
        return productService.findAll();
    }
    public void createProduct(Product newProduct){
        productService.save(newProduct);
    }
    public void updateProduct (Product updateProduct){
        productService.save(updateProduct);
    }
    public Product searchProductById(int id){
        return productService.findById(id);
    }
    public List<Product> searchProductByName(String name){
        return productService.searchProductByName(name);
    }
    public void deleteProduct(int id){
        productService.deleteById(id);
    }
}
