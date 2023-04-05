package service;

import model.Product;

import java.util.List;

public interface IProductService extends IGenericService<Product>{
    List<Product> searchProductByName(String name);
}
