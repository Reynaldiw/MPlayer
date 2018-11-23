package com.reynaldiwijaya.mplayer;

import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import co.mobiwise.library.InteractivePlayerView;
import co.mobiwise.library.OnActionClickedListener;

public class MainActivity extends AppCompatActivity implements OnActionClickedListener{

    private InteractivePlayerView ipv;
    private Button control;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.sympony);

        //Call Music
        Uri uri = Uri.parse("android.resource://com.reynaldiwijaya.mplayer/raw/sympony");
        //Mengetahui durasi musicnya
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(MainActivity.this, uri);

        String durationString = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        int milli = Integer.parseInt(durationString);
        milli = milli/1000;

        ipv = findViewById(R.id.ipv);
        ipv.setMax(milli);
        ipv.setProgress(0);
        ipv.setOnActionClickedListener(this);

        control = findViewById(R.id.btnPlay);
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ipv.isPlaying()){
                    ipv.start();
                    control.setText("Pause");
                    mediaPlayer.start();
                }else {
                    ipv.stop();
                    control.setText("Play");
                    mediaPlayer.pause();
                }
            }
        });
    }

    @Override
    public void onActionClicked(int id) {
        switch (id){
            case 1:
                //Called When 1. Action is clicked
                Toast.makeText(this, "Pilihan Shuffled", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                //Called When 2. Action is clicked
                Toast.makeText(this, "Pilihan Love", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                //Called When 3. Action is clicked
                Toast.makeText(this, "Pilihan Repeat", Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
