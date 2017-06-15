package com.example.siyu2.moneymanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import model.Tb_Losemoney;

public class Detaillose extends AppCompatActivity {

    private List<Tb_Losemoney> LoseList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaillose);
        inintMonet();//初始化money
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.loseList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        LoseAdapter adapter = new LoseAdapter(LoseList);
        recyclerView.setAdapter(adapter);
    }

    private void inintMonet() {
        List<Tb_Losemoney> allget = DataSupport.findAll(Tb_Losemoney.class);
        for (int i = 0;i<allget.size();i++) {
            Tb_Losemoney qian = new Tb_Losemoney(allget.get(i).getType(),allget.get(i).getMoney(),allget.get(i).getTime());
            LoseList.add(qian);
        }
    }
}
