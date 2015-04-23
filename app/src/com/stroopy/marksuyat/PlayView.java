package com.stroopy.marksuyat;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

public class PlayView extends View {

    private DisplayWord displayWord1;
    private DisplayWord displayWord2;
    private List<OrbitAnimation> orbitAnimations;
    private List<Integer> colors;

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
	colors = new ArrayList<Integer>();
	colors.add(Color.BLUE);
	colors.add(Color.CYAN);
	colors.add(Color.GREEN);
	colors.add(Color.RED);
	colors.add(Color.MAGENTA);
	colors.add(Color.WHITE);

	displayWord1 = new DisplayWord();
	displayWord2 = new DisplayWord();
	orbitAnimations = new ArrayList<OrbitAnimation>();

	for (int i = 0; i < 20; i++) {
	    int colorIndex = (int) Math.floor(colors.size() * Math.random());
	    int color = colors.get(colorIndex);
	    orbitAnimations.add(new OrbitAnimation(12f + (i * 5f), color, Color.CYAN));
	}
    }

    @Override
    protected void onDraw(Canvas canvas) {
	for (int i = 0; i < orbitAnimations.size(); i++) {
	    orbitAnimations.get(i).draw(canvas);
	}
	displayWord1.draw(canvas, 250, 300);
	displayWord2.draw(canvas, 250, 500);

    }

    public void onTouch(float x, float y) {
	for (int i = 0; i < orbitAnimations.size(); i++) {
	    orbitAnimations.get(i).onTouch(x, y);
	}
	displayWord1.onTouch(x, y);
	displayWord2.onTouch(x, y);
    }
}
