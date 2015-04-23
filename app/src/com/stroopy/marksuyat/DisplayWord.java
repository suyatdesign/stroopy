package com.stroopy.marksuyat;

import java.util.Random;

public class DisplayWord {

    private String word;

    public DisplayWord() {
	this.word = createWord();
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

    // private void onDraw(Canvas canvas) {
    // Paint color = new Paint(Paint.ANTI_ALIAS_FLAG);
    //
    // color.setColor(Color.CYAN);
    // color.setTextSize(100);
    // canvas.drawText(createWord(), 250, 300, color);
    // }
}
