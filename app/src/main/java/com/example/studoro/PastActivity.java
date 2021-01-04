package com.example.studoro;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PastActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private final List<String> spinnerOptions = new ArrayList<>(Arrays.asList("Line Chart", "Bar Chart"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past);
        initSpinner();
    }

    public void initSpinner() {
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        spinnerOptions.add("Line Chart");
        spinnerOptions.add("Bar Chart");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void displayLineGraph() {
        GraphView graph = findViewById(R.id.stats);
        ArrayList<Integer> lol = new ArrayList<>();
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

        LineGraphSeries<DataPoint> stats = new LineGraphSeries<>();
        for(int i = 0; i < lol.size(); i++){
            stats.appendData(new DataPoint(jk.get(i), lol.get(i)), true, 100);
        }
        graph.addSeries(stats);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedOption = spinnerOptions.get(position);
        if(selectedOption.equals("Line Chart")) {
            displayLineGraph();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}