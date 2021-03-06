package com.stroopy.marksuyat;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

public class OrbitAnimation {

    private PointF circePoint = new PointF(0, 0);
    private PointF wayPoint = new PointF(0, 0);
    private PointF circleVelocity = new PointF(0f, 0f);
    private float gravity = 0.01f;
    private Paint paint;
    private float attraction;
    private int colorCircle;
    private int colorWaypoint;

    public OrbitAnimation(float attraction, int colorCircle, int colorWaypoint) {
	this.colorCircle = colorCircle;
	this.colorWaypoint = colorWaypoint;
	paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	this.attraction = attraction;
    }

    public void draw(Canvas canvas) {
	float width = canvas.getWidth();
	float height = canvas.getHeight();
	calcVelocity();
	moveCircle();

	if (circePoint.x >= width || circePoint.x <= 0) {
	    circleVelocity.x *= -1;
	}
	if (circePoint.y >= height || circePoint.y <= 0) {
	    circleVelocity.y *= -1;
	}
	float radius = (width / 16f);

	paint.setColor(colorWaypoint);
	canvas.drawCircle(wayPoint.x, wayPoint.y, radius / 2f, paint);
	paint.setColor(colorCircle);
	canvas.drawCircle(circePoint.x, circePoint.y, radius, paint);

    }

    private void calcVelocity() {
	float maxV = 5f;
	if (wayPoint.x > circePoint.x) {
	    circleVelocity.x += attraction * gravity;
	} else {
	    circleVelocity.x -= attraction * gravity;
	}
	if (wayPoint.y > circePoint.y) {
	    circleVelocity.y += attraction * gravity;
	} else {
	    circleVelocity.y -= attraction * gravity;
	}
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
