package Model;

public abstract class SimulationObject {
    private float x;
    private float y;
    private float sx;
    private float sy;

    abstract void update();
    abstract void render();

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the sx
     */
    public float getSx() {
        return sx;
    }

    /**
     * @param sx the sx to set
     */
    public void setSx(float sx) {
        this.sx = sx;
    }

    /**
     * @return the sy
     */
    public float getSy() {
        return sy;
    }

    /**
     * @param sy the sy to set
     */
    public void setSy(float sy) {
        this.sy = sy;
    }
}
