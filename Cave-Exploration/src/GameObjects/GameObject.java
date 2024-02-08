
package src.GameObjects;

import src.MainGame.*;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @brief Cette classe est la classe abstraite parente des objets du jeu
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */


public abstract class GameObject {
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected float velX;
    protected float velY;
    protected ObjectID id;
    protected SpriteSheet ss;

    public GameObject(int x, int y, ObjectID id, SpriteSheet ss) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.ss = ss;
        this.w = 16;
        this.h = 16;
    }

    public abstract void tick();

    public abstract void render(Graphics var1);

    public abstract Rectangle getBounds();


    
    /**
     * @return id type de lobjet selon l'enum ObjectId
     */
    public ObjectID getId() {
        return this.id;
    }

    
    /**
     * @param id changer l'id de lobjet selon l'enum objectId
     */
    public void setId(ObjectID id) {
        this.id = id;
    }

    /*
     * recup x objet
     */
    public int getX() {
        return this.x;
    }

    /*
     * changer y objet
     */
    public void setX(int x) {
        this.x = x;
    }

     /*
     * recup y objet
     */
    public int getY() {
        return this.y;
    }

    /*
     * changer y objet
     */

    public void setY(int y) {
        this.y = y;
    }

    /*
     * recup velocite x
     */

    public float getVelX() {
        return this.velX;
    }

    /*
     * changer velocite x
     */
    public void setVelX(float velX) {
        this.velX = velX;
    }

     /*
     * recup velocite y
     */
    public float getVelY() {
        return this.velY;
    }

    /*
     * changer velocite y
     */
    public void setVelY(float velY) {
        this.velY = velY;
    }
}
