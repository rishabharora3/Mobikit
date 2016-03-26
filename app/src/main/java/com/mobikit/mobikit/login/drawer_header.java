package com.mobikit.mobikit.login;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mobikit.mobikit.MainActivity;
import com.mobikit.mobikit.R;

public class drawer_header extends AppCompatActivity  {

   TextView etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_header);
        etName = (TextView) findViewById(R.id.etName1);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/banksb20.ttf");
        this.etName.setTypeface(typeface);
    }

}
