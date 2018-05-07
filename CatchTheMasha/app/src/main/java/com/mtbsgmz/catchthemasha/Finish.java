package com.mtbsgmz.catchthemasha;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Finish extends AppCompatActivity {
MediaPlayer mediaPlayer;
TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        textView= findViewById(R.id.scoreid);
        Intent intent = getIntent();
        String received = intent.getStringExtra("score");
        textView.setText("SCORE:" + received);
        mediaPlayer = MediaPlayer.create(this,R.raw.abc);
        mediaPlayer.start();
    }

    @Override
    protected void  onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    public void play(View view){
        Intent intent = new Intent(getApplicationContext(),Game.class);
        startActivity(intent);
    }
}
