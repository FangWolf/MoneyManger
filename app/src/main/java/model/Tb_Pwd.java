package model;

import org.litepal.crud.DataSupport;

public class Tb_Pwd extends DataSupport{

    private String password;

    public Tb_Pwd(){}

    public Tb_Pwd(String password) {

        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
