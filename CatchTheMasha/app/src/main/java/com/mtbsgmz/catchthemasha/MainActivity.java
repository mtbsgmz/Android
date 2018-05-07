package com.mtbsgmz.catchthemasha;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
