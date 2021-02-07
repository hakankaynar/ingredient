package com.hakankaynar.ingredient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IngredientController {

    @GetMapping("/")
    public IngredientDto get() {
        IngredientDto ingredient = new IngredientDto();
        ingredient.setName("Greetings from Spring Boot");
        ingredient.setUuid(UUID.randomUUID().toString());
        return ingredient;
    }


}
