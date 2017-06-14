package com.example.siyu2.moneymanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Addnote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        final EditText txtnote = (EditText) findViewById(R.id.txtNote);
        ImageButton btnsend = (ImageButton) findViewById(R.id.btnSend);
        ImageButton btnrewrite = (ImageButton) findViewById(R.id.btnRewrite);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Addnote.this,"提交成功",Toast.LENGTH_SHORT).show();
            }
        });
        btnrewrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtnote.setText("");
                Toast.makeText(Addnote.this,"想清楚了再写",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
