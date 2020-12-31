package com.example.studoro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
//followed this tutotrial:https://www.youtube.com/watch?v=8BcTXbwDGbg
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future2);

        PieChart doroParam = (PieChart) findViewById(R.id.session);
        float[] ydata = {50f, 10f};
        String[] xdata = {"Doro", "Rest"};

        doroParam.setHoleRadius(25f);
        double percent = (50.0/60.0) * 100.0;
        int temp = (int) (percent * 100);
        percent = temp / 100.0;
        doroParam.setCenterText(Double.toString(percent));
        doroParam.setCenterTextSize(12);

        ArrayList<PieEntry> yent = new ArrayList<>();
        ArrayList<String> xent =  new ArrayList<>();

        yent.add(new PieEntry(ydata[0]));
        yent.add(new PieEntry(ydata[1]));

        xent.add(xdata[0]);
        xent.add(xdata[1]);

        PieDataSet dataSet = new PieDataSet(yent, "Parameters");
        dataSet.setSliceSpace(1);

        ArrayList<Integer> color = new ArrayList<>();
        color.add(Color.BLUE);
        color.add(Color.YELLOW);

        dataSet.setColors(color);

        Legend leg = doroParam.getLegend();
        leg.setForm(Legend.LegendForm.CIRCLE);

        PieData dat = new PieData(dataSet);
        doroParam.setData(dat);
        doroParam.invalidate();
    }
}