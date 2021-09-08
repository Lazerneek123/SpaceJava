package com.example.spacechallengejava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.spacechallengejava.entities.Item;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSimulation(View view) {
        InputStream inputStreamPhase1 = getResources().openRawResource(R.raw.phase1);
        InputStream inputStreamPhase2 = getResources().openRawResource(R.raw.phase2);

        Simulation simulation = new Simulation();
        ArrayList<Item> arrayListItems1 = new ArrayList<>();
        ArrayList<Item> arrayListItems2 = new ArrayList<>();
        TextView outputInformation = findViewById(R.id.outputText);

        String generalInformation = getResources().getString(R.string.textSimulationRocketU1Part1);
        //Simulation for rocket model U1
        //Phase 1
        simulation.loadItems(arrayListItems1, inputStreamPhase1);
        int totalCostSimulation1 = simulation.runSimulation(simulation.loadU1(arrayListItems1));
        //Phase 2
        simulation.loadItems(arrayListItems1, inputStreamPhase1);
        totalCostSimulation1 += simulation.runSimulation(simulation.loadU1(arrayListItems1));
        generalInformation += " " + totalCostSimulation1 + " " + getResources().getString(R.string.textSimulationRocketU1Part2) + " " + totalCostSimulation1 / 100;

        generalInformation += getResources().getString(R.string.textSimulationRocketU2Part1);
        //Simulation for rocket model U2
        //Phase 1
        simulation.loadItems(arrayListItems2, inputStreamPhase2);
        int totalCostSimulation2 = simulation.runSimulation(simulation.loadU2(arrayListItems2));
        //Phase 2
        simulation.loadItems(arrayListItems2, inputStreamPhase2);
        totalCostSimulation2 += simulation.runSimulation(simulation.loadU2(arrayListItems2));
        generalInformation += " " + totalCostSimulation2 + " " + getResources().getString(R.string.textSimulationRocketU2Part2) + " " + totalCostSimulation2 / 120;

        outputInformation.setText(generalInformation);
    }
    //by Barmutov Roman
}
