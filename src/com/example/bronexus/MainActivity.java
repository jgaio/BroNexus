package com.example.bronexus;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.bronexus.control.MainController;

public class MainActivity extends Activity {

	MainController mController = new MainController(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mController.initialize();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void badNameEntered()
	{
		mController.badNameEntered();
	}
	public void goToInfo()
	{
		mController.goToInfo();
	}

}
