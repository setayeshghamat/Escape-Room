
package src.GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import src.MainGame.*;

/**
 * @brief Cette classe represente les enemis dans le jeu
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */


public class Wizard extends GameObject {
    GameHandler handler;
    Game game;
    BufferedImage[] wiz;
    private float pos;
    public int ammo = 100;
    private int hp = 100;
    SpriteSheet ss;


    /**
     * 
     * @param x coordoonée x monstre
     * @param y coordoonée tt monstre
     * @param id type objectid
     * @param handler handler du jeu
     * @param game le jeu
     * @param ss spritesheet representant le monstres dans 4 etats pour plus de dynamisme
     */
    public Wizard(int x, int y, ObjectID id, GameHandler handler, Game game, SpriteSheet ss) {
        super(x, y, id, ss);
        this.handler = handler;
        this.game = game;
        this.pos = 0.0F;
        this.wiz = new BufferedImage[4];
        this.wiz[0] = ss.grabImage(1, 1, 16, 16);
        this.wiz[1] = ss.grabImage(2, 1, 16, 16);
        this.wiz[2] = ss.grabImage(3, 1, 16, 16);
        this.wiz[3] = ss.grabImage(4, 1, 16, 16);
    }


    /*
     * action du monstre , il bouge et si entre en collison avec le joueur il l'attaque
     */
	public void tick() {
        this.pos = (float)((double)this.pos + 0.1);
        this.x = (int)((float)this.x + this.velX);
        this.y = (int)((float)this.y + this.velY);
        this.collision();
        if (this.handler.isUp()) {
            this.velY = -5.0F;
            this.pos = 3.0F;
        } else if (!this.handler.isDown()) {
            this.velY = 0.0F;
        }

        if (this.handler.isDown()) {
            this.velY = 5.0F;
            this.pos = 1.0F;
        } else if (!this.handler.isUp()) {
            this.velY = 0.0F;
        }

        if (this.handler.isRight()) {
            this.velX = 5.0F;
            this.pos = 1.0F;
        } else if (!this.handler.isLeft()) {
            this.velX = 0.0F;
        }

        if (this.handler.isLeft()) {
            this.velX = -5.0F;
            this.pos = 0.0F;
        } else if (!this.handler.isRight()) {
            this.velX = 0.0F;
        }

    }

    /**
     * 
     * rendu graphique du monstre
     */
    public void render(Graphics g) {
        g.drawImage(this.wiz[(int)this.pos % 4], this.x, this.y, (ImageObserver)null);
        g.setColor(Color.darkGray);
        g.fillRoundRect(5, 5, 100, 16, 16, 16);
        g.setColor(Color.green);
        g.fillRoundRect(5, 5, this.hp, 16, 16, 16);
        g.setColor(Color.darkGray);
        g.fillRoundRect(5, 26, 100, 16, 16, 16);
        g.setColor(Color.blue);
        g.fillRoundRect(5, 26, this.ammo, 16, 16, 16);
    }

    /*
     * test de collision et execution de laction requise (perte de points du joueur, ou du monstre etc)
     */
    private void collision() {
        for(int i = 0; i < this.handler.objects.size(); ++i) {
            GameObject tempObject = (GameObject)this.handler.objects.get(i);
            if (tempObject.getId() == ObjectID.Block && this.getBounds().intersects(tempObject.getBounds())) {
                this.x = (int)((float)this.x + this.velX * -1.0F);
                this.y = (int)((float)this.y + this.velY * -1.0F);
            }

            if (tempObject.getId() == ObjectID.Mana && this.ammo <= 75 && this.getBounds().intersects(tempObject.getBounds())) {
                this.ammo += 25;
                this.handler.removeObject(tempObject);
            }

            if (tempObject.getId() == ObjectID.Enemy && this.getBounds().intersects(tempObject.getBounds())) {
                this.hp -= 5;
            }

            if (tempObject.getId() == ObjectID.Potion && this.getBounds().intersects(tempObject.getBounds()) && this.hp <= 90) {
                this.hp += 10;
                this.handler.removeObject(tempObject);
            }

            if (tempObject.getId() == ObjectID.WinTile && this.getBounds().intersects(tempObject.getBounds())) {
                this.game.changeLevel();
            }

            if (tempObject.getId() == ObjectID.Spikes && this.getBounds().intersects(tempObject.getBounds())) {
                this.game.playerDead = true;
            }
        }

        if (this.hp <= 0) {
            this.game.playerDead = true;
        }

    }

    /*
     * zone d'action du monstre
     */
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.w, this.h);
    }
}

