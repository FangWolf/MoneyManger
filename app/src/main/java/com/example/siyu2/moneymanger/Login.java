package com.example.siyu2.moneymanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.tablemanager.Connector;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText password = (EditText) findViewById(R.id.password);
        Button btnlogin = (Button) findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnquit = (Button) findViewById(R.id.btnQuit);
        btnquit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
