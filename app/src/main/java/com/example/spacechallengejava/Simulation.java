package com.example.spacechallengejava;

import com.example.spacechallengejava.entities.Item;
import com.example.spacechallengejava.entities.Rocket;
import com.example.spacechallengejava.entities.U1;
import com.example.spacechallengejava.entities.U2;

import java.util.ArrayList;
import java.io.*;

public class Simulation {

    public void loadItems(ArrayList<Item> arrayListItems, InputStream inputStream) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String eachLine = bufferedReader.readLine();
            while (eachLine != null){
                String[] words = eachLine.split("=");
                Item item = new Item();
                item.setName(words[0]);
                item.setWeight(Integer.parseInt(words[1]));
                arrayListItems.add(item);
                eachLine = bufferedReader.readLine();
            }
        }
        catch (IOException ex){
            Item item = new Item();
            item.setName(ex.getMessage());
            arrayListItems.add(item);
        }
    }

    public ArrayList<Rocket>  loadU1(ArrayList<Item> itemList) {
        ArrayList<Rocket> rocketModelListU1 = new ArrayList<>();
        Rocket rocket = new U1();

        for (Item item : itemList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
                rocketModelListU1.add(rocket);
            } else {
                rocket = new U1();
                rocketModelListU1.add(rocket);
            }
        }
        return  rocketModelListU1;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemList) {
        ArrayList<Rocket> rocketModelListU2 = new ArrayList<>();
        Rocket rocket = new U2();

        for (Item item : itemList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
                rocketModelListU2.add(rocket);
            } else {
                rocket = new U2();
                rocketModelListU2.add(rocket);
            }
        }
        return rocketModelListU2;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int totalCost = 0;

        for (Rocket rocket : rockets) {
            totalCost += rocket.getCost();

            while (!rocket.launch() || !rocket.land()) {
                totalCost += rocket.getCost();
            }
        }
        return totalCost;
    }
}
