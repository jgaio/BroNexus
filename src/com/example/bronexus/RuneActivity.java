package com.example.bronexus;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.bronexus.control.RuneController;

public class RuneActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rune);
		RuneController rController = new RuneController(this);
		rController.initialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rune, menu);
		return true;
	}

}
