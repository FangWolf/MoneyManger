package com.example.siyu2.moneymanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.litepal.crud.DataSupport;

import java.util.List;

import DAO.GetDAO;
import model.Tb_Getmoeny;

public class Detailget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailget);

        GetDAO getDAO = new GetDAO();
        Tb_Getmoeny tb_getmoeny = new Tb_Getmoeny();
        getDAO.find();
    }
}
