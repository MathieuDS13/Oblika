package licence.projet.oblika.engine.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;

public class Accelerometer implements SensorEventListener {
    float x, y, z;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x = sensorEvent.values[SensorManager.DATA_X];
        y = sensorEvent.values[SensorManager.DATA_Y];
        z = sensorEvent.values[SensorManager.DATA_Z];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }
}
