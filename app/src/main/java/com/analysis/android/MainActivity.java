package com.analysis.android;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar   != null) {
            //让导航按钮显示出来
            actionBar.setDisplayHomeAsUpEnabled(true);
            //ToolBar最左侧的图标名字是HomeAsUp
            actionBar.setHomeAsUpIndicator(R.mipmap.list_icon);
            //默认含义是返回上一个活动，这里更改了它的默认样式和作用
        }
        /*
        设置默认选中为第一个月
         */
        navView.setCheckedItem(R.id.nav_onemonth);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                /*
                编写相应的点击事件逻辑
                 */
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }




    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //HomeAsUp按钮的ID永远是android.R.id.home
            case android.R.id.home :
                mDrawerLayout.openDrawer(GravityCompat.START);//将滑动菜单展示出来，要求传入Gravity参数，为和XML保持一致所以start
                break;
            default:
        }
        return true;
    }

}
