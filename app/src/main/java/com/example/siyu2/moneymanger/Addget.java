package com.example.siyu2.moneymanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.widget.DatePicker;
import android.widget.Toast;

import DAO.GetDAO;
import model.Tb_Getmoeny;

public class Addget extends AppCompatActivity {

    int mYear, mMonth, mDay;
    ImageButton btndatechoose;
    TextView txtDate;
    final int DATE_DIALOG = 1;
    private Spinner txtType;
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
                GetDAO getDAO = new GetDAO();
                Tb_Getmoeny tb_getmoeny = new Tb_Getmoeny(txtMoney.getText().toString(),txtDate.getText().toString(),txtType.getSelectedItem().toString(),txtFlag.getText().toString());
                getDAO.add(tb_getmoeny);
                Toast.makeText(Addget.this,"添加成功",Toast.LENGTH_SHORT).show();
                txtMoney.setText("");
                txtMoney.setHint("多了多少啊~");
                txtDate.setText("点击后边的按钮选择日期");
                txtFlag.setText("");
                txtType.setSelection(0);
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

    }


    //↓日期
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    public void display() {
        txtDate.setText(new StringBuffer().append(mYear).append(".").append(mMonth).append(".").append(mDay+ 1).append(""));
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
