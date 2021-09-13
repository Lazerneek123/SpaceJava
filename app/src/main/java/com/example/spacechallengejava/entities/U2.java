package com.example.spacechallengejava.entities;

import java.util.Random;

public class U2 extends Rocket {

    public U2(int cost, int weight, int maxWeight){
        setCost(cost);
        setWeight(weight);
        setMaxWeight(maxWeight);
    }

    @Override
    public boolean launch(){
        setLaunchExplosion(4 * ((getFillWeight() - getWeight()) / getMaxWeight()));
        return getLaunchExplosion() < new Random().nextInt(8);
    }

    @Override
    public boolean land(){
        setLandingCrash(8 * ((getFillWeight() - getWeight()) / getMaxWeight()));
        return getLandingCrash() < new Random().nextInt(16);
    }
}
