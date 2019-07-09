package com.hesc.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

/**
 * ProjectName: CustomView
 * PackageName: com.hesc.customview
 * Author: jun
 * Date: 2019-07-08 09:25
 * Copyright: (C)HESC Co.,Ltd. 2016. All rights reserved.
 */
public class TextView extends View {
    private String mText;
    private int mTextSize = 15;
    private int mTextColor = Color.BLACK;
    private Paint myPaint;

    // 构造函数会在代码里面new的时候调用
    //TextView tv = new TextView(this);
    public TextView(Context context) {
        this(context, null);
    }

    // 在布局layout中使用
    //    <com.hesc.customview.TextView
    //    android:layout_width="wrap_content"
    //    android:layout_height="wrap_content"
    //    android:text="Hello World!"
    //    tools:ignore="MissingConstraints" />
    public TextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    // 布局中有Style
    //    <com.hesc.customview.TextView
    //    style="@style/TextviewStyle"
    //    android:text="Hello World!"
    //    tools:ignore="MissingConstraints" />
    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 获取自定义属性
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TextView);
        mText = array.getString(R.styleable.TextView_ctext);
        mTextColor = array.getColor(R.styleable.TextView_ctextColor, mTextColor);
        // px sp ?
        mTextSize = array.getDimensionPixelSize(R.styleable.TextView_ctextSize, sp2px(mTextSize));
        // 回收
        array.recycle();
        myPaint = new Paint();
        myPaint.setAntiAlias(true);
        myPaint.setTextSize(mTextSize);
        myPaint.setColor(mTextColor);
    }

    private int sp2px(int sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResources().getDisplayMetrics());
    }

    /**
     * 自定义View的测量方法
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 布局的宽高都是由这个方法来指定
        // 指定控件的宽高
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        // 1、确定的值，不需要计算，给多少就是多少
        // 2、给的是wrap_content，需要计算
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST) {
            // 计算宽度  与字体的长度和大小有关  用画笔来测量
            Rect bounds = new Rect();
            // 获取文本的Rect
            myPaint.getTextBounds(mText, 0, mText.length(), bounds);
            widthSize = bounds.width();
        }

        if (heightMode == MeasureSpec.AT_MOST) {
            // 计算宽度  与字体的长度和大小有关  用画笔来测量
            Rect bounds = new Rect();
            // 获取文本的Rect
            myPaint.getTextBounds(mText, 0, mText.length(), bounds);
            heightSize = bounds.height();
        }
        // 设置控件的宽高
        setMeasuredDimension(widthSize, heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画文字  text  x    y   paint
        // x 就是开始的位置
        // y 基线  baseline
        canvas.drawText(mText, 0, getHeight() / 2, myPaint);

    }

    /**
     * 处理跟用户交互的，手指触摸
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //手指按下
                break;
            case MotionEvent.ACTION_MOVE:
                //手指移动
                break;
            case MotionEvent.ACTION_UP:
                //手指抬起
                break;
        }
        return super.onTouchEvent(event);
    }
}
