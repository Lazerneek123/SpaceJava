package com.example.spacechallengejava.entities;

import java.util.Random;

public class U2 extends Rocket {
    @Override
    public int getCost(){ return 120; }

    @Override
    protected int getWeight(){ return 18000; }

    @Override
    protected int getMaxWeight(){ return 29000; }

    @Override
    public boolean launch(){
        setLaunchExplosion(4 * (getFillWeight()/ getMaxWeight()));
        return getLaunchExplosion() < new Random().nextInt(8);
    }

    @Override
    public boolean land(){
        setLandingCrash(8 * (getFillWeight() / getMaxWeight()));
        return getLandingCrash() < new Random().nextInt(16);
    }
}
