package com.mobikit.mobikit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class NoConnection extends AppCompatActivity {
ImageView i1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_connection);

    i1=(ImageView)findViewById(R.id.noconnection);
    b1=(Button)findViewById(R.id.buttonnoconnect);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NoConnection.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }

}
