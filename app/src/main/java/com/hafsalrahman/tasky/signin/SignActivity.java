package com.hafsalrahman.tasky.signin;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.hafsalrahman.tasky.R;

public class SignActivity extends AppCompatActivity implements SignInView {


    private EditText edtUserName;
    private EditText edtPassword;
    private TextView responseView;
    private Button btnLogin;
    private SignInPresenter signInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign);
        initializePresenter();
        initializeViews();

    }

    private void initializePresenter() {

        signInPresenter = new SignInPresenter(this);

    }

    private void initializeViews() {

        edtUserName = (EditText) findViewById(R.id.edt_user_name);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        responseView=(TextView)findViewById(R.id.response_view);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signInPresenter.doSignIn(edtUserName.getText().toString().trim(),
                        edtPassword.getText().toString().trim());

            }
        });
    }

    @Override
    public void showUsernameError() {

       responseView.setText("Invalid username.");

    }

    @Override
    public void showPasswordError() {

        responseView.setText("Invalid password.");

    }

    @Override
    public void showMaxLoginAttemptError() {

        responseView.setText("Maximum login attempts reached.");

    }

    @Override
    public void showLoginSuccess() {

        responseView.setText("SignIn Success.");

    }

    @Override
    public void showWhenAnyOfInputIsEmpty() {

        responseView.setText("Please enter required credentials.");

    }
}
