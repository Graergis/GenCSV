package ru.grishin.csv.gen;

public enum Type {
    STRING ("String"),
    DATE ("Date"),
    INTEGER ("Integer"),
    FLOAT ("Float");

    private final String type;

    Type(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
