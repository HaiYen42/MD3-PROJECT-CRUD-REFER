package service;

import Config.Config;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceIMPL implements IProductService{
    List<Product> productList = new Config<Product>().readFromFile(Config.PATH_PRODUCT);
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        Product productEdit = findById(product.getProductId()) ;
        if (productEdit==null) {
            productList.add(product);
        }else {
            int index= productList.indexOf(productEdit);
            productList.set(index, productEdit);
        }
        new Config<Product>().writeToFile(Config.PATH_PRODUCT, productList);
    }

    @Override
    public Product findById(int id) {
        for (Product product:productList) {
            if (product.getProductId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
       productList.remove(findById(id));
       new Config<Product>().writeToFile(Config.PATH_PRODUCT,productList );
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product> listSearch = new ArrayList<>();
        for (Product product:productList) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                listSearch.add(product);
            }
        }
        return listSearch;
    }
}
