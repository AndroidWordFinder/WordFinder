package com.WordFinder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Activity for the Results Screen
 * 
 * @author cmbuck
 * @version Nov 28, 2011
 */
public class ResultsActivity extends Activity {
	// GUI components
	TextView points;
	ListView left; // found words
	ListView right; // all possible words
	Button titleScreen;
	Button playAgain;

	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            previous state saved by the last run of the activity
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.results);

		points = (TextView) findViewById(R.id.pointsTextView);
		left = (ListView) findViewById(R.id.listViewLeft);
		right = (ListView) findViewById(R.id.listViewRight);
		titleScreen = (Button) findViewById(R.id.titleScreenButton);
		playAgain = (Button) findViewById(R.id.playAgainButton);
		points.setText("Points: " + getIntent().getIntExtra("userPoints", 0)
				+ "/" + getIntent().getIntExtra("solvedPoints", 0)
				+ "  Words: "
				+ getIntent().getStringArrayExtra("userWords").length + "/"
				+ getIntent().getStringArrayExtra("solvedWords").length);

		populateListViews();
	}

	/**
	 * Makes the ListViews populate with words
	 */
	public void populateListViews() {

		// set left ListView to have the list of found words
		ArrayAdapter<String> leftAdapter = new ArrayAdapter<String>(this,
				R.layout.list_item, getIntent().getStringArrayExtra("userWords"));

		// set right ListView to have the list of all possible words
		ArrayAdapter<String> rightAdapter = new ArrayAdapter<String>(this,
				R.layout.list_item, getIntent().getStringArrayExtra(
						"solvedWords"));
		left.setAdapter(leftAdapter);
		right.setAdapter(rightAdapter);
	}

	/**
	 * Does something when the titleScreen button is clicked
	 */
	public void onTitleScreenClicked(View v) {
		startActivity(new Intent(this, TitleScreenActivity.class));
	}

	/**
	 * Does something when the playAgain button is clicked
	 */
	public void onPlayAgainClicked(View v) {
		Intent intent = new Intent(this, WordFinderActivity.class);
		intent.putExtra("size", getIntent().getIntExtra("size", 4));
		startActivity(intent);
	}

	/**
	 * Sets the string to be displayed by the points TextView
	 * 
	 * @param str
	 *            The string to be displayed
	 */
	public void setPoints(String str) {
		points.setText(str);
	}

}
