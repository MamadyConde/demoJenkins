package testJenkins.demo.CONTROLLERS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoutiqueController {
@GetMapping("/somme/{num}")
    public int test(@PathVariable int num){

    return somme3(3,4,num);
}
 public static int somme3(int a, int b, int c)
    {
        return a+b+c;
    }
}
