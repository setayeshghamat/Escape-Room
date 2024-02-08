
package src.GameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import src.MainGame.*;

/**
 * @brief Cette classe represente la potion de soin , elle fait gagné des points de vie au joueur
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */

public class Potion extends GameObject {
    BufferedImage potion;

    /**
     * 
     * @param x coordoonée x de la potion de soin
     * @param y coordonnée y de la potion de soin
     * @param id type objectId
     * @param ss spritesheet representant la potion de soin
     */
    public Potion(int x, int y, ObjectID id, SpriteSheet ss) {
        super(x, y, id, ss);
        this.potion = ss.grabImage(1, 1, this.w, this.h);
    }
    /**
     * n'a pas d'action c'est un objet passif
     */
    public void tick() {
    }
    /*
     * rendu graphique de la potion de soin
     */
    public void render(Graphics g) {
        g.drawImage(this.potion, this.x, this.y, (ImageObserver)null);
    }
    /**
     * zone d'action de la potion de soin
     */
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.w, this.h);
    }
}