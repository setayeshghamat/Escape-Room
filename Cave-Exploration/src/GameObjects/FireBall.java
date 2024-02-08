
package src.GameObjects;

import src.MainGame.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



/**
 * @brief Cette classe represente la boule de feu que le joueur peut lancer sur les monstres
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */

public class FireBall extends GameObject {
    private GameHandler handler;

    /**
     * 
     * @param x coordoonee x
     * @param y coordoonnee y
     * @param id object Id type
     * @param handler handler du jeu
     * @param mx coorodnee but x
     * @param my coodoonee but y
     */
    public FireBall(int x, int y, ObjectID id, GameHandler handler, int mx, int my) {
        super(x, y, id, (SpriteSheet)null);
        this.handler = handler;
        this.velX = (float)((mx - x) / 10);
        this.velY = (float)((my - y) / 10);
    }

    /**
     * action de fireball
     */
    public void tick() {
        this.x = (int)((float)this.x + this.velX);
        this.y = (int)((float)this.y + this.velY);

        for(int i = 0; i < this.handler.objects.size(); ++i) {
            GameObject temp = (GameObject)this.handler.objects.get(i);
            if (temp.getId() == ObjectID.Block && this.getBounds().intersects(temp.getBounds())) {
                this.handler.removeObject(this);
            }
        }

    }
    /*
     * rendu graphiqyue de fireball (une boule orange)
     */
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(this.x, this.y, 8, 8);
    }
    /**
     * zone d'action de fireball
     */
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, 8, 8);
    }
}
