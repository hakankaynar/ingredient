package com.hakankaynar.ingredient;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientMongoRepository extends MongoRepository<IngredientMongo, String> {
    public IngredientMongo findByName(String name);
    public IngredientMongo findByUuid(String uuid);
}
