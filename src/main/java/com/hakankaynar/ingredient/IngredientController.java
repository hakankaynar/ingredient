package com.hakankaynar.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class IngredientController {

    private IngredientRepository ingredientRepository;

    public IngredientController(@Autowired IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/{uuid}")
    public IngredientDto get(String uuid) {

        Ingredient ingredient = ingredientRepository.findByUuid(uuid);

        if (ingredient != null) {
            IngredientDto ingredientDto = IngredientDto.from(ingredient);
            return ingredientDto;
        }

        return null;
    }


}
