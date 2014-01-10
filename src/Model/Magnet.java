/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GraphicInterfaces.DrawSimulation;

/**
 *
 * @author Andre
 */
public class Magnet extends SimulationObject {

    public static final int SIZE = 20;
    private float fm;
    private float campo;

    public Magnet(float x, float y) {
        setX(x);
        setY(y);
        setSx(SIZE);
        setSy(SIZE);

    }

    public Magnet() {
        
    }

    @Override
    void update() {
    }

    @Override
    void render() {
        DrawSimulation.drawRect(getX(), getY(), SIZE, SIZE, 1, 0, 0);//draw for testing
    }

    /**
     * @return the fm
     */
    public float getFm() {
        return fm;
    }

    /**
     * @param fm the fm to set
     */
    public void setFm(float fm) {
        this.fm = fm;
    }

    public void calcularFM(Particle p,Physics physics) {
        float fm=(float) (p.getValor_carga()*p.getVelocidade()*physics.getCampo());
        setFm(fm);
        setCampo(physics.getCampo());
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
