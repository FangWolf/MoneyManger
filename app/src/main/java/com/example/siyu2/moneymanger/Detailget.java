package com.example.siyu2.moneymanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import DAO.GetDAO;
import model.Tb_Getmoeny;

public class Detailget extends AppCompatActivity {

    private List<Tb_Getmoeny> GetList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailget);
        inintMonet();//初始化money
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.getList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        GetAdapter adapter = new GetAdapter(GetList);
        recyclerView.setAdapter(adapter);
    }

    private void inintMonet () {
        List<Tb_Getmoeny> allget = DataSupport.findAll(Tb_Getmoeny.class);
        for (int i = 0;i<allget.size();i++) {
            Tb_Getmoeny qian = new Tb_Getmoeny(allget.get(i).getType(),allget.get(i).getMoney(),allget.get(i).getTime());
            GetList.add(qian);
        }
    }
}
