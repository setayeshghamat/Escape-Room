package src.MainGame;


/**
 * @brief Cette classe represente les constantes initales a charger pour debuter le jeu
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */

public class Constants {
    public String title = null;
    public Integer width = null;
    public Integer height = null;
    public Integer objWidth = null;
    public Integer objHeight = null;
    public String levelDesign1 = null;
    public String levelDesign2 = null;
    public String levelDesign3 = null;
    public String levelDesign4 = null;
    public String levelDesign5 = null;
    public String spriteSheet = null;

    public Constants() {
    }

    /**
     * recuperation des infos de la fenetre et les niveaux 
     */
    public void loadConfig() {
        this.title = "Room Exploration Game";
        this.levelDesign1 = "/maps/level1.png";
        this.levelDesign2 = "/maps/level2.png";
        this.levelDesign3 = "/maps/level3.png";
        this.levelDesign4 = "/maps/level4.png";
        this.levelDesign5 = "/maps/level5.png";
        this.width = 720;
        this.height = 480;
        this.objWidth = 16;
        this.objHeight = 16;
    }
}
