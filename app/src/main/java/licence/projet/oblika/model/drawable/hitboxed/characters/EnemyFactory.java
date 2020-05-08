package licence.projet.oblika.model.drawable.hitboxed.characters;

import licence.projet.oblika.model.Point2D;

public class EnemyFactory {

    private String lowEnemyTextureID;
    private String mediumEnemyTextureID;
    private String highEnemyTextureID;

    public EnemyFactory(String lowEnemy, String mediumEnemy, String highEnemy){
        this.lowEnemyTextureID = lowEnemy;
        this.mediumEnemyTextureID = mediumEnemy;
        this.highEnemyTextureID = highEnemy;
    }

    public Enemy CreateLowEnemy(Point2D position){
        return new Enemy(lowEnemyTextureID, position);
    }

    public Enemy CreateMediumEnemy(Point2D position){
        return new Enemy(mediumEnemyTextureID, position);
    }

    public Enemy CreateHighEnemy(Point2D position){
        return new Enemy(highEnemyTextureID, position);
    }
}
