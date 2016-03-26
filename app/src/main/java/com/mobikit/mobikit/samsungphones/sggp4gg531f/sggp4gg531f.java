package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mobikit.mobikit.R;

import org.w3c.dom.Text;

public class sggp4gg531f extends AppCompatActivity {
    TextView t1,t2;
    ViewPager viewPager;
    CustomSwipeAdaptersggp4gg51f adapter;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private Toolbar mToolbar;
    private ViewPager mPager;
    private TabLayout mTabLayout;
    private YourPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sggp4gg531f);
        t1 = (TextView) this.findViewById(R.id.textviewsggp4gg51f);
        t2 = (TextView) this.findViewById(R.id.textview1sggp4gg51f);
        viewPager = (ViewPager) findViewById(R.id.pager_sggp4gg531f);
        adapter = new CustomSwipeAdaptersggp4gg51f(this);
        viewPager.setAdapter(adapter);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.sggp4gg531fcollapsing_toolbar_layout1);
        mToolbar = (Toolbar) findViewById(R.id.sggp4gg531fapp_bar);
        mTabLayout = (TabLayout) findViewById(R.id.sggp4gg531ftab_layout);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAdapter = new YourPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.sggp4gg531fview_pager);
        mPager.setAdapter(mAdapter);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mPager);
        Intent myIntent = getIntent(); // gets the previously created intent
        String fk1 = myIntent.getStringExtra("price");
        String fk2 = myIntent.getStringExtra("name");
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/banksb20.ttf");
        t1.setTypeface(type);
        t2.setTypeface(type);
        t1.setText("  "+fk1);
        t2.setText("  "+fk2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sggp4gg531f, menu);
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


class YourPagerAdapter extends FragmentStatePagerAdapter {

    public YourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = new Fragment1sggp4gg531f();
        }
        if (position == 1) {
            fragment = new Fragment2sggp4gg531f();
        }
        if (position == 2) {
            fragment = new Fragment3sggp4gg531f();
        }
        if (position == 3) {
            fragment = new Fragment4sggp4gg531f();
        }
        if (position == 4) {
            fragment = new Fragment5sggp4gg531f();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String abc = null;


        if (position == 0) {
            abc = "Specifications";
        }

        if (position == 1) {
            abc = "Online Stores";
        }

        if (position == 2) {
            abc = "Offline Stores";
        }
        if (position == 3) {
            abc = "Video Review";
        }
        if (position == 4) {
            abc = "Comments";
        }
        return abc;
    }
}
