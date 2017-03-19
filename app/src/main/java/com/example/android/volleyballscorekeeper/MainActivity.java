package com.example.android.volleyballscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int setsTeamA = 0;
    int scoreTeamB = 0;
    int setsTeamB = 0;

    TextView scoreView;
    TextView scoreView2;
    TextView scoreView3;
    TextView scoreView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView2 = (TextView) findViewById(R.id.team_a_sets);
        scoreView3 = (TextView) findViewById(R.id.team_b_score);
        scoreView4 = (TextView) findViewById(R.id.team_b_sets);
    }

    // Saves variables in Bundle SavedInstanceState
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ScoreTeamA", scoreTeamA);
        outState.putInt("ScoreTeamB", scoreTeamB);
        outState.putInt("SetsTeamA", setsTeamA);
        outState.putInt("SetsTeamB", setsTeamB);
    }

    //Gets variables from savedInstanceState and displays them again
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("ScoreTeamA");
        scoreTeamB = savedInstanceState.getInt("ScoreTeamB");
        setsTeamA = savedInstanceState.getInt("SetsTeamA");
        setsTeamB = savedInstanceState.getInt("SetsTeamB");
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displaySetsForTeamA(setsTeamA);
        displaySetsForTeamB(setsTeamB);
    }

    /**
     * This method is called when the +1 score button is pressed for Team A
     */
    public void onePointForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * This method is called when the +1 set button is pressed for Team A
     */
    public void oneSetForTeamA(View v) {
        setsTeamA = setsTeamA + 1;
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displaySetsForTeamA(setsTeamA);
    }

    /**
     * This method is called when the +1 button is pressed for Team b
     */
    public void onePointForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * This method is called when the +1 sets button is pressed for Team b
     */
    public void oneSetForTeamB(View v) {
        setsTeamB = setsTeamB + 1;
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displaySetsForTeamB(setsTeamB);
    }

    public void resetScoresAndSetsTeamsAB(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        setsTeamA = 0;
        setsTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(setsTeamB);
        displaySetsForTeamA(setsTeamA);
        displaySetsForTeamB(setsTeamB);
    }

    /**
     * Displays the given score for Team A
     */
    public void displayForTeamA(int score) {
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given sets for Team A
     */
    public void displaySetsForTeamA(int score) {
        scoreView2.setText(String.valueOf(score));
    }


    /**
     * Displays the given score for Team B
     */
    public void displayForTeamB(int score) {
        scoreView3.setText(String.valueOf(score));
    }

    /**
     * Displays the given sets for Team B
     */
    public void displaySetsForTeamB(int score) {
        scoreView4.setText(String.valueOf(score));
    }


}



