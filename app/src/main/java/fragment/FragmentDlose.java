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

import DAO.LoseDAO;

public class FragmentDlose extends Fragment {
    
    String str[] = {"生活","购物","交费","其他"};
    LoseDAO loseDAO = new LoseDAO();
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_downlose,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        float foo[] = {loseDAO.shenghuo(),loseDAO.gouwu(),loseDAO.jiaofei(),loseDAO.qita()};
        Histogram histogramChart = (Histogram) getView().findViewById(R.id.tjt);
        HistogramData histogramData = HistogramData.builder()
                .setXdata(str)//
                .setYdata(foo)
                .setXpCount(4)
                .setYpCount(7)
                .setXTextSize(35)
                .setYTextSize(40)
                .setYMax(loseDAO.max())
                .setAnimType(Anim.ANIM_TRANSLATE)
                .build();
        histogramChart.setChartData(histogramData);
    }
}
