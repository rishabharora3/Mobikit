package com.mobikit.mobikit.samsungphones;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobikit.mobikit.MainActivity;
import com.mobikit.mobikit.Search;
import com.mobikit.mobikit.androidphone.AndroidPhones;
import com.mobikit.mobikit.applephones.Apple;
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
import com.mobikit.mobikit.samsungphones.sggp4gg531f.sggp4gg531f;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Samsung extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, com.mobikit.mobikit.samsungphones.adapter.ClickListener, AdapterView.OnItemSelectedListener, SwipeRefreshLayout.OnRefreshListener {


    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private com.mobikit.mobikit.samsungphones.adapter adapter;
    private static final String SELECTED_ITEM_ID = "selected_item_id";
    private static final String FIRST_TIME = "first_time";
    private Toolbar mToolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private int mSelectedId;
    private boolean mUserSawDrawer = false;
    private Spinner spinner;
    String[] options = {"Popularity", "Price: Low to High", "Price: High to Low"};
    public String[] titls = new String[100];
    public String[] titls1 = new String[100];
    public String[] titls2 = new String[100];
    int flag = 0;
    public int[] icons1 = {R.drawable.sggprime4g, R.drawable.sge7, R.drawable.sgj14g, R.drawable.sgj7, R.drawable.sgj5, R.drawable.sgcp4g, R.drawable.sggrand2};
    private ProgressBar spinner1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsung);
        setTitle("Samsung");

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
        mSelectedId = savedInstanceState == null ? R.id.drawer_layout : savedInstanceState.getInt(SELECTED_ITEM_ID);
        navigate(mSelectedId);
        spinner1 = (ProgressBar) findViewById(R.id.progressBarsamlist1);
        new GetAllPhonesTask().execute(new ApiConnector());
        spinner1.setVisibility(View.VISIBLE);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipesamlist);
        swipeRefreshLayout.setOnRefreshListener(this);
    }

    public List<samsungList> getData() {


        List<samsungList> data = new ArrayList<>();

        //int[] icons = new int[4];
        //String[] titles = {"Samsung Galaxy Grand Prime 4G ", "Samsung Galaxy E7", "Samsung Galaxy J1 4G", "Samsung Galaxy J7", "Samsung Galaxy J5", "Samsung Galaxy Core Prime 4G", "Samsung Galaxy Grand 2 SM-G7102","","","","","","","","","",""};
        //String[] titles1={"Rs. 9,499","Rs. 14,700","Rs. 6,400","Rs. 14,400","Rs. 11,900","Rs. 7,700","Rs. 10,800"};
        //String[] titles2={"5 inch | 8 MP | Dual Sim","5.5 inch | 13 MP | Dual Sim","4.3 inch | 5 MP | Dual Sim","5.5 inch | 13 MP | Dual Sim","5 inch | 13 MP | Dual Sim","4.5 inch | 5 MP | Dual Sim","5.25 inch | 8 MP | Dual Sim"};
        //for (int i = 0; i < titles.length && i < icons.length; i++) {
        int count = 0;
        if (flag == 1) {
            for (int j = 0; j < titls.length; j++) {
                if (titls[j] != null) {
                    ++count;
                }
            }
            for (int i = 0; i < count; i++) {
                samsungList current = new samsungList();
                current.iconId = icons1[i];
                current.title = titls[i];
                current.title1 = titls1[i];
                current.title2 = titls2[i];
                data.add(current);
            }
        } else {

            Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
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
        getMenuInflater().inflate(R.menu.menu_samsung, menu);
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
        switch (position) {
            case 0:
                String price1 = titls1[0];
                String name1 = titls[0];
                Intent i0 = new Intent(this, sggp4gg531f.class);
                i0.putExtra("price", price1);
                i0.putExtra("name", name1);
                i0.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i0);
                break;
            case 1:
                Toast.makeText(this, "op2", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(this, "op3", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void setTextToTextView(JSONArray jsonArray) {

        // Toast.makeText(this, "Post working", Toast.LENGTH_SHORT).show();
        String s = "";
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject json = null;
            try {
                json = jsonArray.getJSONObject(i);

                titls[i] = json.getString("samname");
                titls1[i] = json.getString("samprice");
                titls2[i] = json.getString("samdetails");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        flag = 1;
        if (flag == 1) {
            if (swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(false);

            }

            recyclerView = (RecyclerView) findViewById(R.id.list);
            recyclerView.setHasFixedSize(true);
            adapter = new adapter(this, getData());
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
            final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            spinner1.setVisibility(View.GONE);
            // Toast.makeText(this, "data", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRefresh() {
        Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
        new GetAllPhonesTask().execute(new ApiConnector());
        spinner1.setVisibility(View.VISIBLE);
    }


    class GetAllPhonesTask extends AsyncTask<ApiConnector, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread

            return params[0].GetAllPhones();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            if(jsonArray==null){
                Toast.makeText(getBaseContext(), "Network Problem...", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
                spinner1.setVisibility(View.GONE);
            }
            else {
            setTextToTextView(jsonArray);}

        }
    }


}

class ApiConnector {

    public JSONArray GetAllPhones() {
        // URL for getting all customers


        String url = "http://mobikit.host22.com/SamsungListFetch.php";

        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            HttpGet httpGet = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();


        } catch (ClientProtocolException e) {

            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here


        } catch (IOException e) {
            e.printStackTrace();
        }


        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                Log.e("Entity Response  : ", entityResponse);

                jsonArray = new JSONArray(entityResponse);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;


    }


}
