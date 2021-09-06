package com.example.spacechallengejava;

import java.util.Random;

public class U2 extends Rocket{
    public U2(){
        setCost(120);
        setWeight(18000);
        setMaxWeight(29000);
    }

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
