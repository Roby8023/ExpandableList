package com.raven.expandablelist.adapter;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseViewHolder;
import com.raven.expandablelist.R;
import com.raven.expandablelist.base.BaseExpAdapter;
import com.raven.expandablelist.bean.ContentBean;
import java.util.ArrayList;

/**
 * Adapter
 * Created by Raven on 2018年5月23日21:21:43
 */

public class MyGridAdapter extends BaseExpAdapter {

  public MyGridAdapter(@Nullable ArrayList<ContentBean> data, int limitCount) {
    super(R.layout.item_grid_list, data, limitCount);
  }

  @Override
  protected void convert(BaseViewHolder helper, Object item) {
    helper.setText(R.id.tv_grid_content, ((ContentBean) item).getContent());
  }
}
