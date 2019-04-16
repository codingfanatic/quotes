/*
* Quotes
* Richard L. Clarke
* 09/22/17
* Purpose: create an application where users choose from a list of people.
 *          When they push the person's name, a quote appears.
 * Steps
 * 1. Show Buttons containing names of celebrities
 * 2. Allow them to click the button
 * 3. Display a quote from the celebrity.
* */

package com.codingfanatic.richyad.quotes;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Quotes extends Activity implements OnClickListener {

    private static String logtag = "Quotes";//for use as the tag when logging

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(logtag,"onCreate() called");
        //Restore any saved state
        super.onCreate(savedInstanceState);

        //Tell Android what to display
        setContentView(R.layout.activity_quotes);

        //1a - Show button1 (Reverend X)
        Button button1 = (Button) findViewById(R.id.RevX);

        //Method called whenever a user clicks this button (onClickListener)
        //2a - Allows user to click button1
        button1.setOnClickListener(this); //Register the revXListener OnClicklistener with button1

        //1b - Show button1 (Shannon Sharpe)
        Button button2 = (Button) findViewById(R.id.Shannon);
        //2b - Allows user to click button2
        button2.setOnClickListener(this); //Register the shannonListener OnClicklistener with button1

        //Button 3 Kanye West
        //ic - Show button3 (Kanye West)
        Button button3 = (Button) findViewById(R.id.Yeezy);
        //2c - Allows user to click button3
        button3.setOnClickListener(this);

        //1d - Show button4 (Homer Simpson)
        Button button4 = (Button) findViewById(R.id.Homer);
        //2d - Allow user to click button4
        button4.setOnClickListener(this); //Register the homerListener OnClickListener with button3

        Button button5 = (Button) findViewById(R.id.Nicki);
        button5.setOnClickListener(this);

    }

    @Override
    protected void onRestart() { //activity has been stopped and is about to be started again
        Log.d(logtag, "onRestart() called");
        super.onRestart();
    }

    @Override
    protected void onStart() {//activity is started and visible to the user
        Log.d(logtag,"onStart() called");
        super.onStart();
    }
    @Override
    protected void onResume() {//activity was resumed and is visible again
        Log.d(logtag,"onResume() called");
        super.onResume();

    }
    @Override
    protected void onPause() { //device goes to sleep or another activity appears
        Log.d(logtag,"onPause() called");//another activity is currently running (or user has pressed Home)
        super.onPause();

    }
    @Override
    protected void onStop() { //the activity is not visible anymore
        Log.d(logtag,"onStop() called");
        super.onStop();

    }
    @Override
    protected void onDestroy() {//android has killed this activity
        Log.d(logtag,"onDestroy() called");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.RevX:
                Log.d(logtag, "onClick() called - Reverend X button");
                //3a - Displays quote
                openDialog("Reverend X", "God can't PROVE he God huh?");
                Log.d(logtag, "onClick() ended - Reverend X button");
                break;

            case R.id.Shannon:
                Log.d(logtag, "onClick() called - Shannon Sharpe button");
                //3b - Displays quote
                openDialog("Shannon Sharpe", "If a frog had a pocket, he would carry a knife so he could kill the snake before it tried to eat him");
                Log.d(logtag, "onClick() ended - Shannon Sharpe button");
                break;

            case R.id.Yeezy:
                Log.d(logtag, "onClick() called - Kanye West button");
                //3c - Displays quote
                openDialog("Kanye West", "YOU AIN'T GOT THA ANSWERS, SWAY!\n" +
                    "Yeah that's great. This ain't a reality. I'm\n" +
                    "living inside of a DREAM world. We WORLD WAR Z!");
                Log.d(logtag, "onClick() ended Kanye West button");
                break;

            case R.id.Homer:
                Log.d(logtag, "onClick() called - Homer Simpson button");
                //3b - Displays quote
                openDialog("Homer", "Let's all go out for frosty chocloate milkshakes.");
                Log.d(logtag, "onClick() ended - Homer Simpson button");
                break;

            case R.id.Nicki:
                Log.d(logtag, "onClick() called - Nicki Minaj button");
                openDialog("Nicki", "Quack Quack to a duck and a chicken too, Put the hyena in a freakin' zoo!");
                Log.d(logtag, "onClick() ended - Nicki Minaj button");
                break;
        }
    }

    public void openDialog(String name, String quote){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(String.format("%s :  '%s'", name, quote));
        //alert.setIcon()
        AlertDialog dialog = alert.create();
        dialog.show();

    }
}
