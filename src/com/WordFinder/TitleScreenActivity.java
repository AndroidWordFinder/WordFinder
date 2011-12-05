package com.WordFinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * The activity for the Title Screen of the WordFinder application
 *
 * @author John Mooring (jmooring)
 * @author Christopher Buck (cmbuck)
 * @author Bryan Malyn (bmalyn)
 * @version 2011.11.29
 */
public class TitleScreenActivity
    extends Activity
{

    /**
     * Creates the TitleScreenActivity
     *
     * @param savedInstanceState
     *            The saved instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title);
    }


    /**
     * Handles the event when the 4x4 button is clicked Launches WordFinder
     * activity with size 4
     *
     * @param v
     *            The clicked View
     */
    public void onStart4x4Clicked(View v)
    {
        Intent intent = new Intent(this, WordFinderActivity.class);
        intent.putExtra("size", 4);
        startActivity(intent);
    }


    /**
     * Handles the event when the 5x5 button is clicked Launches WordFinder
     * activity with size 5
     *
     * @param v
     *            The clicked View
     */
    public void onStart5x5Clicked(View v)
    {
        Intent intent = new Intent(this, WordFinderActivity.class);
        intent.putExtra("size", 5);
        startActivity(intent);
    }


    /**
     * Handles the event when the About button is clicked Launches the about
     * activity
     *
     * @param v
     *            The clicked View
     */
    public void onAboutClicked(View v)
    {
        startActivity(new Intent(this, About.class));
    }


    /**
     * Handles the event when the Instructions button is clicked
     *
     * @param v
     *            The clicked View
     */
    public void onInstructionsClicked(View v)
    {
        startActivity(new Intent(this, Instructions.class));
    }
}
