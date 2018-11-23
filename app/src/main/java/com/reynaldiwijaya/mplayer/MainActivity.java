package com.reynaldiwijaya.mplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import co.mobiwise.library.InteractivePlayerView;
import co.mobiwise.library.OnActionClickedListener;

public class MainActivity extends AppCompatActivity implements OnActionClickedListener{

    private InteractivePlayerView ipv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ipv = findViewById(R.id.ipv);
        ipv.setMax(123);
        ipv.setProgress(78);
        ipv.setOnActionClickedListener(this);

        final Button control = findViewById(R.id.btnPlay);
        control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ipv.isPlaying()){
                    ipv.start();
                    control.setText("Pause");
                }else {
                    ipv.stop();
                    control.setText("Play");
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
