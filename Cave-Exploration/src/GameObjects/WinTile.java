package src.GameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import src.MainGame.*;

/**
 * @brief Cette classe represente la sortie de la page
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */

public class WinTile extends GameObject {
    BufferedImage wintile;

    /**
     * 
     * @param x coordonnée x sortie 
     * @param y coordonnée y sortie 
     * @param id type objectid
     * @param buf image d'escaliers representant la sortie
     */
    public WinTile(int x, int y, ObjectID id, BufferedImage buf) {
        super(x, y, id, (SpriteSheet)null);
        this.wintile = buf;
    }

    /*
     * objet passif ne fait pas d'action
     */
    public void tick() {
    }

    /*
     * rendu graphique sortie
     */
    public void render(Graphics g) {
        g.drawImage(this.wintile, this.x, this.y, (ImageObserver)null);
    }
    
    /*
     * zone daction
     */
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.w, this.h);
    }
}