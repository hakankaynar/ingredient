package com.hakankaynar.ingredient;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;


@Document(indexName = "ingredient")
public class IngredientElasticSearch {

    @Id
    private String id;

    private String uuid;

    @Field("ingredient_name")
    private String name;

    @Field("what_it_does")
    private String whatItDoes;

    @Field("all_functions")
    private String allFunctions;

    @Field("cas_ec")
    private String casEc;

    private String content;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWhatItDoes() {
        return whatItDoes;
    }

    public void setWhatItDoes(String whatItDoes) {
        this.whatItDoes = whatItDoes;
    }

    public String getAllFunctions() {
        return allFunctions;
    }

    public void setAllFunctions(String allFunctions) {
        this.allFunctions = allFunctions;
    }

    public String getCasEc() {
        return casEc;
    }

    public void setCasEc(String casEc) {
        this.casEc = casEc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", whatItDoes='" + whatItDoes + '\'' +
                ", allFunctions='" + allFunctions + '\'' +
                ", casEc='" + casEc + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public static IngredientElasticSearch from(IngredientMongo ingredientMongo) {
        IngredientElasticSearch ingredientElasticSearch = new IngredientElasticSearch();
        ingredientElasticSearch.setName(ingredientMongo.getName());
        ingredientElasticSearch.setAllFunctions(ingredientMongo.getAllFunctions());
        ingredientElasticSearch.setContent(ingredientMongo.getContent());
        ingredientElasticSearch.setCasEc(ingredientMongo.getCasEc());
        ingredientElasticSearch.setWhatItDoes(ingredientMongo.getWhatItDoes());
        ingredientElasticSearch.setUrl(ingredientMongo.getUrl());
        ingredientElasticSearch.setUuid(ingredientMongo.getUuid());
        return ingredientElasticSearch;
    }

}
