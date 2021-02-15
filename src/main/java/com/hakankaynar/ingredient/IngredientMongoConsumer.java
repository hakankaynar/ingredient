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

    private IngredientMongoRepository ingredientMongoRepository;
    private IngredientElasticRepository ingredientElasticRepository;
    private ObjectMapper objectMapper;

    public IngredientMongoConsumer(@Autowired IngredientMongoRepository repository,
                                   @Autowired IngredientElasticRepository elasticRepository) {
        this.ingredientMongoRepository = repository;
        this.ingredientElasticRepository = elasticRepository;

        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    @KafkaListener(topics = "ingredient-topic", groupId = "com.hakankaynar.ingredient")
    public void consume(String message) throws IOException {
        try {
            logger.info(String.format("Got new message -> %s", message));
            IngredientMessage ingredientMessage = objectMapper.readValue(message, IngredientMessage.class);
            IngredientMongo fromJson = IngredientMongo.fromMessage(ingredientMessage);
            IngredientMongo fromDb = ingredientMongoRepository.findByName(fromJson.getName());
            upsertElastic(upsertMongo(fromJson, fromDb));
        } catch (Exception e) {
            logger.info(String.format("#### -> Exception occurred for message -> %s", message), e);
        }
    }


    private IngredientMongo upsertMongo(IngredientMongo fromJson, IngredientMongo fromDb) {
        if (fromDb == null) {
            fromJson.setUuid(UUID.randomUUID().toString());
            ingredientMongoRepository.save(fromJson);
            logger.info(String.format("Inserted new ingredient -> %s", fromJson.getUuid()));
            return fromJson;
        } else {
            ingredientMongoRepository.save(fromDb.updateFields(fromJson));
            logger.info(String.format("Updated an ingredient -> %s with %s", fromDb.getUuid(), fromJson));
            return fromDb;
        }
    }

    private IngredientElasticSearch upsertElastic(IngredientMongo fromMongoDb) {
        removeIfExisting(fromMongoDb);
        return ingredientElasticRepository.save(IngredientElasticSearch.from(fromMongoDb));
    }

    private void removeIfExisting(IngredientMongo fromMongoDb) {

        try{
            IngredientElasticSearch fromEsDb = ingredientElasticRepository.findByUuid(fromMongoDb.getUuid());
            if (fromEsDb!=null) {
                ingredientElasticRepository.delete(fromEsDb);
            }
        }catch (Exception e) {
            logger.info("Problem while removing existing es instance", e);
        }

    }


}
