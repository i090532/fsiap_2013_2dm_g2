package Model;

import GraphicInterfaces.DrawSimulation;
import static Model.Magnet.SIZE;

public class Physics extends SimulationObject {

    public static final int SIZE = 225;
    private float campo;
    public Physics(float x, float y,float campo) {
        setX(x);
        setY(y);
        setSx(SIZE);
        setSy(SIZE);
        setCampo(campo);

    }

    @Override
    void update() {
    }

    @Override
    void render() {
        DrawSimulation.drawRect(getX(),getY(),SIZE,SIZE,0,0,1);//draw for testing
    }
    /**
     * @return the campo
     */
    public float getCampo() {
        return campo;
    }

    /**
     * @param campo the campo to set
     */
    public void setCampo(float campo) {
        this.campo = campo;
    }
}
