package com.example.siyu2.moneymanger;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import model.Tb_Losemoney;

public class LoseAdapter extends RecyclerView.Adapter<LoseAdapter.ViewHolder>{

    private List<Tb_Losemoney> mLoseList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView losetype,losemoney,losedate;
        View loseView;

        public ViewHolder (View view) {
            super(view);
            losetype = (TextView) view.findViewById(R.id.recdate);
            losemoney =(TextView) view.findViewById(R.id.recmoney);
            losedate =(TextView) view.findViewById(R.id.rectype);
            loseView = view;
        }
    }

    public LoseAdapter (List<Tb_Losemoney> losemoenyList) {
        mLoseList=losemoenyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_gl,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.loseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Tb_Losemoney tbLosemoney = mLoseList.get(position);
                Intent intent = new Intent(view.getContext().getApplicationContext(),UpdateLose.class);
                String furk1 = tbLosemoney.getTime();
                intent.putExtra("jine_xinxi",furk1);
                String furk2 = tbLosemoney.getType();
                intent.putExtra("date_xinxi",furk2);
                String furk3 = tbLosemoney.getMoney();
                intent.putExtra("leibie_xinxi",furk3);
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tb_Losemoney tbLosemoney = mLoseList.get(position);
        holder.losetype.setText(tbLosemoney.getType());
        holder.losemoney.setText(tbLosemoney.getMoney());
        holder.losedate.setText(tbLosemoney.getTime());
    }

    @Override
    public int getItemCount() {
        return mLoseList.size();
    }
}
