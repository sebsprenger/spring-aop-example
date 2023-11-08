package de.sebsprenger.aop.app;

import de.sebsprenger.aop.infrastructure.Timed;
import org.springframework.stereotype.Component;

@Component
public class Partner {

    @Timed
    public String doStuff(String input) {
        System.out.println("[inside ] input=" + input);
        return "Hello " + input;
    }

    @Timed
    public String throwStuff(String input) {
        throw new RuntimeException("example");
    }

}
