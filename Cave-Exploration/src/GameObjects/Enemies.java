package src.GameObjects;

import src.MainGame.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Random;



/**
 * @brief Cette classe represente les adversaires dans le jeu
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */

public class Enemies extends GameObject {
    
    private GameHandler handler;
    Random r = new Random();
    int choose = 0;
    int hp = 100;
    private float pos;
    Game game;
    private BufferedImage[] enemy = new BufferedImage[4];


    /**
     * 
     * @param x coordoonee x du monstre
     * @param y coordonnee y du monstre
     * @param id type dobjet dapres lenum ObjectId
     * @param handler handler du jeu
     * @param game le jeu
     * @param ss spritesheet du monstre en quatre partie selon letat du monstre pour un rendu graphique dynamique
     */
    public Enemies(int x, int y, ObjectID id, GameHandler handler, Game game, SpriteSheet ss) {
        super(x, y, id, ss);
        this.handler = handler;
        this.game = game;
        this.enemy[0] = ss.grabImage(1, 1, 16, 16);
        this.enemy[1] = ss.grabImage(2, 1, 16, 16);
        this.enemy[2] = ss.grabImage(3, 1, 16, 16);
        this.enemy[3] = ss.grabImage(4, 1, 16, 16);
    }


    /*
     * Action du monstre a chaque tick(tour de jeu)
     */
    public void tick() {
        this.pos = (float)((double)this.pos + 0.1);
        this.x = (int)((float)this.x + this.velX);
        this.y = (int)((float)this.y + this.velY);
        this.velX = 0.0F;
        this.velY = 0.0F;
        this.choose = this.r.nextInt(3);
        if (this.choose == 0) {
            this.velX = (float)this.r.nextInt(5);
            this.velY = (float)this.r.nextInt(5);
        } else if (this.choose == 1) {
            this.velX = (float)(this.r.nextInt(5) * -1);
            this.velY = (float)(this.r.nextInt(5) * -1);
        }

        for(int i = 0; i < this.handler.objects.size(); ++i) {
            GameObject temp = (GameObject)this.handler.objects.get(i);
            if (temp.getId() == ObjectID.FireBall && this.getBounds().intersects(temp.getBounds())) {
                this.hp -= 25;
                this.handler.removeObject(temp);
            }

            if (temp.getId() == ObjectID.Block && this.getBounds().intersects(temp.getBounds())) {
                this.x = (int)((float)this.x + this.velX * -1.0F);
                this.y = (int)((float)this.y + this.velY * -1.0F);
            }
        }

        if (this.hp <= 0) {
            this.handler.removeObject(this);
        }

    }

    /*
     * rendu graphique du monstre
     */
    public void render(Graphics g) {
        g.drawImage(this.enemy[(int)this.pos % 4], this.x, this.y, (ImageObserver)null);
    }
    /**
     * Zone daction du monstre
     */
    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.w, this.h);
    }
}
