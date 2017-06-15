package com.example.siyu2.moneymanger;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DAO.LoseDAO;
import model.Tb_Losemoney;

public class Addlose extends AppCompatActivity {int mYear, mMonth, mDay;
    ImageButton btndatechoose;
    TextView txtDate;
    final int DATE_DIALOG = 1;
    private Spinner txtType;
    EditText txtMoney;
    EditText txtFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addlose);
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

                LoseDAO loseDAO = new LoseDAO();
                String strMoney = txtMoney.getText().toString();
                Tb_Losemoney tb_losemoney = new Tb_Losemoney(Double.parseDouble(strMoney),txtDate.getText().toString(),txtType.getSelectedItem().toString(),txtFlag.getText().toString());
                loseDAO.add(tb_losemoney);
                Toast.makeText(Addlose.this,"添加成功",Toast.LENGTH_SHORT).show();
                txtMoney.setText("");
                txtMoney.setHint("少了多少呢~");
                txtDate.setText("点击后边的按钮选择日期");
                txtFlag.setText("");
                txtType.setSelection(0);
            }
        });

        btnrewrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMoney.setText("");
                txtMoney.setHint("少了多少呢~");
                txtDate.setText("点击后边的按钮选择日期");
                txtFlag.setText("");
                txtType.setSelection(0);
                Toast.makeText(Addlose.this,"想清楚了再写",Toast.LENGTH_SHORT).show();
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
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };
}
