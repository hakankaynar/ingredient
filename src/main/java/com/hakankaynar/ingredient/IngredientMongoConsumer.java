package com.hakankaynar.ingredient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class IngredientMongoConsumer {

    private final Logger logger = LogManager.getLogger(IngredientMongoConsumer.class);

    private IngredientRepository ingredientRepository;
    private ObjectMapper objectMapper;

    public IngredientMongoConsumer(@Autowired IngredientRepository repository) {
        this.ingredientRepository = repository;

        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @KafkaListener(topics = "ingredient-topic", groupId = "com.hakankaynar.ingredient")
    public void consume(String message) throws IOException {

        try {
            logger.info(String.format("Got new message -> %s", message));
            IngredientMessage ingredientMessage = objectMapper.readValue(message, IngredientMessage.class);
            Ingredient fromJson = Ingredient.fromMessage(ingredientMessage);
            Ingredient fromDb = ingredientRepository.findByName(fromJson.getName());
            saveOrUpdate(fromJson, fromDb);

        } catch (Exception e) {
            logger.info(String.format("#### -> Exception occurred for message -> %s", message), e);
        }

    }

    private void saveOrUpdate(Ingredient fromJson, Ingredient fromDb) {
        if (fromDb == null) {
            fromJson.setUuid(UUID.randomUUID().toString());
            ingredientRepository.save(fromJson);
            logger.info(String.format("Inserted new ingredient -> %s", fromJson.getUuid()));
        } else {
            ingredientRepository.save(fromDb.updateFields(fromJson));
            logger.info(String.format("Updated an ingredient -> %s with %s", fromDb.getUuid(), fromJson));
        }
    }

}
