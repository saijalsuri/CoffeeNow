package com.apps.saijestudio.coffeenow;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import com.cengalabs.flatui.FlatUI;
import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends ActionBarActivity {
    int mNum;
    ViewPager viewPager;
    static List<Fragment> fragments = getFragments();
    MyAdapter myAdapter;
    private Toolbar toolbar;

    private static List<Fragment> getFragments(){
        int i;
        List<Fragment> fragments = new ArrayList<Fragment>();


        //add new fragments here
        fragments.add(ProfileFragment.newInstance());
        fragments.add(HomeFragment.newInstance());
        fragments.add(FeedFragment.newInstance());


        for(i=0; i<fragments.size(); i++) {
            Bundle args = new Bundle();
            args.putInt("num", i);
            fragments.get(i).setArguments(args);
        }
        return fragments;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FlatUI.setDefaultTheme(FlatUI.SAND);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbarCustomize();

        myAdapter = new MyAdapter(getSupportFragmentManager());

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(myAdapter);
        viewPager.setCurrentItem(1);

    }

    public void toolbarCustomize() {

        toolbar.setTitle("CoffeeNow");
    }


    public static class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
