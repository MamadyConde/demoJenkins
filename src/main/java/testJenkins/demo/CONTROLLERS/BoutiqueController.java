package testJenkins.demo.CONTROLLERS;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoutiqueController {
@GetMapping("/somme/{num}")
    public int test(@PathVariable int num){
    int a = 3;
    return somme3(a,4,num) +1
}
 public static int somme3(int a, int b, int c)
    {
        return a+b+c;
    }

}
