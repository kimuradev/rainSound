package com.sound.rain.rainsound;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Boolean isFabOpen = false;
    private MediaPlayer mediaPlayer;
    private FloatingActionButton fab, fab1, fab2, fab3;
    private Animation alpha_in, alpha_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setDisplayShowTitleEnabled(false);

        mediaPlayer = MediaPlayer.create(this, R.raw.fiveminutes);
        //mediaPlayer.setVolume(0.2f, 0.2f);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        alpha_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_in);
        alpha_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha_out);

        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab1:
                controlMediaPlayer();
                animateFAB();
                break;
            case R.id.fab2:
                controlMediaPlayer();
                animateFAB();
                break;
        }
    }

    public void controlMediaPlayer(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }else{
            mediaPlayer.start();
        }
    }

    public void animateFAB(){

        if(isFabOpen){
            fab1.startAnimation(alpha_in);
            fab2.startAnimation(alpha_out);
            fab2.setClickable(false);
            fab1.setClickable(true);
            isFabOpen = false;

        } else {

            fab1.startAnimation(alpha_out);
            fab2.startAnimation(alpha_in);
            fab1.setClickable(false);
            fab2.setClickable(true);
            isFabOpen = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
           /* case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;*/
            case R.id.item2:
                System.exit(0);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
