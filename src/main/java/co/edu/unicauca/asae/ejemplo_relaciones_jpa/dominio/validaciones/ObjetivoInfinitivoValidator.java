package co.edu.unicauca.asae.ejemplo_relaciones_jpa.dominio.validaciones;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;

public class ObjetivoInfinitivoValidator implements ConstraintValidator<ObjetivoInfinitivo, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) {
            return true; // No validar si la lista está vacía o es nula
        }

        if (!value.split("\\s+")[0].matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+(ar|er|ir)$")) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{objetivo.infinitivo}")
                   .addConstraintViolation();
            return false; // Retorna falso si la primera palabra no cumple la validación
        }

        return true;
    }
}