package licence.projet.oblika.engine.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AccelerometerListener implements SensorEventListener {
    private static float x, y, z;

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x = sensorEvent.values[SensorManager.DATA_X];
        y = sensorEvent.values[SensorManager.DATA_Y];
        z = sensorEvent.values[SensorManager.DATA_Z];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //a implémenter ? des que la precision des points bougent

    }

    public static float getX() {
        return y;
    }

    public static float getY() {
        return -x;
    }

    public static float getZ() {
        return z;
    }
}
