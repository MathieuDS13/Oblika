package licence.projet.oblika.activities;

import android.content.Context;
import android.opengl.GLSurfaceView;

import licence.projet.oblika.engine.GameEndListener;
import licence.projet.oblika.graphic.helper.ResLoader;

public class GLView extends GLSurfaceView {
    private final GLEngine renderer;

    public GLView(Context context){
        super(context);

        ResLoader.init(context);
        setEGLContextClientVersion(3);
        renderer = new GLEngine();
        setRenderer(renderer);
    }

    public void onGameEnd(GameEndListener listener) {
        renderer.onGameEnd(listener);
    }
}
