package com.example.spacechallengejava;

public class Rocket implements SpaceShip{

    private int cost, weight, maxWeight, fillWeight;
    double launchExplosion, landingCrash;

    public int getCost(){
        return cost;
    }
    public void setCost(int cost){
        if(cost > 0){
            this.cost = cost;
        }
        else{
            this.cost = 0;
        }
    }

    public int getWeight(){ return weight; }
    public void setWeight(int weight){
        if(weight > 0){
            this.weight = weight;
        }
        else{
            this.weight = 0;
        }
    }

    public int getFillWeight(){ return fillWeight; }
    public void setFillWeight(int fillWeight){
        if(fillWeight > 0){
            this.fillWeight = fillWeight;
        }
        else{
            this.fillWeight = 0;
        }
    }

    public int getMaxWeight(){ return maxWeight; }
    public void setMaxWeight(int maxWeight){
        if(maxWeight > 0){
            this.maxWeight = maxWeight;
        }
        else{
            this.maxWeight = 0;
        }
    }

    public double getLaunchExplosion(){
        return launchExplosion;
    }
    public void setLaunchExplosion(double launchExplosion){
        if(launchExplosion > 0){
            this.landingCrash = launchExplosion;
        }
        else{
            this.landingCrash = 0;
        }
    }

    public double getLandingCrash(){
        return landingCrash;
    }
    public void setLandingCrash(double landingCrash){
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
