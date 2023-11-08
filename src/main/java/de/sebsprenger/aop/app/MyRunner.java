package de.sebsprenger.aop.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private Partner partner;

    public MyRunner(Partner partner) {
        this.partner = partner;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            partner.doStuff("world!");
            System.out.println("--------------------------------------------");
            partner.throwStuff("boom");
        } catch (Exception e) {
            System.err.println("Error detected. kthxbye.");
        }
    }

}
