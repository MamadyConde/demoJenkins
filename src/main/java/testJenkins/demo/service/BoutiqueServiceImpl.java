package testJenkins.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testJenkins.demo.dao.CategoryDao;
import testJenkins.demo.dao.ProductDao;
import testJenkins.demo.entity.Category;
import testJenkins.demo.entity.Product;
import testJenkins.demo.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BoutiqueServiceImpl implements IboutiqueService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CategoryDao categoryDao;

    public BoutiqueServiceImpl() {
    }

    public BoutiqueServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    Logger log = LoggerFactory.getLogger(this.getClass());

    public boolean containsSwearWords(String comment){
        if (comment.contains("contient")) {
            throw new ProductNotFoundException("Comments contains unacceptable language");
        }
        return true;
    }
    @Override
    public boolean addProduit(Product product) {
        Product productExist = productDao.findBydesignationAndCategory(product.getDesignation(),product.getCategory());
        if (productExist != null) throw new ProductNotFoundException("Ce produit avec l'Id "+productExist.getId()+" existe dejà");
        productDao.save(product);
        return true;
    }

    @Override
    public boolean updateProduct(int id, Product product) {
        Optional<Product> productGet = productDao.findById(id);
        productGet.get().setDesignation(product.getDesignation());
        productGet.get().setDescription(product.getDescription());
        productGet.get().setPrix(product.getPrix());
        productGet.get().setQuantity(product.getQuantity());
        productGet.get().setPhoto(product.getPhoto());
        productDao.save(productGet.get());
        return true;
    }

    @Override
    public void deleteProduct(int id) {
        Optional<Product> product = productDao.findById(id);
        productDao.delete(product.get());
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> listProducts = productDao.findAll();
        return listProducts.subList(0, 3);
    }

    @Override
    public Product getOneProduct(int id) {
        Optional<Product> productGet = productDao.findById(id);
        return productGet.get();
    }

    @Override
    public List<Product> productByCategory(Category category) {
        List<Product> listProductByCategory = productDao.findBycategory(category);
        return listProductByCategory;
    }


    @Override
    public boolean addCategory(Category category) {
        categoryDao.save(category);
        return true;
    }

    @Override
    public void updateCategory(int id, Category category) {
        Optional<Category> categoryGet = categoryDao.findById(id);
        categoryGet.get().setDescription(category.getDescription());
        categoryGet.get().setName(category.getName());
        categoryGet.get().setProductsList(category.getProductsList());
        categoryDao.save(categoryGet.get());
    }

    @Override
    public void deleteCategory(int id) {
        Optional<Category> categoryGet = categoryDao.findById(id);
        categoryDao.delete(categoryGet.get());
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> listCategories = categoryDao.findAll();
        return listCategories;
    }

    @Override
    public Category getOneCategory(int id) {
        Optional<Category> categoryGet = categoryDao.findById(id);
        return categoryGet.get();
    }
}
