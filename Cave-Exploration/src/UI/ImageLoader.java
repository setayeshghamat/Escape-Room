

package src.UI;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * @brief Cette classe permet de charger une image a partir dun chemin de fichier
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */
public class ImageLoader {
    public ImageLoader() {
    }

    public BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(this.getClass().getResource(path));
        } catch (IOException var3) {
            var3.printStackTrace();
            System.exit(1);
            return null;
        }
    }
}
