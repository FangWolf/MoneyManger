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

}
