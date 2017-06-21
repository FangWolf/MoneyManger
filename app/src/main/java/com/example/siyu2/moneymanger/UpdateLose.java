package com.example.siyu2.moneymanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import DAO.LoseDAO;

public class UpdateLose extends AppCompatActivity {

    EditText jine;
    Spinner leibie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updete_lose);
        jine = (EditText) findViewById(R.id.jine);
        TextView riqi = (TextView) findViewById(R.id.riqi);
        leibie = (Spinner) findViewById(R.id.leibie);
        Button shanchu = (Button) findViewById(R.id.shanchu);

        final Intent intent1 = getIntent();
        final String string1 = intent1.getStringExtra("jine_xinxi");
        jine.setText(string1);
        final Intent intent2 = getIntent();
        final String string2 = intent2.getStringExtra("date_xinxi");
        riqi.setText(string2);
        final Intent intent3 = getIntent();
        final String string3 = intent3.getStringExtra("leibie_xinxi");
        int a = 0;
        switch (string3) {
            case "生活":
                a = 0;
                break;
            case "购物":
                a = 1;
                break;
            case "交费":
                a = 2;
                break;
            case "其他":
                a = 3;
                break;
            default:
                break;
        }
        leibie.setSelection(a);
        shanchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoseDAO loseDAO = new LoseDAO();
                loseDAO.delate(string1,string3);
                Toast.makeText(UpdateLose.this,"删除成功,再次进入刷新",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
