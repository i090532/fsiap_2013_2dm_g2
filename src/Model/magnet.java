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

    public static final int SIZE = 40;

    public Magnet(float x, float y) {
        setX(x);
        setY(y);
        setSx(SIZE);
        setSy(SIZE);

    }

    @Override
    void update() {
    }

    @Override
    void render() {
    }
}
