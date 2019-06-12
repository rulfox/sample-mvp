package com.mobotechnology.bipinpandey.retrofit_handdirty;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    private EditText userName, password;
    private Button login;
    private LoginContract.Presenter loginContract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        loginContract = new LoginContractImpl(this, new GetLoginInteractorImpl());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginContract.performLogin(new LoginModel(userName.getText().toString(), password.getText().toString()));
            }
        });
    }

    @Override
    public void onPasswordEmpty() {
        password.setError("Field Empty");
    }

    @Override
    public void onUserEmpty() {
        userName.setError("Field Empty");
    }

    @Override
    public void onLoginFailed(String reason) {
        Toast.makeText(this, "Login Failed : " + reason, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, "Login Success ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginContract.onDestroy();
    }
}
