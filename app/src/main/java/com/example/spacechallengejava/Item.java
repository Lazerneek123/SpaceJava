package com.example.spacechallengejava;

public class Item {
    private String name;
    private int weight;

    public Item(){ }

    public String getName(){ return name; }

    public void setName(String name){
        this.name = name;
    }

    public int getWeight(){
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