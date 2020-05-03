package licence.projet.oblika.graphic.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResLoader {
    private static Context context;

    public static void init(Context context) {
        ResLoader.context = context;
    }

    public static String text(String filename) {
        int id = context.getResources().getIdentifier(filename, "raw", context.getPackageName());
        InputStream is = context.getResources().openRawResource(id);

        InputStreamReader isReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isReader);
        StringBuffer sb = new StringBuffer();
        String str;

        try {
            while((str = reader.readLine()) != null){
                sb.append(str);
                sb.append("\n");
            }
        } catch (Exception e) {}

        return sb.toString();
    }

    public static Bitmap bitmap(String filename) {
        int id = context.getResources().getIdentifier(filename, "drawable", context.getPackageName());

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;

        return BitmapFactory.decodeResource(context.getResources(), id, options);
    }
}

