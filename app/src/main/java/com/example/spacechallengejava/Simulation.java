package com.example.spacechallengejava;

import com.example.spacechallengejava.entities.Item;
import com.example.spacechallengejava.entities.Rocket;

import java.util.ArrayList;
import java.io.*;

class Simulation {

    void loadItems(ArrayList<Item> arrayListItems, InputStream inputStream) {

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

    ArrayList<Rocket> loadRocket(ArrayList<Item> itemList, Rocket rocket) {
        ArrayList<Rocket> rocketModelList = new ArrayList<>();

        for (Item item : itemList) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
                rocketModelList.add(rocket);
            } else {
                rocketModelList.add(rocket);
            }
        }
        return  rocketModelList;
    }

    int runSimulation(ArrayList<Rocket> rockets) {
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
