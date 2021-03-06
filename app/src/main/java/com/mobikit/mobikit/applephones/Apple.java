package com.mobikit.mobikit.applephones;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobikit.mobikit.MainActivity;
import com.mobikit.mobikit.Search;
import com.mobikit.mobikit.androidphone.AndroidPhones;
import com.mobikit.mobikit.budgetphone.BudgetPhones;
import com.mobikit.mobikit.credits;
import com.mobikit.mobikit.dualsimphone.DualSimPhones;
import com.mobikit.mobikit.FourGphones;
import com.mobikit.mobikit.HTCphones.HTC;
import com.mobikit.mobikit.login.viewprofile;
import com.mobikit.mobikit.micromaxphones.Micromax;
import com.mobikit.mobikit.R;
import com.mobikit.mobikit.topphone.TopPhones;
import com.mobikit.mobikit.login.logIn;
import com.mobikit.mobikit.samsungphones.Samsung;

import java.util.ArrayList;
import java.util.List;

public class Apple extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,appleAdapter.ClickListener, AdapterView.OnItemSelectedListener {
    private RecyclerView recyclerView;
    private static final String SELECTED_ITEM_ID = "selected_item_id";
    private static final String FIRST_TIME = "first_time";
    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedId;
    private boolean mUserSawDrawer = false;
    private appleAdapter adapter1;
    private static final String TAG = "myApp";
    private Spinner spinner;
    String[] options = {"Popularity", "Price: Low to High", "Price: High to Low"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);
        setTitle("Apple");
        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        mDrawer = (NavigationView) findViewById(R.id.main_drawer1);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout1);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        mSelectedId = savedInstanceState == null ? R.id.drawer_layout1 : savedInstanceState.getInt(SELECTED_ITEM_ID);

        navigate(mSelectedId);

        recyclerView = (RecyclerView) findViewById(R.id.list1);
        recyclerView.setHasFixedSize(true);
        adapter1 = new appleAdapter(this, getData());
        adapter1.setClickListener(this);
        recyclerView.setAdapter(adapter1);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Log.w(TAG, "did something");
    }

    public static List<appleList> getData() {
        List<appleList> data = new ArrayList<>();
        int[] icons = {R.drawable.appleiphone5s, R.drawable.appleiphone4s8gb, R.drawable.appleiphone616gb,R.drawable.appleiphone5c16gb,R.drawable.appleiphone664gb,
                R.drawable.appleiphone6plus128gb,R.drawable.appleiphone6plus16gb,R.drawable.appleiphone6s16gb,R.drawable.appleiphone5c8gb,R.drawable.appleipadminiwifi16gb,R.drawable.appleiphone6plus64gb,
                R.drawable.appleiphone5s64gb,R.drawable.appleiphone5c32gb,R.drawable.appleiphone6splus16gb,R.drawable.appleiphone5s32gb,R.drawable.appleiphone6128gb};
        String[] titles = {"Apple iPhone 5s 16GB", "Apple iPhone 4S 8GB", "Apple iPhone 6 16GB","Apple iPhone 5c 16GB","Apple iPhone 6 64GB","Apple iPhone 6 Plus 128GB","Apple iPhone 6 Plus 16GB",
                "Apple iPhone 6s 16GB","Apple iPhone 5C 8GB","Apple iPad mini WiFi 16GB","Apple iPhone 6 Plus 64GB","Apple iPhone 5s 64GB","Apple iPhone 5c 32GB","Apple iPhone 6s Plus 16GB","Apple iPhone 5s 32GB","Apple iPhone 6 128GB"};
        String[] titles1 = {"Rs. 26,499", "Rs. 12,899", "Rs. 39,499","Rs. 22,000","Rs. 47,499","Rs. 68,000","Rs. 45,999","Rs. 62,000","Rs. 20,355","Rs. 14,899","Rs. 60,000","Rs. 39,999","Rs. 24,990","-","Rs. 37,499","Rs. 52,999"};
        String[] titles2 = {"4 inch | 8 MP | Single SIM", "3.5 inch | 8 MP | Single SIM", "4.7 inch | 8 MP | Single SIM","4 inch | 8 MP | Single SIM","4.7 inch | 8 MP | Single SIM","5.5 inch | 8 MP | Single SIM","5.5 inch | 8 MP | Single SIM","4.7 inch | 12 MP | Single SIM","4 inch | 8 MP | Single SIM",
                "7.9 inch | 5 MP | No SIM","5.5 inch | 8 MP | Single SIM","4 inch | 8 MP | Single SIM","4 inch | 8 MP | Single SIM","5.5 inch | 12 MP | Single SIM","4 inch | 8 MP | Single SIM","4.7 inch | 8 MP | Single SIM"};
        for (int i = 0; i < titles.length && i < icons.length; i++) {
            appleList current = new appleList();
            current.iconId = icons[i];
            current.title = titles[i];
            current.title1 = titles1[i];
            current.title2 = titles2[i];
            data.add(current);
        }
        return data;

    }


    private void navigate(int mSelectedId) {
        Intent intent = null;
        if (mSelectedId == R.id.navigation_item_1) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "Samsung Phones", Toast.LENGTH_SHORT).show();

            intent = new Intent(this, Samsung.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        if (mSelectedId == R.id.navigation_item_2) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "HTC Phones", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, HTC.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        if (mSelectedId == R.id.navigation_item_3) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "Apple Phones", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, Apple.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        if (mSelectedId == R.id.navigation_item_4) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "Micromax Phones", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, Micromax.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        if (mSelectedId == R.id.navigation_item_5) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "Top Phones", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, TopPhones.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        if (mSelectedId == R.id.navigation_item_6) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "Android Phones", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, AndroidPhones.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }

        if (mSelectedId == R.id.navigation_item_8) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "Budget Phones", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, BudgetPhones.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
        if (mSelectedId == R.id.navigation_item_9) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "Dual-Sim Phones", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, DualSimPhones.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_viewprofile) {
            Intent loginIntent = new Intent(this, viewprofile.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(loginIntent);
            return true;
        }
        if (id == R.id.action_credits) {
            Intent loginIntent = new Intent(this, credits.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(loginIntent);
            return true;
        }
        if (id == R.id.addUser) {
            Intent intent=new Intent(this, logIn.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            return true;
        }
        if (id == R.id.search) {
            Intent loginIntent = new Intent(this, Search.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(loginIntent);
            return true;
        }
        if (id == R.id.home) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apple, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        mSelectedId = menuItem.getItemId();

        navigate(mSelectedId);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_ITEM_ID, mSelectedId);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void itemClicked(View view, int position) {
        switch(position){
            case 0: startActivity(new Intent(this, AppleiPhone5s16GB.class));
                break;
            case 1: Toast.makeText(this,"op2",Toast.LENGTH_SHORT).show();
                break;
            case 2:Toast.makeText(this,"op3",Toast.LENGTH_SHORT).show();
                break;
            default:Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
