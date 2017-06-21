package com.example.siyu2.moneymanger;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import model.Tb_Getmoeny;

public class GetAdapter extends RecyclerView.Adapter<GetAdapter.ViewHolder> {

    private List<Tb_Getmoeny> mGetList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView gettype,getmoney,getdate;
        View getView;

        public ViewHolder(View view) {
            super(view);
            getView = view;
            gettype = (TextView) view.findViewById(R.id.recdate);
            getmoney = (TextView) view.findViewById(R.id.recmoney);
            getdate = (TextView) view.findViewById(R.id.rectype);
        }
    }

    public GetAdapter (List<Tb_Getmoeny> getmoenyList) {
        mGetList =getmoenyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_gl,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.getView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Tb_Getmoeny tbGetmoeny = mGetList.get(position);
                Intent intent = new Intent(view.getContext().getApplicationContext(),UpdateGet.class);
                String furk1 = tbGetmoeny.getTime();
                intent.putExtra("jine_xinxi",furk1);
                String furk2 = tbGetmoeny.getType();
                intent.putExtra("date_xinxi",furk2);
                String furk3 = tbGetmoeny.getMoney();
                intent.putExtra("leibie_xinxi",furk3);
                view.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tb_Getmoeny getmoeny = mGetList.get(position);
        holder.gettype.setText(getmoeny.getType());
        holder.getmoney.setText(getmoeny.getMoney());
        holder.getdate.setText(getmoeny.getTime());
    }

    @Override
    public int getItemCount() {
        return mGetList.size();
    }
}
