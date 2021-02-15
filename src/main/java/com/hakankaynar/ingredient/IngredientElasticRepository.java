package com.hakankaynar.ingredient;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IngredientElasticRepository extends ElasticsearchRepository<IngredientElasticSearch, String> {
    IngredientElasticSearch findByUuid(String uuid);
}
