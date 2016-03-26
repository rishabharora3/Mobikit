package com.mobikit.mobikit;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobikit.mobikit.HTCphones.HTC;
import com.mobikit.mobikit.androidphone.AndroidPhones;
import com.mobikit.mobikit.applephones.Apple;
import com.mobikit.mobikit.budgetphone.BudgetPhones;
import com.mobikit.mobikit.dualsimphone.DualSimPhones;
import com.mobikit.mobikit.login.UserLocalStore;
import com.mobikit.mobikit.login.logIn;
import com.mobikit.mobikit.login.viewprofile;
import com.mobikit.mobikit.micromaxphones.Micromax;
import com.mobikit.mobikit.samsungphones.Samsung;
import com.mobikit.mobikit.topphone.TopPhones;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String SELECTED_ITEM_ID = "selected_item_id";
    private static final String FIRST_TIME = "first_time";
    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedId = 0;
    private boolean mUserSawDrawer = false;
    UserLocalStore userLocalStore;
    TextView t1, t2, t3, t4, t5, t6, t7;
    TextView t8, t9, t10, t11, t12, t13, t14;
    TextView t15, t16, t17, t18, t19, t20, t21;
    TextView t22, t23, t24, t25, t26, t27, t28;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Mobikit");

        mToolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        mDrawer = (NavigationView) findViewById(R.id.main_drawer);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        mSelectedId = 0;
        mSelectedId = savedInstanceState == null ? R.id.drawer_layout : savedInstanceState.getInt(SELECTED_ITEM_ID);
        navigate(mSelectedId);
        MyPagerAdapter adapter = new MyPagerAdapter();
        ViewPager myPager = (ViewPager)findViewById(R.id.viewpager_layout);
        myPager.setAdapter(adapter);
        myPager.setCurrentItem(2);

        button=(Button)this.findViewById(R.id.threedmodel);
        t1 = (TextView) this.findViewById(R.id.topphones);
        t2 = (TextView) this.findViewById(R.id.topphonesmore);
        t3 = (TextView) this.findViewById(R.id.samsunggalaxyj14ghd);
        t4 = (TextView) this.findViewById(R.id.htcdesire816gdualsimhd);
        t5 = (TextView) this.findViewById(R.id.samsunggalaxye7hd);
        t6 = (TextView) this.findViewById(R.id.sonyxperiam4aquahd);
        t7 = (TextView) this.findViewById(R.id.samsunggalaxygrandprime4ghd);
        t8 = (TextView) this.findViewById(R.id.androidphones);
        t9 = (TextView) this.findViewById(R.id.androidphonesmore);
        t10 = (TextView) this.findViewById(R.id.samsunggalaxyon7hd);
        t11 = (TextView) this.findViewById(R.id.samsunggalaxyj7hd);
        t12 = (TextView) this.findViewById(R.id.samsunggalaxyj14ghd1);
        t13 = (TextView) this.findViewById(R.id.samsunggalaxyj5hd);
        t14 = (TextView) this.findViewById(R.id.htcdesire816gdualsimhd1);
        t15 = (TextView) this.findViewById(R.id.dualsimphones);
        t16 = (TextView) this.findViewById(R.id.dualsimphonesmore);
        t17 = (TextView) this.findViewById(R.id.samsunggalaxyon7hd1);
        t18 = (TextView) this.findViewById(R.id.samsunggalaxyj7hd1);
        t19 = (TextView) this.findViewById(R.id.samsunggalaxyj14ghd2);
        t20 = (TextView) this.findViewById(R.id.samsunggalaxyj5hd1);
        t21 = (TextView) this.findViewById(R.id.htcdesire816gdualsimhd2);
        t22 = (TextView) this.findViewById(R.id.budgetphones);
        t23 = (TextView) this.findViewById(R.id.budgetphonesmore);
        t24 = (TextView) this.findViewById(R.id.samsunggalaxyon5hd);
        t25 = (TextView) this.findViewById(R.id.samsunggalaxyj2hd);
        t26 = (TextView) this.findViewById(R.id.lenovok3notehd);
        t27 = (TextView) this.findViewById(R.id.xiaomiredmi2primehd);
        t28 = (TextView) this.findViewById(R.id.samsunggalaxyj14ghd3);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/LeagueGothic-Regular.otf");
        t1.setText("Top Phones");
        t2.setText("MORE");
        t3.setText("Samsung Galaxy " + "\n" + "        J1 4G");
        t4.setText("HTC Desire 816G " + "\n" + "        Dual Sim");
        t5.setText("Samsung Galaxy E7");
        t6.setText("Sony Xperia " + "\n" + " M4 Aqua Dual");
        t7.setText("Samsung Galaxy " + "\n" + "Grand Prime 4G");
        t8.setText("Android Phones");
        t9.setText("MORE");
        t10.setText("Samsung Galaxy \n        On7");
        t11.setText("Samsung Galaxy j7");
        t12.setText("Samsung Galaxy\n      J14G");
        t13.setText("Samsung Galaxy J5");
        t14.setText("HTC Desire 816G\n  Dual Sim");
        t15.setText("Dual Sim-Phones");
        t16.setText("MORE");
        t17.setText("Samsung Galaxy \n        On7");
        t18.setText("Samsung Galaxy J7");
        t19.setText("Samsung Galaxy \n         J14G");
        t20.setText("Samsung Galaxy J5");
        t21.setText("Htc Desire 816G\n       dual Sim");
        t22.setText("Budget Phones");
        t23.setText("MORE");
        t24.setText("Samsung Galaxy \n        J1 4G");
        t25.setText("Samsung Galaxy On5");
        t26.setText("Samsung Galaxy J2");
        t27.setText("Lenovo K3 \n   Note");
        t28.setText("Xiaomi Redmi \n   2 Prime");



        this.t1.setTypeface(typeface);
        this.t2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/RobotoSlab-Light.ttf"));
        this.t8.setTypeface(typeface);
        this.t9.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/RobotoSlab-Light.ttf"));
        this.t15.setTypeface(typeface);
        this.t16.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/RobotoSlab-Light.ttf"));
        this.t22.setTypeface(typeface);
        this.t23.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/RobotoSlab-Light.ttf"));
        this.t3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t4.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t5.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t6.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t7.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t10.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t11.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t12.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t13.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t14.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t17.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t18.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t19.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t20.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t21.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t10.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t10.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t24.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t25.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t26.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t27.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));
        this.t28.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/KaushanScript-Regular.otf"));

t2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, TopPhones.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
});
   t9.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent = new Intent(MainActivity.this, AndroidPhones.class);
           intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
           startActivity(intent);
       }
   });
        t16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DualSimPhones.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        t23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BudgetPhones.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openApp(getBaseContext(), "exam.lenovopc.cube");
            }
        });
    }

    public static boolean openApp(Context context, String packageName) {
        PackageManager manager = context.getPackageManager();
        try {
            Intent i = manager.getLaunchIntentForPackage(packageName);
            if (i == null) {
                return false;
                //throw new PackageManager.NameNotFoundException();
            }
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(i);
            return true;
        }
        catch (Exception e) {
            return false;
        }
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
            startActivity(loginIntent);
            return true;
        }
        if (id == R.id.action_credits) {
            Intent loginIntent = new Intent(this, credits.class);
            startActivity(loginIntent);
            return true;
        }
        if (id == R.id.addUser) {
            startActivity(new Intent(this, logIn.class));
            return true;
        }
        if (id == R.id.search) {
            Intent loginIntent = new Intent(this, Search.class);
            startActivity(loginIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
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
    public void onDestroy() {
        super.onDestroy();
        System.runFinalization();
        android.os.Process.killProcess(android.os.Process.myPid());
    }


}


