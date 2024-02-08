package src.MainGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import src.UI.*;
import src.GameObjects.*;

/**
 * @brief Cette classe est le coeur du programme , c'est le jeu en lui elle s'occupe de la partie fontionnelle , la boucle de jeu.
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */

public class Game extends Canvas implements Runnable {
    public Constants con = new Constants();
    private boolean isRunning = false;
    private Thread thread;
    private GameHandler handler;
    private SpriteSheet ssPlayer;
    private SpriteSheet ssEnemy;
    private SpriteSheet ssSpikes;
    private SpriteSheet ssManaPotion;
    private ImageLoader loader;
    private Window win;
    public boolean playerDead = false;
    private int currLevel = 0;
    private BufferedImage ground = null;
    private BufferedImage winty = null;
    private BufferedImage wall = null;
    private BufferedImage[] levels = new BufferedImage[5];


    /**
     * crée le jeu avec les differents objets du jeu , chargement des niveaux et start thread
     */
    public Game() {
        this.con.loadConfig();
        this.win = new Window(this.con.width, this.con.height, this.con.title, this);
        this.start();
        this.handler = new GameHandler();
        this.loader = new ImageLoader();
        this.addKeyListener(new KeyInput(this.handler));
        this.addMouseListener(new MouseInput(this.handler));
        this.ssPlayer = new SpriteSheet(this.loader.loadImage("/Player.png"));
        this.ssEnemy = new SpriteSheet(this.loader.loadImage("/Enemy.png"));
        this.ssManaPotion = new SpriteSheet(this.loader.loadImage("/Vials.png"));
        this.ssSpikes = new SpriteSheet(this.loader.loadImage("/Spikes.png"));
        this.levels[0] = this.loader.loadImage(this.con.levelDesign1);
        this.levels[1] = this.loader.loadImage(this.con.levelDesign2);
        this.levels[2] = this.loader.loadImage(this.con.levelDesign3);
        this.levels[3] = this.loader.loadImage(this.con.levelDesign4);
        this.levels[4] = this.loader.loadImage(this.con.levelDesign5);
        this.ground = this.loader.loadImage("/Ground.png");
        this.winty = this.loader.loadImage("/Stairs.png");
        this.wall = this.loader.loadImage("/Wall.png");
        this.loadLevel(this.levels[this.currLevel], -1, -1);
    }

    /*
     * creation et start d'un thread
     */
    private synchronized void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }
    /**
     * stop d'un thread
     */
    private synchronized void stop() {
        if (this.isRunning) {
            this.isRunning = false;

            try {
                this.thread.join();
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }

        }
    }

    /*
     * implementation de la methode run de linterface Runnable pour gerer les evenements recu par lutilisateur
     */
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1.0E9 / amountOfTicks;
        double delta = 0.0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;

        while(this.isRunning) {
            long now = System.nanoTime();
            delta += (double)(now - lastTime) / ns;

            for(lastTime = now; delta >= 1.0; --delta) {
                this.tick();
                ++updates;
            }

            this.render();
            ++frames;
            if (System.currentTimeMillis() - timer > 1000L) {
                timer += 1000L;
                frames = 0;
                updates = 0;
            }
        }

        this.stop();
    }


    /*
     * rendu graphique du jeu
     */
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
        } else {
            Graphics g = bs.getDrawGraphics();
            g.setColor(Color.black);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.drawImage(this.ground, 0, 0, (ImageObserver)null);
            this.handler.render(g);
            g.dispose();
            bs.show();
        }
    }

    /*
     * Action du jeu , test si le joueur gagne , meurt, passe au niveau suivant
     */
    private void tick() {
        if (this.playerDead) {
            this.handler.clearLevel();
            this.win.GameDispose();
            new GameOver();
            this.isRunning = false;
        }

        this.handler.tick();
    }

    /**
     * chargement d'un niveau parmis les niveaux(pages) qu'on a , selon la couleur des cases qu'on a dans limage png on decide quel type dobjet du jeu on va creer
     */
    private void loadLevel(BufferedImage image, int offsetx, int offsety) {
        int w = image.getWidth();
        int h = image.getHeight();

        for(int xx = 0; xx < w; ++xx) {
            for(int yy = 0; yy < h; ++yy) {
                int pixel = image.getRGB(xx, yy);
                int red = pixel >> 16 & 255;
                int green = pixel >> 8 & 255;
                int blue = pixel & 255;
                if (red == 255 && green == 255 && blue == 255) {
                    this.handler.addObject(new Block(xx * this.con.objWidth + offsetx * this.con.objWidth, yy * this.con.objHeight + offsety * this.con.objWidth, ObjectID.Block, this.wall));
                }

                if (red == 0 && green == 0 && blue == 255) {
                    this.handler.addObject(new Wizard(xx*con.objWidth+offsetx*con.objWidth, yy*con.objHeight+(offsety*con.objWidth), ObjectID.Player, this.handler, this, this.ssPlayer));
                }

                if (red == 255 && green == 0 && blue == 0) {
                    this.handler.addObject(new Enemies(xx * this.con.objWidth + offsetx * this.con.objWidth, yy * this.con.objHeight + offsety * this.con.objWidth, ObjectID.Enemy, this.handler, this, this.ssEnemy));
                }

                if (red == 255 && green == 255 && blue == 0) {
                    this.handler.addObject(new Mana(xx * this.con.objWidth + offsetx * this.con.objWidth, yy * this.con.objHeight + offsety * this.con.objWidth, ObjectID.Mana, this, this.ssManaPotion));
                }

                if (red == 0 && green == 255 && blue == 0) {
                    this.handler.addObject(new WinTile(xx * this.con.objWidth + offsetx * this.con.objWidth, yy * this.con.objHeight + offsety * this.con.objWidth, ObjectID.WinTile, this.winty));
                }

                if (red == 0 && green == 255 && blue == 255) {
                    this.handler.addObject(new Potion(xx * this.con.objWidth + offsetx * this.con.objWidth, yy * this.con.objHeight + offsety * this.con.objWidth, ObjectID.Potion, this.ssManaPotion));
                }

                if (red == 255 && green == 0 && blue == 255) {
                    this.handler.addObject(new Spikes(xx * this.con.objWidth + offsetx * this.con.objWidth, yy * this.con.objHeight + offsety * this.con.objWidth, ObjectID.Spikes, this.ssSpikes));
                }
            }
        }

    }

    /*
     * changement de niveau de 0 jusqu'a 5
     */

    public void changeLevel() {
        if (this.currLevel < 4) {
            ++this.currLevel;
            this.handler.clearLevel();
            this.loadLevel(this.levels[this.currLevel], -1, -1);
        } else {
            this.isRunning = false;
            this.win.GameDispose();
            new GameWin();
        }

    }
}
