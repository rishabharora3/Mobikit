package com.mobikit.mobikit.login;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobikit.mobikit.MainActivity;
import com.mobikit.mobikit.R;

public class logIn extends AppCompatActivity  {
    private FrameLayout mRoot;
    private TextInputLayout mUserNameLayout;
    private TextInputLayout mPasswordLayout;
    Toolbar toolbar;
    Button bLogin;
    TextView registerLink;
    EditText etUsername, etPassword;
    private FloatingActionButton mFAB;
    UserLocalStore userLocalStore;
    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Log In");

        mRoot=(FrameLayout)findViewById(R.id.main_content1);
        mUserNameLayout=(TextInputLayout)findViewById(R.id.mUserNameLayout);
        mPasswordLayout=(TextInputLayout)findViewById(R.id.mPasswordLayout);
        bLogin = (Button) findViewById(R.id.bLogin);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        //registerLink = (TextView) findViewById(R.id.tvRegisterLink);

       // bLogin.setOnClickListener(this);
        //registerLink.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
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
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);

        }
        if(id==R.id.addUser1){
            Intent registerIntent = new Intent(logIn.this, register.class);
            registerIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(registerIntent);
        }
        return super.onOptionsItemSelected(item);
    }

 /*   @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bLogin:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                User user = new User(username, password);

                authenticate(user);
                break;

            case R.id.tvRegisterLink:
                Intent registerIntent = new Intent(logIn.this, register.class);
                startActivity(registerIntent);
                break;
        }
    }
*/

    private void authenticate(User user) {
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.fetchUserDataAsyncTask(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                if (returnedUser == null) {
                    showErrorMessage();
                } else {
                    logUserIn(returnedUser);
                }
            }
        });
    }

    private void showErrorMessage() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(logIn.this);
        dialogBuilder.setMessage("Incorrect user details");
        dialogBuilder.setPositiveButton("Ok", null);
        dialogBuilder.show();
    }

    private void logUserIn(User returnedUser) {
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);
        Toast.makeText(this,"Welcome "+ etUsername.getText().toString(),Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, MainActivity.class));
    }
    public void submit(View view) {

        boolean isEmptyUserName = isEmptyUserName();
        boolean isEmptyPassword = isEmptyPassword();
        if (isEmptyUserName && isEmptyPassword) {
            Snackbar.make(mRoot, "One Or More Fields Are Blank", Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.text_dismiss), mSnackBarClickListener)
                    .show();
        } else if (isEmptyUserName && !isEmptyPassword) {
            mUserNameLayout.setError("Username Cannot Be Empty");
            mPasswordLayout.setError(null);
        } else if (!isEmptyUserName && isEmptyPassword) {
            mPasswordLayout.setError("Password Cannot Be Empty");
            mUserNameLayout.setError(null);
        } else {
            if (userLocalStore.getLoggedInUser() != null) {
                Toast.makeText(this, "Please Logout ", Toast.LENGTH_SHORT).show();

            }
            else {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                User user = new User(username, password);

                authenticate(user);
            }
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

}
