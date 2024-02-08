
package src.GameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import src.MainGame.*;


/**
 * @brief Cette classe represente la potion qui donne des points dattaque(magie) au joueur
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */
public class Mana extends GameObject {
    Game game;
    BufferedImage mana;

    /**
     * 
     * @param x coordoonnée x de la potion
     * @param y coordoonnée y de la potion
     * @param id type ObjectId
     * @param game le jeu 
     * @param ss spritesheet representant la potion
     */
    public Mana(int x, int y, ObjectID id, Game game, SpriteSheet ss) {
        super(x, y, id, ss);
        this.game = game;
        this.mana = ss.grabImage(2, 1, this.w, this.h);
    }

    /**
     * elle n'a aucune action , c un objet passif
     */
    public void tick() {
    }

    /**
     * rendu graphique de mana
     */
    public void render(Graphics g) {
        g.drawImage(this.mana, this.x, this.y, (ImageObserver)null);
    }

    /**
     * zone daction de la potion Mana
     */
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.w, this.h);
    }
}
