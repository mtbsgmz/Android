package com.mtbsgmz.catchthemasha;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Game extends AppCompatActivity {
    TextView scoreText;
    TextView timeText;
    ImageView i1;
    ImageView i2;
    ImageView i3;
    ImageView i4;
    ImageView i5;
    ImageView i6;
    ImageView i7;
    ImageView i8;
    MediaPlayer mediaPlayer;
    int score;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bcd);
        mediaPlayer.start();

        i1=(ImageView) findViewById(R.id.i1);
        i2=(ImageView) findViewById(R.id.i2);
        i3=(ImageView) findViewById(R.id.i3);
        i4=(ImageView) findViewById(R.id.i4);
        i5=(ImageView) findViewById(R.id.i5);
        i6=(ImageView) findViewById(R.id.i6);
        i7=(ImageView) findViewById(R.id.i7);
        i8=(ImageView) findViewById(R.id.i8);

        imageArray = new ImageView[] {i1,i2,i3,i4,i5,i6,i7,i8};
        hideImages();

        score = 0;
        new CountDownTimer(10000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeText = (TextView) findViewById(R.id.timeid);
                timeText.setText("TIME: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timeText = (TextView) findViewById(R.id.timeid);
                for(ImageView image : imageArray){

                    image.setVisibility(View.INVISIBLE);
                }

                handler.removeCallbacks(runnable);

                Intent intent = new Intent(getApplicationContext(),Finish.class);
                intent.putExtra("score",String.valueOf(score));
                startActivity(intent);

            }
        }.start();
    }
    @Override
    protected void  onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    public void increase(View view){
        scoreText = (TextView) findViewById(R.id.score);
        score++;
        scoreText.setText("SCORE: "+score);



    }

    public void hideImages(){

        handler= new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageArray){

                    image.setVisibility(View.INVISIBLE);

                }
                Random r = new Random();
                int i = r.nextInt(7-0);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };
        handler.post(runnable);

    }


}
