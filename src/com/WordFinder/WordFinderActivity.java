package com.WordFinder;

import android.content.Intent;

import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.os.Bundle;

public class WordFinderActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
	menu.add(0,0,0,"About");
	return true;
    }

    public boolean onOptionsItemSelected(MenuItem i) {
	startActivity(new Intent(this,About.class));
	return true;
    }
}

