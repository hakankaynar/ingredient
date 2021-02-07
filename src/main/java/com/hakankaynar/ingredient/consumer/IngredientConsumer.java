package com.hakankaynar.ingredient.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class IngredientConsumer {

    private final Logger logger = LogManager.getLogger(IngredientConsumer.class);

    @KafkaListener(topics = "ingredient-topic", groupId = "com.hakankaynar.ingredient")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }

}
