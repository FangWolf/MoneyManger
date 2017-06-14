package com.example.siyu2.moneymanger;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragment.*;

public class Detailall extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailall);
        Button btndetailget = (Button) findViewById(R.id.btnDetailget);
        Button btndetaillose = (Button) findViewById(R.id.btnDetaillose);
        Button btndetailnote = (Button) findViewById(R.id.btnDetailnote);
        replaceFragment(new FragmentDget());
        btndetailget.setOnClickListener(this);
        btndetaillose.setOnClickListener(this);
        btndetailnote.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDetailget:
                replaceFragment(new FragmentDget());
                break;
            case R.id.btnDetaillose:
                replaceFragment(new FragmentDlose());
                break;
            case R.id.btnDetailnote:
                replaceFragment(new FragmentDnote());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction transaction = FM.beginTransaction();
        transaction.replace(R.id.down,fragment);
        transaction.commit();
    }
}
