package DAO;

import model.Tb_Pwd;

/**
 * Created by siyu2 on 2017/6/14.
 */

public class PwdDAO{

    public void add(Tb_Pwd tb_pwd) {
        //添加密码
        Tb_Pwd tbPwd = new Tb_Pwd();
        tbPwd.setPassword(tb_pwd.getPassword());
        tbPwd.save();
    }

    public void update(Tb_Pwd tb_pwd) {
        //更新密码
        Tb_Pwd tbPwd = new Tb_Pwd();
        tbPwd.setPassword(tb_pwd.getPassword());
        tbPwd.updateAll("id = ?","1");
        tbPwd.save();
    }
}
