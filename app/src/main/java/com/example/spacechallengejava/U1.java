package com.example.spacechallengejava;

import java.util.Random;

public class U1 extends  Rocket {
    public U1(){
        setCost(100);
        setWeight(10000);
        setMaxWeight(18000);
    }

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
