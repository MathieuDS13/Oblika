package licence.projet.oblika.engine.utils;

import android.content.Context;
import android.media.MediaPlayer;

import licence.projet.oblika.R;

public class AudioHandler {

    private static MediaPlayer mediaPlayer;
    private static Context context;

    public static void init(Context context){
        AudioHandler.context = context;
        AudioHandler.mediaPlayer = MediaPlayer.create(context, R.raw.music);
        mediaPlayer.start();
    }

}
