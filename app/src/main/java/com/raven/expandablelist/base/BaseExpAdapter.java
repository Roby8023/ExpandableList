package com.raven.expandablelist.base;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

/**
 * BaseAdapter  收放列表的Base
 * Created by Raven on 2018年5月23日21:14:18
 *
 * 用法如下:
 * if (btExp1.getText().equals("展开列表")) {
 * btExp1.setText("合起列表");
 * ravenAdapter.toggleExpand(true);
 * } else {
 * btExp1.setText("展开列表");
 * ravenAdapter.toggleExpand(false);
 * }
 */

public class BaseExpAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
  private ArrayList<T> mList = new ArrayList<>();
  private boolean bToggle = false;
  private int limitCount = 8; //默认限制值

  /** 是否去折叠显示, 优先级最高 */
  public BaseExpAdapter(int layoutID, @Nullable ArrayList<T> data, int limitCount) {
    super(layoutID, data);
    this.limitCount = limitCount;
    mList = data;
  }

  @Override
  protected void convert(BaseViewHolder helper, T item) {
  }

  @Override
  public int getItemCount() {
    super.getItemCount();
    //先判断mList的size是否小于等于limitCount, 如果满足则直接返回size
    if (mList.size() <= limitCount) {
      return super.getItemCount();
    }

    //如果大于8的话
    if (bToggle) {
      return super.getItemCount();
    } else {
      return limitCount;
    }
  }

  /** 切换展开和合起 */
  public void toggleExpand(boolean bToggle) {
    this.bToggle = bToggle;
    notifyDataSetChanged();
  }
}
