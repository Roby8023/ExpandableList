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

public class MyAdapter extends BaseExpAdapter {

  public MyAdapter(@Nullable ArrayList<ContentBean> data, int limitCount) {
    super(R.layout.item_list, data, limitCount);
  }

  @Override
  protected void convert(BaseViewHolder helper, Object item) {
    helper.setText(R.id.tv_title, ((ContentBean) item).getTitle())
        .setText(R.id.tv_content, ((ContentBean) item).getContent());
  }
}
