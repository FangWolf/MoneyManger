package com.example.siyu2.moneymanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Detailall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailall);
        Button btndetailget = (Button) findViewById(R.id.btnDetailget);
        Button btndetaillose = (Button) findViewById(R.id.btnDetaillose);
        Button btndetailnote = (Button) findViewById(R.id.btnDetailnote);
        btndetailget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Detailall.this,"暂无",Toast.LENGTH_SHORT).show();
            }
        });
        btndetaillose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Detailall.this,"暂无",Toast.LENGTH_SHORT).show();
            }
        });
        btndetailnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Detailall.this,"暂无",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
