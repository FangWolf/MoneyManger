package DAO;

import org.litepal.crud.DataSupport;

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

}
