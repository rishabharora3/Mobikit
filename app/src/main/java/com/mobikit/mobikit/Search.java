package com.mobikit.mobikit;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search extends AppCompatActivity implements searchadapter.ClickListener, AdapterView.OnItemSelectedListener, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {
    RequestQueue requestQueue;
    //String insertUrl = "http://mobikit.host22.com/commentsputsggp4gg531f.php";

    String deleteUrl = "http://mobikit.host22.com/deleterowsearch.php";
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    Toolbar toolbar;
    public String[] titls = new String[100];
    public String[] titls1 = new String[100];
    public String[] titls2 = new String[100];
    int flag = 0;
    searchadapter searchadapter;
    public int[] icons1 = {R.drawable.sggprime4g, R.drawable.sge7, R.drawable.sgj14g, R.drawable.sgj7, R.drawable.sgj5, R.drawable.sgcp4g, R.drawable.sggrand2};
    private ProgressBar spinner1;
    ImageView i1;
    EditText e1;
    Button b1;
    String value = "samsung";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        toolbar = (Toolbar) findViewById(R.id.app_bar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");
        spinner1 = (ProgressBar) findViewById(R.id.progressBarsearch);
        new GetAllPhonesTask().execute(new ApiConnector());
        spinner1.setVisibility(View.VISIBLE);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipesearch);
        swipeRefreshLayout.setOnRefreshListener(this);
        i1 = (ImageView) this.findViewById(R.id.imagesearch);
        e1 = (EditText) this.findViewById(R.id.searcheditText);
        b1 = (Button) this.findViewById(R.id.buttonsearch);
        i1.setOnClickListener(this);
        requestQueue = Volley.newRequestQueue(getApplicationContext());


        e1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });
        b1.setOnClickListener(this);
    }

    public List<rowsearchinfo> getData() {


        List<rowsearchinfo> data = new ArrayList<>();

        int count = 0;
        if (flag == 1) {
            for (int j = 0; j < titls.length; j++) {
                if (titls[j] != null) {
                    ++count;
                }
            }
            for (int i = 0; i < count; i++) {
                rowsearchinfo current = new rowsearchinfo();
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onRefresh() {
        Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
        new GetAllPhonesTask().execute(new ApiConnector());
        spinner1.setVisibility(View.VISIBLE);
    }

    @Override
    public void itemClicked(View view, int position) {
        switch (position) {
            case 0:
                Intent i0 = new Intent(this, sggp4gg531f.class);
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

    public void setTextToTextView(JSONArray jsonArray) {

        // Toast.makeText(this, "Post working", Toast.LENGTH_SHORT).show();
        String s = "";
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject json = null;
            try {
                json = jsonArray.getJSONObject(i);

                titls[i] = json.getString("name");
                titls1[i] = json.getString("price");
                titls2[i] = json.getString("details");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        flag = 1;
        if (flag == 1) {
            if (swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(false);

            }

            recyclerView = (RecyclerView) findViewById(R.id.listsearch);
            recyclerView.setHasFixedSize(true);
            searchadapter = new searchadapter(this, getData());
            searchadapter.setClickListener(this);
            recyclerView.setAdapter(searchadapter);
            final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            spinner1.setVisibility(View.GONE);
            // Toast.makeText(this, "data", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imagesearch) {
            e1.setText("");
        }
        if (view.getId() == R.id.buttonsearch) {
            StringRequest request = new StringRequest(Request.Method.POST, deleteUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println(response.toString());

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> parameters=new HashMap<String,String>();
                    parameters.put("name","samsung");
                    return parameters;
                }
            };
            requestQueue.add(request);
        }

    }

    void performSearch() {
        Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
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


        String url = "http://mobikit.host22.com/SearchPhonesList.php";

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
