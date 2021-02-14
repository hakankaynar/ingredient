package com.hakankaynar.ingredient;


public class IngredientDto {

    private String uuid;
    private String name;
    private String whatItDoes;
    private String allFunctions;
    private String casEc;
    private String content;
    private String url;


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


    public static IngredientDto from (Ingredient ingredient) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setAllFunctions(ingredient.getAllFunctions());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setUuid(ingredient.getUuid());
        ingredientDto.setContent(ingredient.getContent());
        ingredientDto.setUrl(ingredient.getUrl());
        ingredientDto.setCasEc(ingredient.getCasEc());
        ingredientDto.setWhatItDoes(ingredientDto.getWhatItDoes());

        return ingredientDto;
    }
}
