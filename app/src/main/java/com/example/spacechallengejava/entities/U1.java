package com.example.spacechallengejava.entities;

import java.util.Random;

public class U1 extends Rocket {
    @Override
    public int getCost(){ return 100; }

    @Override
    protected int getWeight(){ return 10000; }

    @Override
    protected int getMaxWeight(){ return 18000; }

    @Override
    public boolean launch(){
        setLaunchExplosion(5 * (getFillWeight() / getMaxWeight()));
        return getLaunchExplosion() < new Random().nextInt(10);
    }

    @Override
    public boolean land(){
        setLandingCrash(getFillWeight() / getMaxWeight());
        return getLandingCrash() < new Random().nextInt(4);
    }
}
