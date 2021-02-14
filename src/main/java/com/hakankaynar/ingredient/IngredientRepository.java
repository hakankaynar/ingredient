package com.hakankaynar.ingredient;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    public Ingredient findByName(String name);
    public Ingredient findByUuid(String uuid);
}
