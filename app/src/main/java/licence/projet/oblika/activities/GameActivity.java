package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;

import licence.projet.oblika.engine.Game;
import licence.projet.oblika.engine.utils.AccelerometerListener;
import licence.projet.oblika.engine.utils.TouchEvent;

public class GameActivity extends Activity {
    private GLSurfaceView gLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AccelerometerListener accelerometerListener = new AccelerometerListener();
        TouchEvent touchEvent = new TouchEvent();


        super.onCreate(savedInstanceState);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(accelerometerListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

        gLView = new GLView(this);

        setContentView(gLView);
        gLView.setOnTouchListener(touchEvent);
    }
}
