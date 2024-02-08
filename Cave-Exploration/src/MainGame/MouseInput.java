
package src.MainGame;

import src.GameObjects.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * @brief Cette classe gre les entree souris , elle etend MouseAdapter qui implemente l'interface Mouselistener 
 * comme vu en cours pour ecouter les evenements de la souris et les gerer
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */

public class MouseInput extends MouseAdapter {
    private GameHandler handler;

    public MouseInput(GameHandler handler2) {
        this.handler = handler2;
    }

    /*
     * l'action quand on effectue un clic de souris c'est de lancer fireball vers ce point la
     */
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        for(int i = 0; i < this.handler.objects.size(); ++i) {
            GameObject tempObject = (GameObject)this.handler.objects.get(i);
            if (tempObject.getId() == ObjectID.Player) {
                Wizard wiz = (Wizard)tempObject;
                if (wiz.ammo >= 1) {
                    this.handler.addObject(new FireBall(tempObject.getX() + 16, tempObject.getY() + 16, ObjectID.FireBall, this.handler, mx, my));
                    --wiz.ammo;
                }
            }
        }

    }
}
