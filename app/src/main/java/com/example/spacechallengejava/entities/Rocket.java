package com.example.spacechallengejava.entities;

import com.example.spacechallengejava.SpaceShip;

public class Rocket implements SpaceShip {

    private int cost, weight, maxWeight, fillWeight;
    private double launchExplosion, landingCrash;

    public int getCost(){ return cost; }
    void setCost(int cost) {
        this.cost = cost;
    }

    int getWeight(){ return weight; }
    void setWeight(int weight) {
        this.weight = weight;
    }

    int getMaxWeight(){ return maxWeight; }
    void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    int getFillWeight(){ return fillWeight; }

    double getLaunchExplosion(){
        return launchExplosion;
    }
    void setLaunchExplosion(double launchExplosion){
        if(launchExplosion > 0){
            this.launchExplosion = launchExplosion;
        }
        else{
            this.launchExplosion = 0;
        }
    }

    double getLandingCrash(){
        return landingCrash;
    }
    void setLandingCrash(double landingCrash){
        if(landingCrash > 0){
            this.landingCrash = landingCrash;
        }
        else{
            this.landingCrash = 0;
        }
    }

    public boolean launch() { return true; }
    public boolean land() { return true; }

    public boolean canCarry(Item item) {
        return fillWeight + item.getWeight() <= maxWeight;
    }

    public int carry(Item item) {
        fillWeight += item.getWeight();
        return fillWeight;
    }
}
