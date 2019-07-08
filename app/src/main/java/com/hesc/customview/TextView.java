package com.hesc.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
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
        mText = array.getString(R.styleable.TextView_text);
        mTextColor = array.getColor(R.styleable.TextView_textColor, mTextColor);
        // px sp ?
        mTextSize = array.getDimensionPixelSize(R.styleable.TextView_textSize, mTextSize);
        // 回收
        array.recycle();
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

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthMode == MeasureSpec.UNSPECIFIED) {

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
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
