package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mobikit.mobikit.R;
import com.mobikit.mobikit.login.User;
import com.mobikit.mobikit.login.UserLocalStore;

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

/**
 * Created by Rishabh on 07-10-2015.
 */
public class Fragment5sggp4gg531f extends Fragment implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {
    RequestQueue requestQueue;
    String insertUrl = "http://mobikit.host22.com/commentsputsggp4gg531f.php";

    String deleteUrl = "http://mobikit.host22.com/deletecommentsggp4gg531f.php";
    private RecyclerView recyclerView;
    private frag5adaptersggp4gg531f frag5adaptersggp4gg531f;
    EditText e1;
    Button b1,b2;
    public String[] titls = new String[100];
    public String[] titls1 = new String[100];
    int flag = 0;
    private ProgressBar spinner1;
    private SwipeRefreshLayout swipeRefreshLayout;
    UserLocalStore userLocalStore;
    int count;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_5sggp4gg531f, container, false);
        spinner1 = (ProgressBar) layout.findViewById(R.id.progressBarssggp4gg531ffrag5);
        spinner1.setVisibility(View.VISIBLE);
        swipeRefreshLayout = (SwipeRefreshLayout) layout.findViewById(R.id.swipesggp4gg531ffrag5);
        swipeRefreshLayout.setOnRefreshListener(this);
        new GetAllPhonesTask().execute(new ApiConnectors());
        recyclerView = (RecyclerView) layout.findViewById(R.id.sggp4gg531ffrag5);
        b1 = (Button) layout.findViewById(R.id.buttonfrag5sggp4gg531f);
        b2 = (Button) layout.findViewById(R.id.button1frag5sggp4gg531f);
        e1 = (EditText) layout.findViewById(R.id.editTextfrag5sggp4gg531f);
        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        userLocalStore = new UserLocalStore(getActivity());
        return layout;
    }

    public List<rowinfofrag5sggp4gg531f> getData() {
        count = 0;
        List<rowinfofrag5sggp4gg531f> data = new ArrayList<>();
       int[] icons={R.drawable.boy};
        for (int j = 0; j < titls1.length; j++) {
            if (titls1[j] != null) {
                ++count;
            }
        }
        for (int i = 0; i < count; i++) {
            rowinfofrag5sggp4gg531f current = new rowinfofrag5sggp4gg531f();
            current.iconID = icons[0];
            current.title = titls[i];
            current.title1 = titls1[i];
            data.add(current);
        }
        return data;
    }

    public void setTextToTextView(JSONArray jsonArray) {

        // Toast.makeText(this, "Post working", Toast.LENGTH_SHORT).show();
        String s = "";
        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject json = null;
            try {
                json = jsonArray.getJSONObject(i);

                titls[i] = json.getString("name");
                titls1[i] = json.getString("comment");


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        flag = 1;
        if (flag == 1) {
            if (swipeRefreshLayout.isRefreshing()) {
                swipeRefreshLayout.setRefreshing(false);

            }

            recyclerView.setHasFixedSize(true);
            frag5adaptersggp4gg531f = new frag5adaptersggp4gg531f(getActivity(), getData());
            recyclerView.setAdapter(frag5adaptersggp4gg531f);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            spinner1.setVisibility(View.GONE);
            // Toast.makeText(this, "data", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "Refreshing...", Toast.LENGTH_SHORT).show();
        new GetAllPhonesTask().execute(new ApiConnectors());
        spinner1.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == R.id.buttonfrag5sggp4gg531f){

        if (userLocalStore.getLoggedInUser() == null) {
            Toast.makeText(getActivity(), "Please LogIn To Comment", Toast.LENGTH_SHORT).show();

        } else {
                User user = userLocalStore.getLoggedInUser();
                final String name1 = user.name;
            StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> parameters = new HashMap<String, String>();
                    parameters.put("name",name1);
                    parameters.put("comment", e1.getText().toString());
                    return parameters;
                }
            };
            requestQueue.add(request);
            Toast.makeText(getActivity(),"Swipe down to Refresh",Toast.LENGTH_SHORT).show();
        }
        }
        if(view.getId() == R.id.button1frag5sggp4gg531f){

            if (userLocalStore.getLoggedInUser() == null) {
                Toast.makeText(getActivity(), "Please LogIn To Delete Comment", Toast.LENGTH_SHORT).show();

            } else {
                User user = userLocalStore.getLoggedInUser();
                final String name1 = user.name;
                StringRequest request = new StringRequest(Request.Method.POST, deleteUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("name",name1);
                        return parameters;
                    }
                };
                requestQueue.add(request);
                Toast.makeText(getActivity(),"Deleted",Toast.LENGTH_SHORT).show();
            }

        }
    }

    class GetAllPhonesTask extends AsyncTask<ApiConnectors, Long, JSONArray> {
        @Override
        protected JSONArray doInBackground(ApiConnectors... params) {

            // it is executed on Background thread

            return params[0].GetAllPhones();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            if(jsonArray==null){
                Toast.makeText(getActivity(), "Network Problem...", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
                spinner1.setVisibility(View.GONE);
            }
            else {
                setTextToTextView(jsonArray);
            }
        }
    }


}

class ApiConnectors {

    public JSONArray GetAllPhones() {
        // URL for getting all customers


        String url = "http://mobikit.host22.com/commentsfetchsggp4gg531f.php";

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

