
package src.MainGame;

import java.awt.Graphics;
import java.util.LinkedList;

import src.GameObjects.*;


/**
 * @brief Cette classe stocke les objets du jeu dans une liste et met a jour les elements en cas d'action , deplacement etc
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */


public class GameHandler {
    public LinkedList<GameObject> objects = new LinkedList<>();
    private boolean up = false;
    private boolean down = false;
    private boolean right = false;
    private boolean left = false;

    public GameHandler() {
    }

    /*
     * lance des tick sur tout les objets du jeu pour qu'il executent  leur action
     */
    public void tick() {
        for(int i = 0; i < this.objects.size(); ++i) {
            GameObject temp = (GameObject)this.objects.get(i);
            temp.tick();
        }

    }

    /*
     * lance les rendu graphique des objets
     */
    public void render(Graphics g) {
        for(int i = 0; i < this.objects.size(); ++i) {
            GameObject temp = (GameObject)this.objects.get(i);
            temp.render(g);
        }

    }

    /*
     * ajoute un objets a la liste dobjets du jeu
     */
    public void addObject(GameObject temp) {
        this.objects.add(temp);
    }
    
    /*
     * enleve un objets a la liste dobjets du jeu selon l'action exp(monstre tuée , potion prise)
     */
    public void removeObject(GameObject temp) {
        this.objects.remove(temp);
    }

    /**
     * clear la liste dobjets du jeu
     */
    public void clearLevel() {
        this.objects.clear();
    }

    /*
     * changement de nieau
     */
    public void changeLevel() {
        for(int i = this.objects.size() - 1; i <= 0; --i) {
            GameObject temp = (GameObject)this.objects.get(i);
            if (temp.getId() != ObjectID.Player) {
                this.objects.remove(temp);
            }
        }

    }

    public boolean isUp() {
        return this.up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return this.down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isRight() {
        return this.right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isLeft() {
        return this.left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }
}

