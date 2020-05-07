package licence.projet.oblika.activities;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
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
        if (sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() > 0) {
            //si l'accéléromètre est présent
            sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
        }
        gLView = new GLView(this);
        setContentView(gLView);
    }
}
