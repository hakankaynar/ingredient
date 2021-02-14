package com.hakankaynar.ingredient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("ingredient")
public class Ingredient {

    @Id
    private String id;

    @Indexed(unique = true)
    private String uuid;

    @Indexed(unique = true)
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

    public static Ingredient fromMessage(IngredientMessage ingredientMessage) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientMessage.getName());
        ingredient.setAllFunctions(ingredientMessage.getAllFunctions());
        ingredient.setContent(ingredientMessage.getContent());
        ingredient.setCasEc(ingredientMessage.getCasEc());
        ingredient.setWhatItDoes(ingredientMessage.getWhatItDoes());
        ingredient.setUrl(ingredientMessage.getUrl());
        return ingredient;
    }

    public Ingredient updateFields(Ingredient newIngredient) {
        setAllFunctions(newIngredient.getAllFunctions());
        setContent(newIngredient.getContent());
        setCasEc(newIngredient.getCasEc());
        setWhatItDoes(newIngredient.getWhatItDoes());
        setUrl(newIngredient.getUrl());
        return this;
    }
}
