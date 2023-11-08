package de.sebsprenger.aop.infrastructure;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Timed {

    String value() default "empty";

}
