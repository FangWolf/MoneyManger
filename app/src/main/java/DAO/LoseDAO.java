package DAO;

import org.litepal.crud.DataSupport;

import java.util.List;

import model.Tb_Losemoney;

public class LoseDAO extends DataSupport {

    public void add(Tb_Losemoney tb_losemoney){
        Tb_Losemoney tbLosemoney = new Tb_Losemoney();
        tbLosemoney.setMoney(tb_losemoney.getMoney());
        tbLosemoney.setTime(tb_losemoney.getTime());
        tbLosemoney.setType(tb_losemoney.getType());
        tbLosemoney.setFlag(tb_losemoney.getFlag());
        tbLosemoney.save();
    }

    public void delate (String s,String ss) {
        deleteAll(Tb_Losemoney.class,"money = ? and type = ?",s,ss);
    }
    public float shenghuo() {
        float f = 0 ;
        String s = "0";
        List<Tb_Losemoney> all = DataSupport
                .select("money")
                .where("type = ?","生活")
                .find(Tb_Losemoney.class);
        for (int i=0;i<all.size();i++) {
            s = all.get(i).getMoney();
            float ff = Float.parseFloat(s);
            f+=ff;
        }
        return f;
    }

    public float gouwu() {
        float f = 0 ;
        String s = "0";
        List<Tb_Losemoney> all = DataSupport
                .select("money")
                .where("type = ?","购物")
                .find(Tb_Losemoney.class);
        for (int i=0;i<all.size();i++) {
            s = all.get(i).getMoney();
            float ff = Float.parseFloat(s);
            f+=ff;
        }
        return f;
    }

    public float jiaofei() {
        float f = 0 ;
        String s = "0";
        List<Tb_Losemoney> all = DataSupport
                .select("money")
                .where("type = ?","交费")
                .find(Tb_Losemoney.class);
        for (int i=0;i<all.size();i++) {
            s = all.get(i).getMoney();
            float ff = Float.parseFloat(s);
            f+=ff;
        }
        return f;
    }

    public float qita() {
        float f = 0 ;
        String s = "0";
        List<Tb_Losemoney> all = DataSupport
                .select("money")
                .where("type = ?","其他")
                .find(Tb_Losemoney.class);
        for (int i=0;i<all.size();i++) {
            s = all.get(i).getMoney();
            float ff = Float.parseFloat(s);
            f+=ff;
        }
        return f;
    }

    public int max () {
        int sum = 0;
        float x= 0,y=0;
        float a = shenghuo();
        float b = gouwu();
        float c = jiaofei();
        float d = qita();
        if (a>b) {
            x=a;
        } else {
            x=b;
        }
        if (c>d) {
            y=c;
        } else {
            y=d;
        }
        if (x>y) {
            sum = (int)x;
        } else {
            sum = (int)y;
        }
        return sum;
    }
}
