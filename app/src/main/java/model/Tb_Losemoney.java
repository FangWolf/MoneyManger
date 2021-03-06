package model;

import org.litepal.crud.DataSupport;

public class Tb_Losemoney extends DataSupport{

    private String money;//金额
    private String time;//时间
    private String type;//类型
    private String flag;//备注

    public Tb_Losemoney () {}

    public Tb_Losemoney (String money, String time, String type, String flag) {
        this.money = money;
        this.time = time;
        this.type = type;
        this.flag = flag;
    }

    public Tb_Losemoney (String money, String time, String type) {
        this.money = money;
        this.time = time;
        this.type = type;
    }


    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
