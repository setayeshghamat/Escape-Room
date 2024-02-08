
package src.MainGame;

import java.awt.image.BufferedImage;



/**
 * @brief Cette classe represente une spritesheet , une suite d'image en pixel simple 2d representant plusieurs etat de lelement dans l'image 
 * pour creer des animations dans le jeu
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */
public class SpriteSheet {
    private BufferedImage image;

    public SpriteSheet(BufferedImage image) {
        this.image = image;
    }

    /*
     * recuperer limage en spritesheet avec ses sous images ou chacune represente un etat de lobjet
     */
    public BufferedImage grabImage(int col, int row, int width, int height) {
        return this.image.getSubimage(col * 16 - 16, row * 16 - 16, width, height);
    }
}
