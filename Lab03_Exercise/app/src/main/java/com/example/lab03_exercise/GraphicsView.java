package com.example.lab03_exercise;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Bitmap;

public class GraphicsView extends View {
//        Exercise 1 + 2
//    public GraphicsView(Context context){
//        super(context);
//    }
//    int x = 0;
//    int y = 0;
//    // Increase the dimensions of the rectangle
//    int d = 200; // width of the rectangle
//    int r = 100; // height of the rectangle
//    Exercise 1
//    @Override
//    protected void onDraw(Canvas canvas) {
//        Rect r = new Rect(400,200,40,20);
//        Paint paint = new Paint();
//        paint.setStyle(Paint.Style.FILL);
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(r, paint);
//        invalidate();
//    }
////Exercise 2
//    @Override
//    protected void onDraw(Canvas canvas) {
//        if(x!=0&&y!=0) {
//            int right = x+d;
//            int bottom = y+r;
//            Rect r = new Rect(x, y,right,bottom);
//            Paint paint = new Paint();
//            paint.setStyle(Paint.Style.FILL);
//            paint.setColor(Color.BLUE);
//            canvas.drawRect(r, paint);
//        }
//        invalidate();
//    }
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        x = (int) event.getX();
//        y = (int) event.getY();
//        return super.onTouchEvent(event);
//    }
//    //Exercise 3 + 4
    Bitmap[] frames = new Bitmap[16];
    int i = 0;
    long last_pick = 0;
    long period = 200;
    Context ctext;
    MediaPlayer mPlayer;

//    //      Exercise 3
//    public GraphicsView(Context context) {
//        super(context);
//        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
//        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
//        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);
//        frames[3] = BitmapFactory.decodeResource(getResources(), R.drawable.win_4);
//        frames[4] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
//        frames[5] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
//        frames[6] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);
//        frames[7] = BitmapFactory.decodeResource(getResources(), R.drawable.win_4);
//        frames[8] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
//        frames[9] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
//        frames[10] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);
//        frames[11] = BitmapFactory.decodeResource(getResources(), R.drawable.win_4);
//        frames[12] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
//        frames[13] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
//        frames[14] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);
//        frames[15] = BitmapFactory.decodeResource(getResources(), R.drawable.win_4);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        if (i < 16) {
//            canvas.drawBitmap(frames[i], 10, 10, new Paint());
//        } else {
//            i = 0;
//        }
//        invalidate();
//    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        i++;
//        return true;
//    }
////    Exercise 4
    public GraphicsView(Context context){
        super(context);
        ctext = context;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2; // Reduces width and height to half, quartering the total pixels

        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);
        frames[3] = BitmapFactory.decodeResource(getResources(), R.drawable.win_4);
        frames[4] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
        frames[5] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
        frames[6] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);
        frames[7] = BitmapFactory.decodeResource(getResources(), R.drawable.win_4);
        frames[8] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
        frames[9] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);
        frames[10] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
        frames[11] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);
        frames[12] = BitmapFactory.decodeResource(getResources(), R.drawable.win_3);
        frames[13] = BitmapFactory.decodeResource(getResources(), R.drawable.win_4);
        frames[14] = BitmapFactory.decodeResource(getResources(), R.drawable.win_1);
        frames[15] = BitmapFactory.decodeResource(getResources(), R.drawable.win_2);

        mPlayer = MediaPlayer.create(ctext, R.raw.sound);
        if (mPlayer != null) {
            mPlayer.setLooping(true);
            mPlayer.start();
        } else {
            // Handle error: File not found, couldn't be played, etc.
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if(i < 16 ) {
            long time = (System.currentTimeMillis() - last_pick);
            if(time >= period){
                last_pick = System.currentTimeMillis();
                canvas.drawBitmap(frames[i],40,40,new Paint());
                i++;
                postInvalidate();
            }
            else {
                canvas.drawBitmap(frames[i] , 40 , 40 , new Paint());
                postInvalidate();
            }
        }
        else{
            i = 0 ;
            postInvalidate();
        }
    }

}
