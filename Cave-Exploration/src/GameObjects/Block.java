package src.GameObjects;

import src.MainGame.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;


/**
 * @brief Cette classe represente l'objet block , un mur dans le jeu.
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */


public class Block extends GameObject {
    private BufferedImage wall;

    /**
     * 
     * @param x coordonnée x
     * @param y coordonnée y
     * @param id type dobjets d'apres lenum ObjectId
     * @param ss spritesheet ou on va charger l'image spritesheet
     */
    public Block(int x, int y, ObjectID id, BufferedImage ss) {
        super(x, y, id, (SpriteSheet)null);
        this.wall = ss;
    }

    /**
     * tick vide car il n'execute aucune action (c'est un mur)
     */
    public void tick() {
    }

    /**
     * rendu graphique du bloc
     */
    public void render(Graphics g) {
        g.drawImage(this.wall, this.x, this.y, (ImageObserver)null);
    }


    /**
     * zone d'action du bloc
     */
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.w, this.h);
    }
}