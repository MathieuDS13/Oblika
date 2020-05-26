package licence.projet.oblika.engine.utils;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

import licence.projet.oblika.R;

public class AudioHandler {

    private static MediaPlayer mediaPlayer;
    private static MediaPlayer jumpPlayer;
    private static Context context;
    private static float volume = 50f;
    private static List<MediaPlayer> players = new ArrayList<>();
    private final static int MAX_VOLUME = 100;

    public static void init(Context context){
        AudioHandler.context = context;
        AudioHandler.mediaPlayer = MediaPlayer.create(context, R.raw.music);
        AudioHandler.jumpPlayer = MediaPlayer.create(context, R.raw.jump);
        players.add(mediaPlayer);
        players.add(jumpPlayer);
    }

    public static void startLoop(){
        mediaPlayer.setLooping(true);
        setVolume(volume);
        mediaPlayer.start();
    }

    public static void endLoop(){
        mediaPlayer.stop();
    }

    public static void playJumpSound(){
        jumpPlayer.start();
    }

    public static void setVolume(float volume){
        final float newVolume = (float) (1 - (Math.log(MAX_VOLUME - volume) / Math.log(MAX_VOLUME)));
        AudioHandler.volume = volume;
        for (MediaPlayer player :
                players) {
            player.setVolume(newVolume, newVolume);
        }
    }

    public static float getVolume(){
        return volume;
    }

}
