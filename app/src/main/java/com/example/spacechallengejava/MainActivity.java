package com.example.spacechallengejava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;

interface SpaceShip {
    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    int carry(Item item);
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSimulation(View view) {
        InputStream inputStreamFile1 = getResources().openRawResource(R.raw.phase1);
        InputStream inputStreamFile2 = getResources().openRawResource(R.raw.phase2);

        Simulation simulation = new Simulation();
        ArrayList<Item> arrayListItems1 = new ArrayList<>();
        ArrayList<Item> arrayListItems2 = new ArrayList<>();
        TextView outputInformation = findViewById(R.id.outputText);

        String generalInformation = "Моделювання для ракет U1 (дві фази):";
        //Моделювання для ракет U1
        int totalCostSimulation1 = simulation.runSimulation(simulation.loadU1(simulation.loadItems(arrayListItems1, inputStreamFile1)));
        totalCostSimulation1 += simulation.runSimulation(simulation.loadU1(simulation.loadItems(arrayListItems1, inputStreamFile1)));
        generalInformation +="\nБюджет: " + totalCostSimulation1 + " мільйонів $ // кількість ракет U1: " + totalCostSimulation1 / 100;

        generalInformation += "\nМоделювання для ракет U2 (дві фази):";
        //Моделювання для рфкет U2
        int totalCostSimulation2 = simulation.runSimulation(simulation.loadU2(simulation.loadItems(arrayListItems2, inputStreamFile2)));
        totalCostSimulation2 += simulation.runSimulation(simulation.loadU2(simulation.loadItems(arrayListItems2, inputStreamFile2)));
        generalInformation += "\nБюджет: " + totalCostSimulation2 + " мільйонів $ // кількість ракет U2: " + totalCostSimulation2 / 120;

        outputInformation.setText(generalInformation);
    }
    //by Barmutov Roman
}
