package de.jstco.aop.app;

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
            System.out.println(partner.doStuff("world!"));
            System.out.println();
            System.out.println("--------------------------------------------");
            System.out.println();
            partner.throwStuff("boom");
        } catch (Exception e) {
            // ignore
        }
    }

}
