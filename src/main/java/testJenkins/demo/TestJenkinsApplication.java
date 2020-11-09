package testJenkins.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import testJenkins.demo.CONTROLLERS.BoutiqueController;

@SpringBootApplication
public class TestJenkinsApplication implements CommandLineRunner {
    @Autowired
private BoutiqueController boutiqueController;
	public static void main(String[] args) {
		SpringApplication.run(TestJenkinsApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

    }


}
