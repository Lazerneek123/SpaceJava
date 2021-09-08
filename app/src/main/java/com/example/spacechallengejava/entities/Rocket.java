package com.example.spacechallengejava.entities;

import com.example.spacechallengejava.SpaceShip;

public class Rocket implements SpaceShip {

    private int cost, weight, maxWeight, fillWeight;
    double launchExplosion, landingCrash;

    public int getCost(){ return cost; }
    protected int getWeight(){ return weight; }
    protected int getMaxWeight(){ return maxWeight; }

    public int getFillWeight(){ return fillWeight; }

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
