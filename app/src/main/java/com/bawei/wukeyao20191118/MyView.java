package com.bawei.wukeyao20191118;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * 功能：MyView类
 * 作者：武柯耀
 * 当前日期：2019/11/18
 * 当前时间：10:30
 */
public class MyView extends View {
    private  Context mContext;
    private Paint mPaint = new Paint();
    private Path mPath = new Path();
    private Paint stokePaint;
    private int width;
    private int height;
    private float[][] ponits = new float[][]{{1,10},{2,36},{3,67},{4,23},{5,58},{6,83},{7,49},{8,58},{9,47}};
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext =context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        String string = typedArray.getString(R.styleable.MyView_my_color);
        mPaint.setColor(Color.parseColor(string));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth((float) 2.0);
        init();
        typedArray.recycle();
    }

    private void init() {
        stokePaint = new Paint();
        stokePaint.setColor(Color.RED);
        stokePaint.setStyle(Paint.Style.STROKE);
        stokePaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(50,height-50);

        drawLineX(canvas);
        drawLiney(canvas);
        drawStokeLine(canvas);
    }

    private void drawStokeLine(Canvas canvas) {
        int length = ponits.length;

        int x = (width - 100) / length;
        int y = (height - 100) / length;

        for (int i = 0; i < length; i++) {
            float xspece = ponits[i][0] % (length + 1);
            float yspece = ponits[i][1] % (length + 1);

            float xs = x * xspece;
            float ys =  y * yspece;


             if (i==0){
                 mPath.moveTo(xs,-ys);
                 canvas.drawCircle(xs,-ys,8,mPaint);

             }else {
                 mPath.lineTo(xs,-ys);
                 canvas.drawCircle(xs,-ys,8,mPaint);
             }
        }
        canvas.drawPath(mPath,stokePaint);
    }

    private void drawLiney(Canvas canvas) {
        int startx = 0;
        int starty = 0;
        int specing = (height - 100)/ponits.length;

        for (int i = 0; (starty + specing * i ) < width - 50; i++) {

            canvas.drawLine(startx,starty,startx,starty - specing * i,mPaint);

            canvas.drawCircle(startx ,starty - specing * i,5,mPaint);

            canvas.drawText(i+"",startx - 30,starty - specing * i,mPaint);
        }
    }

    private void drawLineX(Canvas canvas) {
         int startx = 0;
         int starty = 0;
         int specing = (width - 100)/ponits.length;

        for (int i = 0; (startx + specing * i ) < width - 50; i++) {

            canvas.drawLine(startx,starty,startx + specing * i,starty,mPaint);

            canvas.drawCircle(startx + specing * i,starty,5,mPaint);

            canvas.drawText(i+"",startx + specing* i,starty+30,mPaint);
        }
    }
}
