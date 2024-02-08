
package src.MainGame;

import src.GameObjects.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 * @brief Cette classe gre les entree clavier , elle etend keyAdapter qui implemente l'interface Keylistener 
 * comme vu en cours pour ecouter les evenements clavier et les gerer
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */
public class KeyInput extends KeyAdapter {
    GameHandler handler;

    public KeyInput(GameHandler handler2) {
        this.handler = handler2;
    }

    /*
     * action en clic 
     */
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < this.handler.objects.size(); ++i) {
            GameObject tempObject = (GameObject)this.handler.objects.get(i);
            if (tempObject.getId() == ObjectID.Player) {
                if (key == 90) {
                    this.handler.setUp(true);
                }

                if (key == 81) {
                    this.handler.setLeft(true);
                }

                if (key == 83) {
                    this.handler.setDown(true);
                }

                if (key == 68) {
                    this.handler.setRight(true);
                }
            }
        }

    }
    
    /**
     * action en clic relaché
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < this.handler.objects.size(); ++i) {
            GameObject tempObject = (GameObject)this.handler.objects.get(i);
            if (tempObject.getId() == ObjectID.Player) {
                if (key == 90) {
                    this.handler.setUp(false);
                }

                if (key == 81) {
                    this.handler.setLeft(false);
                }

                if (key == 83) {
                    this.handler.setDown(false);
                }

                if (key == 68) {
                    this.handler.setRight(false);
                }
            }
        }

    }
}
