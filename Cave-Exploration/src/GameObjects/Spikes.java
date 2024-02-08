package src.GameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import src.MainGame.*;


/**
 * @brief Cette classe represente le piege a clou 
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */

public class Spikes extends GameObject {
    BufferedImage[] spikes = new BufferedImage[4];
    float pos = 0.0F;

    /**
     * 
     * @param x coordoonée x du piege
     * @param y coordoonée y du piege
     * @param id type objectid
     * @param ss spritesheet representant le piege
     */
    public Spikes(int x, int y, ObjectID id, SpriteSheet ss) {
        super(x, y, id, ss);
        this.spikes[0] = ss.grabImage(1, 1, 16, 16);
        this.spikes[1] = ss.grabImage(2, 1, 16, 16);
        this.spikes[2] = ss.grabImage(3, 1, 16, 16);
        this.spikes[3] = ss.grabImage(4, 1, 16, 16);
    }
    /*
     * action du piege sur le joueur
     */
    public void tick() {
        this.pos = (float)((double)this.pos + 0.1);
    }

    /*
     * rendu graphique du piege
     */
    public void render(Graphics g) {
        g.drawImage(this.spikes[(int)this.pos % 4], this.x, this.y, (ImageObserver)null);
    }

    /*
     * zone daction du piege
     */
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.w, this.h);
    }
}
