package com.mobikit.mobikit.login;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.mobikit.mobikit.R;

public class register extends AppCompatActivity  {
    Toolbar toolbar;
    EditText etName, etAge, etUsername, etPassword;
    Button bRegister;
    private FrameLayout mRoot;
    private TextInputLayout mNameLayout;
    private TextInputLayout mPassLayout;
    private TextInputLayout mAgeLayout;
    private TextInputLayout mUserLayout;
    private FloatingActionButton mFAB;
    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Register");
        mRoot=(FrameLayout)findViewById(R.id.main_content2);
        mUserLayout=(TextInputLayout)findViewById(R.id.mUserLayout);
        mPassLayout=(TextInputLayout)findViewById(R.id.mPassLayout);
        mAgeLayout=(TextInputLayout)findViewById(R.id.mAgeLayout1);
        mNameLayout=(TextInputLayout)findViewById(R.id.mNameLayout);
        etName = (EditText) findViewById(R.id.etName1);
        etAge = (EditText) findViewById(R.id.etAge1);
        etUsername = (EditText) findViewById(R.id.etUsername1);
        etPassword = (EditText) findViewById(R.id.etPassword1);
        bRegister = (Button) findViewById(R.id.bRegister);

       // bRegister.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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

   /* @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bRegister:

                break;
        }
    }
    */
    private void registerUser(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.storeUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                Intent loginIntent = new Intent(register.this, logIn.class);
                startActivity(loginIntent);
            }
        });
    }

    public void submit1(View view) {

        boolean isEmptyUserName = isEmptyUserName();
        boolean isEmptyPassword = isEmptyPassword();
        boolean isEmptyName = isEmptyName();
        boolean isEmptyAge = isEmptyAge();

        if (isEmptyUserName && isEmptyPassword && isEmptyName && isEmptyAge) {
            Snackbar.make(mRoot, "One Or More Fields Are Blank", Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.text_dismiss), mSnackBarClickListener)
                    .show();
        }
        else if (isEmptyUserName && isEmptyPassword && isEmptyName && !isEmptyAge ) {
            mUserLayout.setError("Username Cannot Be Empty");
            mPassLayout.setError("Password Cannot Be Empty");
            mAgeLayout.setError(null);
            mNameLayout.setError("Name Cannot Be Empty");
        }
        else if (isEmptyUserName && isEmptyPassword && !isEmptyName && isEmptyAge ) {
            mUserLayout.setError("Username Cannot Be Empty");
            mPassLayout.setError("Password Cannot Be Empty");
            mAgeLayout.setError("Age Cannot Be Empty");
            mNameLayout.setError(null);
        }
        else if (isEmptyUserName && !isEmptyPassword && isEmptyName && isEmptyAge ) {
            mUserLayout.setError("Username Cannot Be Empty");
            mPassLayout.setError(null);
            mAgeLayout.setError("Age Cannot Be Empty");
            mNameLayout.setError("Name Cannot Be Empty");
        }

        else if (!isEmptyUserName && isEmptyPassword && isEmptyName && isEmptyAge) {
            mPassLayout.setError("Password Cannot Be Empty");
            mUserLayout.setError(null);
            mAgeLayout.setError("Age Cannot Be Empty");
            mNameLayout.setError("Name Cannot Be Empty");
        }
        else if (isEmptyUserName && isEmptyPassword && !isEmptyName && !isEmptyAge) {
            mPassLayout.setError("Password Cannot Be Empty");
            mUserLayout.setError("Username Cannot Be Empty");
            mAgeLayout.setError(null);
            mNameLayout.setError(null);
        }
        else if (!isEmptyUserName && isEmptyPassword && isEmptyName && !isEmptyAge) {
            mPassLayout.setError("Password Cannot Be Empty");
            mUserLayout.setError(null);
            mAgeLayout.setError(null);
            mNameLayout.setError("Name Cannot Be Empty");
        }
        else if (!isEmptyUserName && !isEmptyPassword && isEmptyName && isEmptyAge) {
            mPassLayout.setError(null);
            mUserLayout.setError(null);
            mAgeLayout.setError("Age Cannot Be Empty");
            mNameLayout.setError("Name Cannot Be Empty");
        }
        else if (isEmptyUserName && !isEmptyPassword && !isEmptyName && isEmptyAge) {
            mPassLayout.setError(null);
            mUserLayout.setError("Username Cannot Be empty");
            mAgeLayout.setError("Age Cannot Be Empty");
            mNameLayout.setError(null);
        }
        else if (isEmptyUserName && !isEmptyPassword && !isEmptyName && !isEmptyAge ) {
            mUserLayout.setError("Username Cannot Be Empty");
            mPassLayout.setError(null);
            mAgeLayout.setError(null);
            mNameLayout.setError(null);
        }
        else if (!isEmptyUserName && !isEmptyPassword && isEmptyName && !isEmptyAge) {
            mNameLayout.setError("Name Cannot Be Empty");
            mUserLayout.setError(null);
            mAgeLayout.setError(null);
            mPassLayout.setError(null);
        }
        else if (!isEmptyUserName && !isEmptyPassword && !isEmptyName && isEmptyAge) {
            mAgeLayout.setError("Age Cannot Be Empty");
            mPassLayout.setError(null);
            mAgeLayout.setError(null);
            mNameLayout.setError(null);
        }
        else if (!isEmptyUserName && isEmptyPassword && !isEmptyName && !isEmptyAge ) {
            mUserLayout.setError(null);
            mPassLayout.setError("Password Cannot Be Empty");
            mAgeLayout.setError(null);
            mNameLayout.setError(null);
        }
        else {
            String name = etName.getText().toString();
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            int age = Integer.parseInt(etAge.getText().toString());

            User user = new User(name, age, username, password);
            registerUser(user);
        }
    }

    private boolean isEmptyUserName() {
        return etUsername.getText() == null
                || etUsername.getText().toString() == null
                || etUsername.getText().toString().isEmpty();

    }

    private boolean isEmptyPassword() {
        return etPassword.getText() == null
                || etPassword.getText().toString() == null
                || etPassword.getText().toString().isEmpty();
    }
    private boolean isEmptyName() {
        return etPassword.getText() == null
                || etName.getText().toString() == null
                || etName.getText().toString().isEmpty();

    }
    private boolean isEmptyAge() {
        return etPassword.getText() == null
                || etAge.getText().toString() == null
                || etAge.getText().toString().isEmpty();


}
}
