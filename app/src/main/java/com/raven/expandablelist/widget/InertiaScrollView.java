package com.raven.expandablelist.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ScrollView;

/**
 * 惯性ScrollView
 * (ScrollView在嵌套了RecyclerView之后滑动会失去惯性)
 * Created by Raven on 2017/6/2 16:05.
 */
public class InertiaScrollView extends ScrollView {
  //private int downX;
  private int downY;
  private int mTouchSlop;

  public InertiaScrollView(Context context) {
    super(context);
    mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
  }

  public InertiaScrollView(Context context, AttributeSet attrs) {
    super(context, attrs);
    mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
  }

  public InertiaScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent e) {
    int action = e.getAction();
    switch (action) {
      case MotionEvent.ACTION_DOWN:
        //downX = (int) e.getRawX();
        downY = (int) e.getRawY();
        break;
      case MotionEvent.ACTION_MOVE:
        int moveY = (int) e.getRawY();
        if (Math.abs(moveY - downY) > mTouchSlop) {
          return true;
        }
    }
    return super.onInterceptTouchEvent(e);
  }
}
