package com.hafsalrahman.tasky.signin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hafsalrahman.tasky.R;
import com.hafsalrahman.tasky.TaskyApplication;
import com.hafsalrahman.tasky.task.TaskActivity;

import javax.inject.Inject;


public class SignActivity extends AppCompatActivity implements SignInContract.View {


    @Inject
    public SignInPresenter signInPresenter;
    private EditText edtUserName;
    private EditText edtPassword;
    private TextView responseView;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        initializeViews();
        DaggerSignInComponent.builder().netComponent(((TaskyApplication) getApplicationContext()).getNetComponent())
                .signInModule(new SignInModule(this)).build().inject(this);

    }


    private void initializeViews() {

        edtUserName = (EditText) findViewById(R.id.edt_user_name);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        responseView = (TextView) findViewById(R.id.response_view);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInPresenter.signIn(edtUserName.getText().toString().trim(),
                        edtPassword.getText().toString().trim());
            }
        });
    }


    @Override
    public void signInSuccess() {
        openMain();
    }

    private void openMain() {
        Intent intent = new Intent(SignActivity.this, TaskActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void showError(String message) {
        responseView.setText(message);

    }


}
