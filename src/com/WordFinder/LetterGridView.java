package com.WordFinder;

import android.graphics.BitmapFactory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.Observable;
import java.util.Observer;

// -------------------------------------------------------------------------
/**
 * Character Grid
 *
 * @author John Mooring (jmooring)
 * @author Bryan Malyn (bmalyn)
 * @version Oct 30, 2011
 */
public class LetterGridView
    extends View
    implements Observer
{

    private LetterGrid model;


    // ----------------------------------------------------------
    /**
     * Create a new LetterGridView object.
     *
     * @param context
     *            the context in which this was created
     * @param attrs
     *            the xml attributes of the view.
     */
    public LetterGridView(Context context, AttributeSet attrs)
    {
        super(context, attrs);


        Bitmap b = BitmapFactory.decodeResource(context.getResources(), R.drawable.button_down);
    }


    // ----------------------------------------------------------
    /**
     * Sets the model add attaches a observer to it.
     *
     * @param model
     */
    public void setModel(LetterGrid model)
    {
        model.addObserver(this);
        this.model = model;
    }


    public void onDraw(Canvas c) {
        Paint paint = new Paint();
        for (int x = 0; x < model.size(); x++)
        {
            for (int y = 0; y < model.size(); y++)
            {
                switch (model.getTile(x, y).getState())
                {
                    case UP:
                        break;
                    case DOWN:
                        break;
                    case GOOD:
                        break;
                    case BAD:
                        break;
                }

                c.drawBitmap(b,0,0,paint);
                //This is the domain
                //convertToCanvasSize(x),
                //convertToCanvasSize(y),
                //convertToCanvasSize(x + 1) - 1,
                //convertToCanvasSize(y + 1) - 1,

            }
    }


    /**
     * Convert cell number to pixel size.
     *
     * @param cellNumber
     *            to be converted
     * @return float the converted number
     */
    private float convertToCanvasSize(int cellNumber)
    {
        return cellNumber * getWidth() / maze.size();
    }


    /**
     * Convert pixel size to cell number.
     *
     * @param canvasSize
     *            the converted number
     * @return int to be converted
     */
    private int convertToCellNumber(float canvasSize)
    {
        return (int)(canvasSize / (double)getWidth() * maze.size());
    }


    // ----------------------------------------------------------
    /**
     * Overridden to force the view to be square (have the same width and
     * height).
     *
     * @param widthMeasureSpec
     *            the desired width as determined by the layout
     * @param heightMeasureSpec
     *            the desired height as determined by the layout
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        // Choose the smallest of the two dimensions to use for both.
        int measureSpec = Math.min(widthMeasureSpec, heightMeasureSpec);

        // Call the superclass implementation but pass it our modified width
        // and height instead of the incoming ones.
        super.onMeasure(measureSpec, measureSpec);
    }


    /**
     * When the model changes redraw the view
     */
    public void update(Observable observable, Object data)
    {
        postInvalidate();
    }
}
