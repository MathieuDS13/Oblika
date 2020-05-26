package licence.projet.oblika.engine.utils;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioHandler {

    MediaPlayer mediaPlayer;
    private static Context context;

    public void init(Context context){
        this.context = context;
        this.mediaPlayer = MediaPlayer.create()
    }

}
