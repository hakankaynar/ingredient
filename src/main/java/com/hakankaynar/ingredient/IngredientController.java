package com.hakankaynar.ingredient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {

    private IngredientMongoRepository ingredientMongoRepository;

    public IngredientController(@Autowired IngredientMongoRepository ingredientMongoRepository) {
        this.ingredientMongoRepository = ingredientMongoRepository;
    }

    @GetMapping("/{uuid}")
    public IngredientDto get(String uuid) {

        IngredientMongo ingredientMongo = ingredientMongoRepository.findByUuid(uuid);

        if (ingredientMongo != null) {
            IngredientDto ingredientDto = IngredientDto.from(ingredientMongo);
            return ingredientDto;
        }

        return null;
    }


}
