package com.WordFinder.Tests;

import android.widget.Button;
import com.WordFinder.R;
import com.WordFinder.ResultsActivity;

/**
 *  Tests the ResultsActivity class
 *
 * @author John Mooring (jmooring)
 * @author Christopher Buck (cmbuck)
 * @author Bryan Malyn (bmalyn)
 * @version 2011.12.04
 */
public class ResultsActivityTest
    extends student.AndroidTestCase<ResultsActivity>
{

    private ResultsActivity activity;

    /**
     * Constructs a new ResultsActivityTest
     */
    public ResultsActivityTest()
    {
        super(ResultsActivity.class);
    }

    /**
     * Sets up the testing environment
     */
    public void setUp()
    {
        activity = getActivity();
        String [] userWords = {"dog", "cat", "hat"};
        String [] solvedWords = {"dog", "cat", "rat", "hat", "mat", "town"};
        activity.getIntent().putExtra("userWords", userWords);
        activity.getIntent().putExtra("solvedWords", solvedWords);
    }

    /**
     * Tests the onPlayAgainClicked() method
     */
    public void testOnPlayAgainClicked()
    {
        click(getView(Button.class, R.id.playAgainButton));
    }


}
