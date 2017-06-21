package DAO;

import android.util.Log;

import org.litepal.crud.DataSupport;

import model.Tb_Pwd;

public class PwdDAO{

    public void add() {
        Tb_Pwd tbPwd = new Tb_Pwd();
        tbPwd.setPassword("123");
        tbPwd.save();
    }

    public void alter(Tb_Pwd tb_pwd) {
        Tb_Pwd tbPwd = new Tb_Pwd();
        tbPwd.setPassword(tb_pwd.getPassword());
        tbPwd.update(1);
    }

    public Tb_Pwd find() {
        Tb_Pwd firstmm = DataSupport.find(Tb_Pwd.class,1);
        Log.d("Login",firstmm.getPassword());
        return firstmm;
    }
}
