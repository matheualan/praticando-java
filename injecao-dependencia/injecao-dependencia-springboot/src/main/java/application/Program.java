package application;

import application.services.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program implements CommandLineRunner {

    @Autowired
    private PayService payService;

    public static void main(String[] args) {
        SpringApplication.run(Program.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Resultado: " + payService.finalPrice(300.0, "SP"));
    }

}
