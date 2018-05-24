package com.raven.expandablelist.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class NoScrollRecyclerView extends RecyclerView {
  public NoScrollRecyclerView(Context context) {
    super(context);
  }

  public NoScrollRecyclerView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
    super.onMeasure(widthMeasureSpec, expandSpec);
  }
}
