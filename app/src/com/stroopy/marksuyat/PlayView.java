package com.stroopy.marksuyat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PlayView extends View {

    private PointF circePoint = new PointF(0, 0);
    private PointF wayPoint = new PointF(0, 0);
    private PointF circleVelocity = new PointF(0f, 0f);
    private float gravity = 0.01f;

    public PlayView(Context context) {
	super(context);
	init();
    }

    public PlayView(Context context, AttributeSet attrs) {
	super(context, attrs);
	init();
    }

    public PlayView(Context context, AttributeSet attrs, int defStyleAttr) {
	super(context, attrs, defStyleAttr);
	init();
    }

    private Paint paint;

    private void init() {
	Log.i("tag", "hey!");
	paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
	float width = canvas.getWidth();
	float height = canvas.getHeight();
	calcVelocity();
	moveCircle();

	float radius = (width / 16f);
	paint.setColor(Color.GREEN);
	canvas.drawCircle(wayPoint.x, wayPoint.y, radius / 2f, paint);
	paint.setColor(Color.MAGENTA);
	canvas.drawCircle(circePoint.x, circePoint.y, radius, paint);
	// Log.e("ss", circePoint.x + "");

    }

    private void calcVelocity() {
	float maxV = 5f;
	if (wayPoint.x > circePoint.x) {
	    circleVelocity.x += 22f * gravity;
	} else {
	    circleVelocity.x -= 22f * gravity;
	}
	if (wayPoint.y > circePoint.y) {
	    circleVelocity.y += 22f * gravity;
	} else {
	    circleVelocity.y -= 22f * gravity;
	}
	//
	// circleVelocity.y += gravity;
    }

    private void moveCircle() {
	circePoint.x += circleVelocity.x;
	circePoint.y += circleVelocity.y;
    }

    public void onTouch(float x, float y) {
	wayPoint.x = x;
	wayPoint.y = y;
    }
}
