package com.WordFinder;

import android.app.Activity;
import android.os.Bundle;


/**
 *  About activity. Shows a simple view crediting the
 *  authors and describing the project.
 *
 *  @author Bryan Malyn (bmalyn)
 *  @version Oct 29, 2011
 */
public class Instructions extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);
    }
}
