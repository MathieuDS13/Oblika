package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import licence.projet.oblika.engine.GameEndListener;
import licence.projet.oblika.engine.utils.AccelerometerListener;
import licence.projet.oblika.engine.utils.AudioHandler;
import licence.projet.oblika.engine.utils.LevelLoader;
import licence.projet.oblika.engine.utils.TouchEventListener;

public class GameActivity extends Activity {
    private GLView gLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AccelerometerListener accelerometerListener = new AccelerometerListener();
        TouchEventListener touchEvent = new TouchEventListener();


        super.onCreate(savedInstanceState);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(accelerometerListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

        AudioHandler.init(this);
        AudioHandler.startLoop();
        gLView = new GLView(this);
        LevelLoader.init(this);


        setContentView(gLView);
        gLView.setOnTouchListener(touchEvent);

        gLView.onGameEnd(new GameEndListener() {
            @Override
            public void run() {
                Intent activity2Intent = new Intent(getApplicationContext(), EndGameActivity.class);
                startActivity(activity2Intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AudioHandler.endLoop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AudioHandler.pauseLoop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AudioHandler.resumeLoop();
    }
}
