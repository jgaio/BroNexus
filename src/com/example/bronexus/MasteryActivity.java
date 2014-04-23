package com.example.bronexus;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.bronexus.control.MasteryController;

public class MasteryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mastery);
		MasteryController mController = new MasteryController(this);
		mController.initialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mastery, menu);
		return true;
	}

}
