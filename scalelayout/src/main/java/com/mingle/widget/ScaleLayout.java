package com.mingle.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.mingle.scalelayout.R;

import java.lang.reflect.Type;

/**
 * 按照比例显示的RelativeLayout,主要是以 android:layout_width 的宽度为基准.忽视了android:layout_height 的属性
 * Created by zzz40500 on 15/6/22.
 */
public class ScaleLayout extends RelativeLayout {


    public float mScale;
    public ScaleLayout(Context context) {
        super(context);
    }

    public ScaleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray typedArray=getContext().obtainStyledAttributes(attrs, R.styleable.ScaleLayout);
        mScale= typedArray.getFloat(R.styleable.ScaleLayout_scale,-1);
        typedArray.recycle();

    }

    public ScaleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ScaleLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if(mScale != -1){
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec((int) (MeasureSpec.getSize(widthMeasureSpec) * mScale), MeasureSpec.getMode(widthMeasureSpec)));

        }else{
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }

   }


}
