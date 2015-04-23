package com.stroopy.marksuyat;

import java.util.Random;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class DisplayWord {

    private String word;
    private Paint paint;

    public DisplayWord() {
	word = createWord();
	paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private String createWord() {
	Random r = new Random();
	int i = r.nextInt(3) + 1;
	if (i == 1) {
	    return "Red";
	} else if (i == 2)
	    return "Blue";
	else
	    return "Green";
    }

    public String getWord() {
	return word;
    }

    public void changeWord() {
	this.word = createWord();
    }

    public void draw(Canvas canvas, float x, float y) {
	paint.setTextSize(99f);
	paint.setColor(Color.CYAN);
	paint.setTextSize(100);
	canvas.drawText(getWord(), x, y, paint);
    }

    public void onTouch(float x, float y) {
	changeWord();
    }
}
