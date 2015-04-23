package com.stroopy.marksuyat;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.stroopy.marksuyat.GameTimer.ITimingListener;
import com.stroopy.marksuyat.R.id;

public class MainActivity extends Activity {

    private PlayView playView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);

	setContentView(R.layout.main);
	playView = (PlayView) findViewById(id.pview);
	GameTimer.addTimingListener(new ITimingListener() {
	    public void onMainLoop(long milliSecond) {
		runOnUiThread(new Runnable() {
		    public void run() {
			MainActivity.this.onMainLoop();

		    }
		});
	    }
	});
    }

    @Override
    protected void onResume() {
	super.onResume();
	GameTimer.startTimer();
    }

    @Override
    protected void onPause() {
	GameTimer.pause();
	super.onPause();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
	int action = event.getAction();
	float x = event.getX();
	float y = event.getY();

	if (action == MotionEvent.ACTION_DOWN) {
	    // GameTimer.togglePause();
	    playView.onTouch(x, y);
	}
	if (action == MotionEvent.ACTION_MOVE) {

	}

	return super.onTouchEvent(event);
    }

    private void onMainLoop() {
	playView.invalidate();
    }
}
