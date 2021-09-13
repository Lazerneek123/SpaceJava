package com.example.spacechallengejava.entities;

public class Item {
    private String name;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        if(weight > 0){
            this.weight = weight;
        }
        else{
            this.weight = 0;
        }
    }
}