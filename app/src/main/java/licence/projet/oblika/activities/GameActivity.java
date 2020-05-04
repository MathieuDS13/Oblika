package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Context;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;

import licence.projet.oblika.engine.utils.Accelerometer;

public class GameActivity extends Activity {
    private GLSurfaceView gLView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Accelerometer accelerometer = new Accelerometer();

        super.onCreate(savedInstanceState);

        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(accelerometer, SensorManager.SENSOR_ACCELEROMETER);

        gLView = new GLView(this);
        setContentView(gLView);
    }
}
