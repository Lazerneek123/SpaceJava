package com.example.spacechallengejava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.spacechallengejava.entities.Item;
import com.example.spacechallengejava.entities.Rocket;
import com.example.spacechallengejava.entities.U1;
import com.example.spacechallengejava.entities.U2;

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
        ArrayList<Item> listItems1 = new ArrayList<>();
        ArrayList<Item> listItems2 = new ArrayList<>();
        TextView outputInformation = findViewById(R.id.outputText);

        StringBuilder generalInformation = new StringBuilder(getResources().getString(R.string.textSimulationRocketU1Part1));
        //Simulation for rocket model U1
        //Phase 1
        simulation.loadItems(listItems1, inputStreamPhase1);
        Rocket rocketU1 = new U1(getResources().getInteger(R.integer.countRocketU1), getResources().getInteger(R.integer.weightRocketU1), getResources().getInteger(R.integer.maxWeightRocketU1));
        int totalCostSimulation1 = simulation.runSimulation(simulation.loadRocket(listItems1, rocketU1));
        //Phase 2
        simulation.loadItems(listItems1, inputStreamPhase1);
        totalCostSimulation1 += simulation.runSimulation(simulation.loadRocket(listItems1, rocketU1));
        generalInformation.append(" ").append(totalCostSimulation1).append(" ").append(getResources().getString(R.string.textSimulationRocketU1Part2)).append(" ").append(totalCostSimulation1 / 100);
        generalInformation.append(" ").append(getResources().getString(R.string.textItem));

        for(Item item : listItems1){
            generalInformation.append(" ").append(item.getName()).append(", ");
        }

        generalInformation.append(getResources().getString(R.string.textSimulationRocketU2Part1));
        //Simulation for rocket model U2
        //Phase 1
        simulation.loadItems(listItems2, inputStreamPhase2);
        Rocket rocketU2 = new U2(getResources().getInteger(R.integer.countRocketU2), getResources().getInteger(R.integer.weightRocketU2), getResources().getInteger(R.integer.maxWeightRocketU2));
        int totalCostSimulation2 = simulation.runSimulation(simulation.loadRocket(listItems2, rocketU2));
        //Phase 2
        simulation.loadItems(listItems2, inputStreamPhase2);
        totalCostSimulation2 += simulation.runSimulation(simulation.loadRocket(listItems2, rocketU2));
        generalInformation.append(" ").append(totalCostSimulation2).append(" ").append(getResources().getString(R.string.textSimulationRocketU2Part2)).append(" ").append(totalCostSimulation2 / 120);
        generalInformation.append(" ").append(getResources().getString(R.string.textItem));

        for(Item item : listItems2){
            generalInformation.append(" ").append(item.getName()).append(", ");
        }

        outputInformation.setText(generalInformation.toString());
    }
    //by Barmutov Roman
}
