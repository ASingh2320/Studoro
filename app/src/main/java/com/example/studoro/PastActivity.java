package com.example.studoro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class PastActivity extends AppCompatActivity {
    //followed this tutotrial:https://www.youtube.com/watch?v=8BcTXbwDGbg
    LineGraphSeries<DataPoint> stats;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past);

        GraphView graph = (GraphView) findViewById(R.id.stats);
        ArrayList<Integer> lol = new ArrayList<Integer>();
        lol.add(4);
        lol.add(2);
        lol.add(0);
        lol.add(6);
        lol.add(9);

        ArrayList<Integer> jk = new ArrayList<>();
        jk.add(1);
        jk.add(2);
        jk.add(3);
        jk.add(4);
        jk.add(5);

        stats = new LineGraphSeries<DataPoint>();
        for(int i = 0; i < lol.size(); i++){
            stats.appendData(new DataPoint(jk.get(i), lol.get(i)), true, 100);
        }
        graph.addSeries(stats);

    }
}