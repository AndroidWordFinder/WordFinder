package com.WordFinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Activity for the Results Screen
 *
 * @author John Mooring (jmooring)
 * @author Bryan Malyn (bmalyn)
 * @author Christopher Buck (cmbuck)
 * @version 2011.11.28
 */
public class ResultsActivity
    extends Activity
{
    // GUI components
    private TextView points;
    private ListView left;  // found words
    private ListView right; // all possible words


    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState
     *            previous state saved by the last run of the activity
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        points = (TextView)findViewById(R.id.pointsTextView);
        left = (ListView)findViewById(R.id.listViewLeft);
        right = (ListView)findViewById(R.id.listViewRight);
        init();
    }


    /**
     * Refreshes the view when the activity is resumed
     */
    public void onResume()
    {
        init();
        super.onResume();
    }


    /**
     * Finishes this activity on pause
     */
    public void onPause()
    {
        finish();
        super.onPause();
    }


    /**
     * Initialize the textView and ListViews with their proper data.
     */
    public void init()
    {
        if (getIntent() != null
            && getIntent().getStringArrayExtra("userWords") != null
            && getIntent().getStringArrayExtra("solvedWords") != null)
        {
            points.setText("Points: "
                + getIntent().getIntExtra("userPoints", 0) + "/"
                + getIntent().getIntExtra("solvedPoints", 0) + "  Words: "
                + getIntent().getStringArrayExtra("userWords").length + "/"
                + getIntent().getStringArrayExtra("solvedWords").length);

            populateListViews();
        }
    }


    /**
     * Makes the ListViews populate with words
     */
    public void populateListViews()
    {

        // set left ListView to have the list of found words
        ArrayAdapter<String> leftAdapter =
            new ArrayAdapter<String>(this, R.layout.list_item, getIntent()
                .getStringArrayExtra("userWords"));

        // set right ListView to have the list of all possible words
        ArrayAdapter<String> rightAdapter =
            new ArrayAdapter<String>(this, R.layout.list_item, getIntent()
                .getStringArrayExtra("solvedWords"));
        left.setAdapter(leftAdapter);
        right.setAdapter(rightAdapter);
    }


    /**
     * Does something when the titleScreen button is clicked
     *
     * @param v
     *            unused
     */
    public void onTitleScreenClicked(View v)
    {
        startActivity(new Intent(this, TitleScreenActivity.class));
    }


    /**
     * Does something when the playAgain button is clicked
     *
     * @param v
     *            unused
     */
    public void onPlayAgainClicked(View v)
    {
        Intent intent = new Intent(this, WordFinderActivity.class);
        intent.putExtra("size", getIntent().getIntExtra("size", 4));
        startActivity(intent);
    }

}
