package com.example.siyu2.moneymanger;

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

        public ViewHolder(View view) {
            super(view);
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_get,parent,false);
        ViewHolder holder = new ViewHolder(view);
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
