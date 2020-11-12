package testJenkins.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import testJenkins.demo.dao.ProductDao;
import testJenkins.demo.entity.Product;
import testJenkins.demo.exceptions.ProductNotFoundException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BoutiqueServiceImplTest {

    //private ProductDao productDao = Mockito.mock(ProductDao.class); //avec mockito all
    @Mock
    private ProductDao productDao;

    private BoutiqueServiceImpl boutiqueService;

    @BeforeEach
    public void setup(){
        boutiqueService = new BoutiqueServiceImpl(productDao);

    }

    @Test
    @DisplayName("quand lemot ne contient le mot")
    public void containsSwearWords() {
        BoutiqueServiceImpl boutiqueService = new BoutiqueServiceImpl();
        //Assertions.assertTrue(boutiqueService.containsSwearWords("azerty"));
        //assertTrue(boutiqueService.containsSwearWords("e"));
        assertThat(boutiqueService.containsSwearWords("AssertJ")).isTrue();
    }
    @Test
    @DisplayName("Exception quand il contient le mot")
    public void WhencontainsSwearWords() {
        BoutiqueServiceImpl boutiqueService = new BoutiqueServiceImpl();

        ProductNotFoundException exception = assertThrows(ProductNotFoundException.class, () ->{
            boutiqueService.containsSwearWords("le mot contient exite dans le comment");
        });
        assertTrue(exception.getMessage().contains("Comments contains unacceptable language"));
    }

    @Test
    @DisplayName("ajouter un produit")
    public void addProduct(){
        Product product = new Product();
        product.setId(1);
        product.setDesignation("Java");
        product.setDescription("Apprendre Java");
        product.setPrix(12.0);
        product.setQuantity(10);
        Mockito.when(productDao.findById(1)).thenReturn(Optional.of(product));
        boutiqueService.addProduit(product);
        //Mockito.verify(productDao, Mockito.times(1)).save(product);
        Mockito.verify(productDao, Mockito.times(1)).save(ArgumentMatchers.any(Product.class));
    }

}