package com.WordFinder.Tests;

import android.widget.Button;
import com.WordFinder.R;
import com.WordFinder.TitleScreenActivity;

/**
 *  Tests the TitleScreenActivity
 *
 *  @author Christopher Buck (cmbuck)
 *  @author John Mooring (jmooring)
 *  @author
 *  @version Dec 3, 2011
 */
public class TitleScreenActivityTest
    extends student.AndroidTestCase<TitleScreenActivity>
{
    private TitleScreenActivity activity;

    /**
     * Constructs a new TitleScreenActivityTest
     */
    public TitleScreenActivityTest()
    {
        super(TitleScreenActivity.class);
    }

    /**
     * Sets up the testing environment
     */
    public void setUp()
    {
        activity = getActivity();
    }

    /**
     * Clicks the start4x4 button
     */
    public void testClick4x4()
    {
        click(getView(Button.class, R.id.start4x4Button));
    }

    /**
     * Clicks the start5x5 button
     */
    public void testClick5x5()
    {
        click(getView(Button.class, R.id.start5x5Button));
    }

    /**
     * Clicks the About button
     */
    public void testClickAbout()
    {
        click(getView(Button.class, R.id.aboutButton));
    }

    /**
     * Clicks the Instructions button
     */
    public void testClickInstructions()
    {
        click(getView(Button.class, R.id.instructionsButton));
    }

}
