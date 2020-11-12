package testJenkins.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testJenkins.demo.entity.Category;
import testJenkins.demo.entity.Product;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

   public List<Product> findBycategory(Category IdCategory);
   public Product findBydesignationAndCategory(String designation, Category category);
}
