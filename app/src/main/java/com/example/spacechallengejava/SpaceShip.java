package com.example.spacechallengejava;

import com.example.spacechallengejava.entities.Item;

public interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    int carry(Item item);
}