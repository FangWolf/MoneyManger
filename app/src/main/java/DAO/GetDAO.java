package DAO;

import org.litepal.crud.DataSupport;

import java.util.List;

import model.Tb_Getmoeny;

public class GetDAO extends DataSupport {

    public void add(Tb_Getmoeny tb_getmoeny) {
        Tb_Getmoeny tbGetmoeny = new Tb_Getmoeny();
        tbGetmoeny.setMoney(tb_getmoeny.getMoney());
        tbGetmoeny.setTime(tb_getmoeny.getTime());
        tbGetmoeny.setType(tb_getmoeny.getType());
        tbGetmoeny.setFlag(tb_getmoeny.getFlag());
        tbGetmoeny.save();
    }

    public float gongzi() {
        float f = 0 ;
        String s = "0";
        List<Tb_Getmoeny> all = DataSupport
                .select("money")
                .where("type = ?","工资")
                .find(Tb_Getmoeny.class);
        for (int i=0;i<all.size();i++) {
            s = all.get(i).getMoney();
            float ff = Float.parseFloat(s);
            f+=ff;
        }
        return f;
    }

    public float jianzhi() {
        float f = 0 ;
        String s = "0";
        List<Tb_Getmoeny> all = DataSupport
                .select("money")
                .where("type = ?","奖金")
                .find(Tb_Getmoeny.class);
        for (int i=0;i<all.size();i++) {
            s = all.get(i).getMoney();
            float ff = Float.parseFloat(s);
            f+=ff;
        }
        return f;
    }

    public float jiangjin() {
        float f = 0 ;
        String s = "0";
        List<Tb_Getmoeny> all = DataSupport
                .select("money")
                .where("type = ?","兼职")
                .find(Tb_Getmoeny.class);
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
        List<Tb_Getmoeny> all = DataSupport
                .select("money")
                .where("type = ?","其他")
                .find(Tb_Getmoeny.class);
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
        float a = gongzi();
        float b = jianzhi();
        float c = jiangjin();
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
