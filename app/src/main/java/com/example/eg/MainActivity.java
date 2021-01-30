package com.example.eg;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button btn2;
    private TextView tmr;
    private CountDownTimer count;
    private int remainingtime = 60;
    MediaPlayer godkrishna,Endsound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.start);
        tmr=findViewById(R.id.timer);
        btn2=findViewById(R.id.cancel);
        godkrishna=MediaPlayer.create(MainActivity.this,R.raw.krishna);
        Endsound= MediaPlayer.create(MainActivity.this,R.raw.beep);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              count.start();
              godkrishna.start();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count.cancel();
                godkrishna.pause();
                Endsound.start();
            }
        });

        count=new CountDownTimer(60000,1000) {
            @Override
            public void onTick(long l) {
                remainingtime =(int) l / 1000;
                tmr.setText(String.valueOf(remainingtime));
            }

            @Override
            public void onFinish() {
                tmr.setText("time up");
                godkrishna.pause();
                Endsound.start();

            }
        };

    }
}