package com.raven.expandablelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.raven.expandablelist.adapter.MyAdapter;
import com.raven.expandablelist.adapter.MyGridAdapter;
import com.raven.expandablelist.bean.ContentBean;
import java.util.ArrayList;

/**
 * Main Page
 * Created by Raven on 2018年5月23日21:25:52
 */
public class MainActivity extends AppCompatActivity {
  private RecyclerView rvMainGrid, rvMainList;
  private MyAdapter myAdapter;
  private MyGridAdapter myGridAdapter;
  private ArrayList<ContentBean> mList = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
  }

  private void initView() {
    rvMainGrid = findViewById(R.id.rv_main_grid);
    rvMainList = findViewById(R.id.rv_main_list);
    findViewById(R.id.tv_check_all_grid).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //init check all event
        if (((TextView) view).getText().equals(getString(R.string.check_all))) {
          ((TextView) view).setText(getString(R.string.back));
          myGridAdapter.toggleExpand(true);
        } else {
          ((TextView) view).setText(getString(R.string.check_all));
          myGridAdapter.toggleExpand(false);
        }
      }
    });
    findViewById(R.id.tv_check_all).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //init check all event
        if (((TextView) view).getText().equals(getString(R.string.check_all))) {
          ((TextView) view).setText(getString(R.string.back));
          myAdapter.toggleExpand(true);
        } else {
          ((TextView) view).setText(getString(R.string.check_all));
          myAdapter.toggleExpand(false);
        }
      }
    });
    rvMainGrid.setLayoutManager(new GridLayoutManager(this, 3));
    rvMainList.setLayoutManager(new LinearLayoutManager(this));
    rvMainList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    myGridAdapter = new MyGridAdapter(mList, 6); //two lines
    myAdapter = new MyAdapter(mList, 8);
    myGridAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(MainActivity.this, "Grid position: " + position + " (*^▽^*)",
            Toast.LENGTH_SHORT).show();
      }
    });
    myAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
      @Override
      public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Toast.makeText(MainActivity.this, "List position: " + position + " O(∩_∩)O",
            Toast.LENGTH_SHORT).show();
      }
    });

    rvMainGrid.setAdapter(myGridAdapter);
    rvMainList.setAdapter(myAdapter);
    //init test data
    initData();
  }

  private void initData() {
    for (int i = 0; i < 21; i++) {
      mList.add(new ContentBean("Paradise_" + i, "Lemon_" + i));
    }
    myAdapter.setNewData(mList);
    myGridAdapter.setNewData(mList);
  }
}
