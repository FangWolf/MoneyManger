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

    public void find() {
        //查询数据
        List<Tb_Getmoeny> allget = DataSupport.findAll(Tb_Getmoeny.class);
        for (int i = 0;i<allget.size();i++)
        {

            /*Log.d("Detailget",allget.get(i).getFlag());*/
        }
        /*return allget.get(1);*/
    }

}
