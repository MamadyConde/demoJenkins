package testJenkins.demo.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import testJenkins.demo.dao.CategoryDao;
import testJenkins.demo.dao.ProductDao;
import testJenkins.demo.entity.Category;
import testJenkins.demo.entity.Product;
import testJenkins.demo.service.BoutiqueServiceImpl;

import java.util.Arrays;
import java.util.Optional;

@WebMvcTest(controllers = BoutiqueController.class)
public class BoutiqueControllerTest {
    @MockBean
    private BoutiqueServiceImpl boutiqueService;

    @MockBean
    private ProductDao productDao;

    @MockBean
    private CategoryDao categoryDao;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET all products")
    public void productList() throws Exception {

        Product P1 = new Product(1,"Java","Apprendre Java",12.0,10);
        Product P2 = new Product(2,"Scala","Apprendre scala",10.0,10);

        Mockito.when(boutiqueService.getAllProducts()).thenReturn(Arrays.asList(P1,P2));

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id",Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].designation",Matchers.is("Java")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].description",Matchers.is("Apprendre Java")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].prix",Matchers.is(12.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].quantity",Matchers.is(10)));

    }

}
