package com.example.siyu2.moneymanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import DAO.PwdDAO;
import model.Tb_Pwd;

public class Setting extends AppCompatActivity {

    EditText txtpwd ;
    Button btnokpwd ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        txtpwd = (EditText) findViewById(R.id.txtPwd);
        btnokpwd = (Button) findViewById(R.id.btnOkpwd);
        btnokpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PwdDAO pwdDAO = new PwdDAO();
                Tb_Pwd tb_pwd = new Tb_Pwd(txtpwd.getText().toString());
                pwdDAO.alter(tb_pwd);// 修改用户密码
            }
        });
    }
}
