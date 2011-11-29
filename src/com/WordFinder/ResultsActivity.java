package com.WordFinder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.app.Activity;

/**
 *  Activity for the Results Screen
 *
 *  @author cmbuck
 *  @version Nov 28, 2011
 */
public class ResultsActivity extends Activity
{
    private LetterGrid letterGrid;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState previous state saved by the last run of the
     *     activity
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.results);
    }

    /**
     * Sets the Model reference for the Activity
     * @param lg The data model
     */
    public void setModel(LetterGrid lg)
    {
        letterGrid = lg;
    }


}
