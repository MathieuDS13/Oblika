package licence.projet.oblika;

import org.junit.Test;

import licence.projet.oblika.engine.utils.LevelLoader;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.FixedPlatform;
import licence.projet.oblika.model.game_objects.drawable.hitboxed.platforms.MovingPlatform;
import licence.projet.oblika.model.level.LevelStructure;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void loadingIsCorrect(){
        LevelStructure level = LevelLoader.parseLevel("level1", 200, 200);
        for (FixedPlatform fixed :
                level.getFixedPlatformList()) {
            System.out.println("posX " + fixed.getPosition().getX() + " posY " + fixed.getPosition().getY() + " texture : " + fixed.getTextureId());
        }

        for (MovingPlatform moving :
                level.getMovingPlatformList()) {
            System.out.println("posX " + moving.getPosition().getX() + " posY " + moving.getPosition().getY() + " texture : " + moving.getTextureId());
        }

        System.out.println("start posX " + level.getStart().getX() + " posY " + level.getStart().getY());
    }
}