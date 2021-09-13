package com.example.spacechallengejava.entities;

import java.util.Random;

public class U1 extends Rocket {

    public U1(int cost, int weight, int maxWeight){
        setCost(cost);
        setWeight(weight);
        setMaxWeight(maxWeight);
    }

    @Override
    public boolean launch(){
        setLaunchExplosion(5 * ((getFillWeight() - getWeight()) / getMaxWeight()));
        return getLaunchExplosion() < new Random().nextInt(10);
    }

    @Override
    public boolean land(){
        setLandingCrash((getFillWeight() - getWeight()) / getMaxWeight());
        return getLandingCrash() < new Random().nextInt(4);
    }
}
