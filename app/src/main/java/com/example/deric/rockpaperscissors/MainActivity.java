package com.example.deric.rockpaperscissors;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Random;
import java.util.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private int playerScore = 0;
    private int cpuScore = 0;
    private enum choicesEnum {Rock, Paper, Scissors}
    private ArrayList<String> choices = new ArrayList<>();
    private Map<String, String> Winner = new HashMap<>();
    private Map<String, String> Result = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        choices.add("Rock");
        choices.add("Paper");
        choices.add("Scissors");

        Winner.put("Rock","Scissors");
        Winner.put("Scissors","Paper");
        Winner.put("Paper","Rock");

        Result.put("Rock","Rock blunts scissors.");
        Result.put("Scissors","Scissors cut paper.");
        Result.put("Paper","Paper covers rock.");
    }

    public void rockButtonClicked(View v){

        TextView playerChoiceView = (TextView) findViewById(R.id.playerView);
        TextView cpuChoiceView = (TextView) findViewById(R.id.computerView);
        TextView scoreView = (TextView) findViewById(R.id.scoreView);
        TextView resultView = (TextView) findViewById(R.id.resultView);

        String playerChoice = "Rock";

        Random random = new Random();
        int index = random.nextInt(choices.size());

        String cpuChoice = choices.get(index);

        playerChoiceView.setText("Player's Weapon: " + playerChoice);
        cpuChoiceView.setText("Computer's Weapon: " + cpuChoice);


        if (playerChoice.equals(cpuChoice)) {
            resultView.setText("It's a tie!");
        }else if (cpuChoice.equals(Winner.get("Rock"))){
            playerScore = playerScore + 1;
            resultView.setText("Player wins..." + Result.get("Rock"));
        }else{
            cpuScore = cpuScore + 1;
            resultView.setText("Computer wins..." + Result.get("Paper"));
        }
        scoreView.setText("Player: " + playerScore + ", Computer: " + cpuScore);
    }

    public void paperButtonClicked(View v){
        TextView playerChoiceView = (TextView) findViewById(R.id.playerView);
        TextView cpuChoiceView = (TextView) findViewById(R.id.computerView);
        TextView scoreView = (TextView) findViewById(R.id.scoreView);
        TextView resultView = (TextView) findViewById(R.id.resultView);

        String playerChoice = "Paper";

        Random random = new Random();
        int index = random.nextInt(choices.size());

        String cpuChoice = choices.get(index);

        playerChoiceView.setText("Player's Weapon: " + playerChoice);
        cpuChoiceView.setText("Computer's Weapon: " + cpuChoice);


        if (playerChoice.equals(cpuChoice)) {
            resultView.setText("It's a tie!");
        }else if (cpuChoice.equals(Winner.get("Paper"))){
            playerScore = playerScore + 1;
            resultView.setText("Player wins..." + Result.get("Paper"));
        }else{
            cpuScore = cpuScore + 1;
            resultView.setText("Computer wins..." + Result.get("Scissors"));
        }
        scoreView.setText("Player: " + playerScore + ", Computer: " + cpuScore);
    }

    public void scissorButtonClicked(View v){
        TextView playerChoiceView = (TextView) findViewById(R.id.playerView);
        TextView cpuChoiceView = (TextView) findViewById(R.id.computerView);
        TextView scoreView = (TextView) findViewById(R.id.scoreView);
        TextView resultView = (TextView) findViewById(R.id.resultView);

        String playerChoice = "Scissors";

        Random random = new Random();
        int index = random.nextInt(choices.size());

        String cpuChoice = choices.get(index);

        playerChoiceView.setText("Player's Weapon: " + playerChoice);
        cpuChoiceView.setText("Computer's Weapon: " + cpuChoice);


        if (playerChoice.equals(cpuChoice)) {
            resultView.setText("It's a tie!");
        }else if (cpuChoice.equals(Winner.get("Scissors"))){
            playerScore = playerScore + 1;
            resultView.setText("Player wins..." + Result.get("Scissors"));
        }else{
            cpuScore = cpuScore + 1;
            resultView.setText("Computer wins..." + Result.get("Rock"));
        }
        scoreView.setText("Player: " + playerScore + ", Computer: " + cpuScore);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
