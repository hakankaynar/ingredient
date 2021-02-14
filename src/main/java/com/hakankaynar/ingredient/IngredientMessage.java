package com.hakankaynar.ingredient;


import com.fasterxml.jackson.annotation.JsonProperty;

public class IngredientMessage {

    @JsonProperty("ingredient_name")
    private String name;

    @JsonProperty("what_it_does")
    private String whatItDoes;

    @JsonProperty("all_functions")
    private String allFunctions;

    @JsonProperty("cas_ec")
    private String casEc;

    private String content;
    private String url;



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
}
