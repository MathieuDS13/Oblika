package licence.projet.oblika.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import licence.projet.oblika.R;
import licence.projet.oblika.engine.utils.AudioHandler;

public class SoundActivity extends Activity {
    TextView tvProgressLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        AudioHandler.init(this);
        // set a change listener on the SeekBar
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(seekBarChangeListener);

        float progress = AudioHandler.getVolume();
        tvProgressLabel = findViewById(R.id.textView);
        tvProgressLabel.setText("Volume : " + progress);
        seekBar.setProgress((int) progress);
        AudioHandler.startLoop();
    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            // updated continuously as the user slides the thumb
            tvProgressLabel.setText("Volume : " + progress);
            AudioHandler.setVolume((float) progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // called when the user first touches the SeekBar
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // called after the user finishes moving the SeekBar
        }


    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AudioHandler.endLoop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AudioHandler.endLoop();
    }
}
