package com.example.siyu2.moneymanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton addget;
    private ImageButton addlose;
    private ImageButton addnote;
    private ImageButton detailget;
    private ImageButton detaillose;
    private ImageButton detailall;
    private ImageButton setting;
    private ImageButton help;
    private ImageButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addget = (ImageButton) findViewById(R.id.AddGet);
        addget.setOnClickListener(this);
        addlose = (ImageButton)findViewById(R.id.AddLose);
        addlose.setOnClickListener(this);
        addnote = (ImageButton) findViewById(R.id.AddNote);
        addnote.setOnClickListener(this);
        detailget = (ImageButton) findViewById(R.id.DetailGet);
        detailget.setOnClickListener(this);
        detaillose = (ImageButton) findViewById(R.id.DetailLose);
        detaillose.setOnClickListener(this);
        detailall = (ImageButton) findViewById(R.id.DetailAll);
        detailall.setOnClickListener(this);
        setting = (ImageButton) findViewById(R.id.Setting);
        setting.setOnClickListener(this);
        help = (ImageButton) findViewById(R.id.Help);
        help.setOnClickListener(this);
        logout = (ImageButton) findViewById(R.id.Logout);
        logout.setOnClickListener(this);
    }
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.AddGet:
                intent = new Intent(MainActivity.this,Addget.class);
                startActivity(intent);
                break;
            case R.id.AddLose:
                intent = new Intent(MainActivity.this,Addlose.class);
                startActivity(intent);
                break;
            case R.id.AddNote:
                intent = new Intent(MainActivity.this,Addnote.class);
                startActivity(intent);
                break;
            case R.id.DetailGet:
                intent = new Intent(MainActivity.this,Detailget.class);
                startActivity(intent);
                break;
            case R.id.DetailLose:
                intent = new Intent(MainActivity.this,Detaillose.class);
                startActivity(intent);
                break;
            case R.id.DetailAll:
                intent = new Intent(MainActivity.this,Detailall.class);
                startActivity(intent);
                break;
            case R.id.Setting:
                intent = new Intent(MainActivity.this,Setting.class);
                startActivity(intent);
                break;
            case R.id.Help:
                intent = new Intent(MainActivity.this,About.class);
                startActivity(intent);
                break;
            case R.id.Logout:
                finish();
                break;
            default:
                break;
        }
    }
}