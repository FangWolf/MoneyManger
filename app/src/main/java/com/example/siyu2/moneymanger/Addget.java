package com.example.siyu2.moneymanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.widget.DatePicker;
import android.widget.Toast;

public class Addget extends AppCompatActivity {

    int mYear, mMonth, mDay;
    ImageButton btndatechoose;
    TextView txtDate;
    final int DATE_DIALOG = 1;

    private Spinner txtType;
    private List<String> data_list;
    private ArrayAdapter<String> arr_adapter;

    EditText txtMoney;
    EditText txtFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addget);
        txtMoney = (EditText) findViewById(R.id.txtMoney);
        txtFlag = (EditText) findViewById(R.id.txtFlag);
        txtType = (Spinner) findViewById(R.id.txtType);
        ImageButton btnsend = (ImageButton) findViewById(R.id.btnSend);
        ImageButton btnrewrite = (ImageButton) findViewById(R.id.btnRewrite);
        btndatechoose = (ImageButton) findViewById(R.id.btnDatechoose);
        txtDate = (TextView) findViewById(R.id.txtDate);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Addget.this,"添加成功",Toast.LENGTH_SHORT).show();
            }
        });

        btnrewrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMoney.setText("");
                txtMoney.setHint("多了多少啊~");
                txtDate.setText("点击后边的按钮选择日期");
                txtFlag.setText("");
                txtType.setSelection(0);
                Toast.makeText(Addget.this,"想清楚了再写",Toast.LENGTH_SHORT).show();
            }
        });

        btndatechoose.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             showDialog(DATE_DIALOG);
          }
        });
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

        txtType = (Spinner) findViewById(R.id.txtType);
        data_list = new ArrayList<String>();
        data_list.add("工资");
        data_list.add("奖金");
        data_list.add("兼职");
        data_list.add("其他");
        arr_adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        txtType.setAdapter(arr_adapter);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    public void display() {
        txtDate.setText(new StringBuffer().append(mYear).append("年").append(mMonth).append("月").append(mDay+ 1).append("日"));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };

}
