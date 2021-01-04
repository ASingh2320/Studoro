package com.example.studoro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initStartButton();
        initResetButton();
        initPastButton();
        initFutureButton();
        runTimer();
    }


    public void initStartButton() {
        final Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(v -> {
            running = !running;
            if(!running) {
                startButton.setText(R.string.start_button_text);
            }
            else {
                startButton.setText(R.string.stop_button_text);
            }
        });
    }

    public void initResetButton() {
        final Button resetButton = findViewById(R.id.resetButton);
        final Button startButton = findViewById(R.id.startButton);
        resetButton.setOnClickListener(v -> {
            running = false;
            seconds = 0;
            startButton.setText(R.string.start_button_text);
        });
    }

    private void runTimer() {
        final TextView timerDisplay = findViewById(R.id.timerDisplay);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, secs);

                timerDisplay.setText(time);

                if (running) seconds++;
                handler.postDelayed(this, 1000);
            }
        });
    }

    private void initPastButton() {
        Button pastbtn = findViewById(R.id.pastbutton);
        pastbtn.setOnClickListener(v -> openPastActivity());
    }
    private void openPastActivity() {
        Intent intent = new Intent(this, PastActivity.class);
        startActivity(intent);
    }


    private void initFutureButton() {
        Button futurebtn = findViewById(R.id.futurebutton);
        futurebtn.setOnClickListener(v -> openFutureActivity());
    }

    private void openFutureActivity() {
        Intent intent = new Intent(this, FutureActivity.class);
        startActivity(intent);
    }


}