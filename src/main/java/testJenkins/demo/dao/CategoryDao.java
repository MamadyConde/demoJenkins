package testJenkins.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import testJenkins.demo.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {
    Category findByname(String name);
}
