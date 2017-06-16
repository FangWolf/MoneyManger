package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.siyu2.moneymanger.R;
import com.zqx.chart.anim.Anim;
import com.zqx.chart.data.HistogramData;
import com.zqx.chart.view.Histogram;

import DAO.GetDAO;

public class FragmentDget extends Fragment {

    String str[] = {"工资","奖金","兼职","其他"};
    GetDAO getDao = new GetDAO();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_downget,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        float foo[] = {getDao.gongzi(),getDao.jianzhi(),getDao.jiangjin(),getDao.qita()};
        Histogram histogramChart = (Histogram) getView().findViewById(R.id.tjt);
        HistogramData histogramData = HistogramData.builder()
                .setXdata(str)//
                .setYdata(foo)
                .setXpCount(4)
                .setYpCount(7)
                .setXTextSize(35)
                .setYTextSize(40)
                .setYMax(getDao.max())
                .setAnimType(Anim.ANIM_TRANSLATE)
                .build();
        histogramChart.setChartData(histogramData);
    }
}
