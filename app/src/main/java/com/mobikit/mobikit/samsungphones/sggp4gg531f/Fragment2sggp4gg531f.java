package com.mobikit.mobikit.samsungphones.sggp4gg531f;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mobikit.mobikit.MainActivity;
import com.mobikit.mobikit.R;

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

/**
 * Created by Rishabh on 07-10-2015.
 */
public class Fragment2sggp4gg531f extends Fragment implements onlinestoresfrag2adapter.ClickListener, AdapterView.OnItemSelectedListener,SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView recyclerView;
    private onlinestoresfrag2adapter onlinestoresfrag2adapter1;
    public String[] titls = new String[100];
    public String[] titls1 = new String[100];
    int flag = 0;
    private ProgressBar spinner1;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_2sggp4gg531f, container, false);
        spinner1 = (ProgressBar)layout.findViewById(R.id.progressBarssggp4gg531f);
        new GetAllPhonesTask().execute(new ApiConnector());
        spinner1.setVisibility(View.VISIBLE);
        swipeRefreshLayout = (SwipeRefreshLayout) layout.findViewById(R.id.swipeonlinepricessggp4gg531f);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView = (RecyclerView) layout.findViewById(R.id.onlinepricessggp4gg531f);

        return layout;
    }

    public List<infoonlinestoresfrag2sggp4gg531f> getData()

    {
        List<infoonlinestoresfrag2sggp4gg531f> data = new ArrayList<>();
        int[] icons = {R.drawable.flipkart, R.drawable.snapdeal, R.drawable.paytm, R.drawable.amazonin, R.drawable.ebay};
        String[] titles = {"Flipkart", "Snapdeal", "Paytm", "Amazon", "Ebay"};
        //String[] titles1 = {"Rs 14,400", "Rs 14,400", "Rs 14,400", "Rs 14,400", "Rs 14,400"};
        //String[] titles2 = {"In Stock", "In Stock", "In Stock", "In Stock", "In Stock"};
        for (int i = 0; i < titles.length ; i++) {
            infoonlinestoresfrag2sggp4gg531f current = new infoonlinestoresfrag2sggp4gg531f();
            current.iconID = icons[i];
            current.title = titles[i];
            current.title1 = titls[i];
            current.title2 = titls1[i];
            data.add(current);
        }
        return data;
    }

    @Override
    public void itemClicked(View view, int position) {
        switch (position) {
            case 0:
                //"Flipkart", "Snapdeal", "Paytm", "Amazon", "Ebay"
                String url0 = "http://www.flipkart.com/samsung-galaxy-grand-prime-4g/p/itmeafyygjpyz2qz?pid=MOBEAFYYXMDREHZX&affid=babaprice&affExtParam1=PBFKTX10201708&affExtParam2=1448416756%7Cproduct";
                Intent i0 = new Intent(Intent.ACTION_VIEW);
                i0.setData(Uri.parse(url0));
                startActivity(i0);
                break;
            case 1:
                String url1 = "http://www.snapdeal.com/product/samsung-samsung-grand-prime-4g/643525377572?utm_source=aff_prog&utm_campaign=afts&offer_id=17&aff_id=36626&aff_sub=PBSCTX10201775&aff_sub2=1448416881%7Cproduct";
                Intent i1 = new Intent(Intent.ACTION_VIEW);
                i1.setData(Uri.parse(url1));
                startActivity(i1);
                break;
            case 2:
                String url2 = "https://paytm.com/shop/p/samsung-grand-prime-4g-white-MOBSAMSUNG-GRANTECH774086B2EAA0?utm_source=Affiliates&utm_medium=Payoom&utm_campaign=Payoom";
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse(url2));
                startActivity(i2);
                break;
            case 3:
                String url3 = "http://www.amazon.in/gp/offer-listing/B012NSGMU8//?ie=UTF8&camp=3626&creative=24822&creativeASIN=B012NSGMU8/&linkCode=as2&tag=55879-21&ascsubtag=PBAZTX10201884-1448417151%7Cproduct";
                Intent i3 = new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse(url3));
                startActivity(i3);
                break;
            case 4:
                String url4 = "http://www.ebay.in/itm/SAMSUNG-GALAXY-GRAND-PRIME-4G-/181922271586?aff_source=payoom";
                Intent i4 = new Intent(Intent.ACTION_VIEW);
                i4.setData(Uri.parse(url4));
                startActivity(i4);
                break;
            default:
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();

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

                titls[i] = json.getString("price");
                titls1[i] = json.getString("status");

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
            onlinestoresfrag2adapter1 = new onlinestoresfrag2adapter(getActivity(), getData());
            onlinestoresfrag2adapter1.setClickListener(this);
            recyclerView.setAdapter(onlinestoresfrag2adapter1);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            spinner1.setVisibility(View.GONE);
            // Toast.makeText(this, "data", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "Refreshing...", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getActivity(), "Network Problem...", Toast.LENGTH_SHORT).show();
                spinner1.setVisibility(View.GONE);
                swipeRefreshLayout.setRefreshing(false);
            }
           else{
                setTextToTextView(jsonArray);}

        }
    }

}
class ApiConnector {

    public JSONArray GetAllPhones() {
        // URL for getting all customers


        String url = "http://mobikit.host22.com/onlinepricessggp4gg531f.php";

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
