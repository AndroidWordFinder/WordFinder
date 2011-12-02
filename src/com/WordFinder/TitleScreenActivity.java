package com.WordFinder;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *  The activity for the Title Screen of the WordFinder application
 *
 *  @author cmbuck
 *  @version Dec 1, 2011
 */
public class TitleScreenActivity extends Activity
{
    //GUI elements
    TextView titleTextView;
    Button start4x4;
    Button start5x5;
    Button solo;
    //Button Dummy
    Button about;
    Button instructions;

    /**
     * Creates the TitleScreenActivity
     * @param savedInstanceState The saved instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //set GUI element references
        titleTextView = (TextView)findViewById(R.id.title);
        start4x4 = (Button)findViewById(R.id.start4x4Button);
        start5x5 = (Button)findViewById(R.id.start5x5Button);
        solo = (Button)findViewById(R.id.soloButton);
        about = (Button)findViewById(R.id.aboutButton);
        instructions = (Button)findViewById(R.id.instructionsButton);

        setContentView(R.layout.title);
    }

    /**
     * Loads the dictionary of words
     */
    public void loadDictionary()
    {
        //TODO: load the dictionary
    }

    /**
     * Handles the event when the 4x4 button is clicked
     * @param v The clicked View
     */
    public void onStart4x4Clicked(View v)
    {
        startActivity(new Intent(this, WordFinderActivity.class));
    }

    /**
    * Handles the event when the 5x5 button is clicked
    * @param v The clicked View
    */
    public void onStart5x5Clicked(View v)
    {

    }

    /**
    * Handles the event when the Solo button is clicked
    * @param v The clicked View
    */
    public void onSoloClicked(View v)
    {

    }

    /**
     * Handles the event when the About button is clicked
     * @param v The clicked View
     */
    public void onAboutClicked(View v)
    {
        startActivity(new Intent(this, About.class));
    }

    /**
     * Handles the event when the Instructions button is clicked
     * @param v The clicked View
     */
    public void onInstructionsClicked(View v)
    {
        //start the InstructionsActivity once there is one
        //startActivity(new Intent(this, Instructions.class));
    }
}
