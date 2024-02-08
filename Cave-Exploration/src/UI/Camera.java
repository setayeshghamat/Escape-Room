

package src.UI;

import src.GameObjects.GameObject;


/**
 * @brief Cette classe tient en compte les coordoonés des objets
 * @author Farid Yasmina
 * @author Ghamat Seyedehsetayesh
 */
public class Camera {
    private float x;
    private float y;

    public Camera(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void tick(GameObject object) {
        this.x += ((float)object.getX() - this.x - 500.0F) * 0.05F;
        this.y += ((float)object.getY() - this.y - 281.0F) * 0.05F;
        if (this.x <= 0.0F) {
            this.x = 0.0F;
        }

        if (this.x >= 1126.0F) {
            this.x = 1126.0F;
        }

        if (this.y <= 0.0F) {
            this.y = 0.0F;
        }

        if (this.y >= 656.0F) {
            this.y = 656.0F;
        }

    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
