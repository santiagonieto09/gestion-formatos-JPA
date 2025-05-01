package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.validaciones;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ObjetivoInfinitivoValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ObjetivoInfinitivo {
    String message() default "{objetivo.infinitivo}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}