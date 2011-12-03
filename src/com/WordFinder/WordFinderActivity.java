package com.WordFinder;

import java.util.Observable;
import java.util.Observer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 * Main application activity.
 * 
 * @author John Mooring (jmooring)
 * @version Oct 29, 2011
 */
public class WordFinderActivity extends Activity {
	/**
	 * Called when the activity is first created.
	 */
	private static WordFinderActivity instance;
	private static TextView points;
	private static TextView timer;
	private LetterGrid grid;
	private LetterGridView board;
	private final int GRID_SIZE = 4;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;
		setContentView(R.layout.main);
		board = (LetterGridView) findViewById(R.id.letterGrid);
		points = (TextView) findViewById(R.id.points);
		timer = (TextView) findViewById(R.id.timer);
		grid = new LetterGrid();
		grid.loadRandom(getIntent().getIntExtra("size", GRID_SIZE));
		board.setModel(grid);
		getWindow().setBackgroundDrawableResource(R.drawable.background);
		grid.addObserver(new Observer() {
			public void update(Observable observable, Object data) {
				points.setText("Points: " + grid.getPoints() + "/"
						+ grid.getPossiblePoints());
			}
		});
		grid.updateAll();
	}

	public void newBoard(View v) {
		// TODO are you sure dialogue
		grid.loadRandom(getIntent().getIntExtra("size", GRID_SIZE));
	}

	public void giveUp(View v) {
		// TODO are you sure dialogue
		gotoResults();
	}

	public void gotoResults() {
		Intent intent = new Intent(this, ResultsActivity.class);
		intent.putExtra("userWords", grid.getFoundWords().toArray());
		intent.putExtra("solvedWords", WordSolver.getInstance().getWords()
				.toArray());
		startActivity(intent);
	}

	/**
	 * Returns an instance of this activity so classes can get context
	 * 
	 * @return instance of this activity
	 */
	public static WordFinderActivity getInstance() {
		return instance;
	}
}
