
package src.UI;

import src.MainGame.Game;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JFrame;




/**
 * @brief Cette classe permet de creer une fenetre avec le jeu et de liberer cette fenetre avec
 * la methode game dispose
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */
public class Window {
    JFrame frame;

    public Window(int width, int height, String title, Game game) {
        this.frame = new JFrame(title);
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setMaximumSize(new Dimension(width, height));
        this.frame.setMinimumSize(new Dimension(width, height));
        this.frame.setDefaultCloseOperation(3);
        this.frame.add(game);
        this.frame.pack();
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo((Component)null);
        this.frame.setVisible(true);
    }

    public void GameDispose() {
        this.frame.dispose();
    }
}
