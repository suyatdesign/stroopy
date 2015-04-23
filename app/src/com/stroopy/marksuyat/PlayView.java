package com.stroopy.marksuyat;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class PlayView extends View {

    // private PointF circePoint = new PointF(0, 0);
    // private PointF wayPoint = new PointF(0, 0);
    // private PointF circleVelocity = new PointF(0f, 0f);
    // private float gravity = 0.01f;
    // private Paint paint;
    private DisplayWord displayWord1;
    private DisplayWord displayWord2;
    private OrbitAnimation orbitAnimation;

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

    private void init() {
	displayWord1 = new DisplayWord();
	displayWord2 = new DisplayWord();
	orbitAnimation = new OrbitAnimation(22f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
	// float width = canvas.getWidth();
	// float height = canvas.getHeight();
	// calcVelocity();
	// moveCircle();
	//
	// if (circePoint.x >= width || circePoint.x <= 0) {
	// circleVelocity.x *= -1;
	// }
	// if (circePoint.y >= height || circePoint.y <= 0) {
	// circleVelocity.y *= -1;
	// }
	// float radius = (width / 16f);
	//
	// paint.setColor(Color.GREEN);
	// canvas.drawCircle(wayPoint.x, wayPoint.y, radius / 2f, paint);
	// paint.setColor(Color.MAGENTA);
	// canvas.drawCircle(circePoint.x, circePoint.y, radius, paint);
	// paint.setColor(Color.WHITE);
	orbitAnimation.draw(canvas);
	displayWord1.draw(canvas, 250, 300);
	displayWord2.draw(canvas, 250, 500);

    }

    // private void calcVelocity() {
    // float maxV = 5f;
    // if (wayPoint.x > circePoint.x) {
    // circleVelocity.x += 22f * gravity;
    // } else {
    // circleVelocity.x -= 22f * gravity;
    // }
    // if (wayPoint.y > circePoint.y) {
    // circleVelocity.y += 22f * gravity;
    // } else {
    // circleVelocity.y -= 22f * gravity;
    // }
    // //
    // // circleVelocity.y += gravity;
    // }
    //
    // private void moveCircle() {
    // circePoint.x += circleVelocity.x;
    // circePoint.y += circleVelocity.y;
    // }

    public void onTouch(float x, float y) {
	// wayPoint.x = x;
	// wayPoint.y = y;
	orbitAnimation.onTouch(x, y);
	displayWord1.changeWord();
	displayWord2.changeWord();
    }
}
