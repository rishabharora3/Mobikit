package com.mobikit.mobikit;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    Toolbar toolbar;
    Animation animation;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        toolbar = (Toolbar) findViewById(R.id.app_bar4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Credits");
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.credits);
        t1 = (TextView) this.findViewById(R.id.creditstextView);
        t1.setText("               CREDITS:\n\n" + "Rishabh Arora - 9913103468\n\n" + "Utkarsh Gupta - 9913103596\n\n" + "Sudhish Semwal - 9913103407\n\n" + "Faiz Lari - 9913103407\n\n\n\n\n\n\n"+"        SUBMITTED TO:\n\n"+"    Dr. Devpriya Soni\n\n"+"      &\n\n"+"    Mrs. Anubhuti\n\n\n\n\n\n\n\n\n"+"THANK YOU FOR USING OUR APP \n             :)\n\n");
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/banksb20.ttf");
        this.t1.setTypeface(typeface);
        t1.startAnimation(animation);
    }


}
