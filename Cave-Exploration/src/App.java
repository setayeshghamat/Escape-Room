package src;

import java.io.IOException;

import src.UI.GameMenu;

/**
 * @brief Cette classe est l'entree du programme elle contient le main 
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */
public class App {
    public App() {
    }

    public static void main(String[] args) throws IOException {

        new GameMenu();

    }
}