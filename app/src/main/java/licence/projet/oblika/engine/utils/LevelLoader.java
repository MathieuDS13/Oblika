package licence.projet.oblika.engine.utils;

public class LevelLoader {

    LevelStructure level;
    String levelName;
    private enum types {MOV_PLAT, PLAT, ENNEMY, PLAYER, ENDPOINT}

    public LevelLoader(String levelName) {
        this.level = new LevelStructure();
        parse(levelName);
    }

    private void parse(String levelName){

    }



}
