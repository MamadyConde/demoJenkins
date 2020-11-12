package testJenkins.demo.service;

import testJenkins.demo.entity.Category;
import testJenkins.demo.entity.Product;

import java.util.List;

public interface IboutiqueService {
    boolean addProduit(Product product);
    boolean updateProduct(int id, Product product);
    void deleteProduct(int id);
    List<Product> getAllProducts();
    Product getOneProduct(int id);
    List<Product> productByCategory(Category idCategory);

    boolean addCategory(Category category);
    void updateCategory(int id, Category category);
    void deleteCategory(int id);
    List<Category> getAllCategories();
    Category getOneCategory(int id);
}
