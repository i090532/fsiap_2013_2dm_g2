package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.lwjgl.opengl.Display;

public class Simulation {

    private ConcurrentLinkedQueue<SimulationObject> objects;

    public Simulation() {
        objects = new ConcurrentLinkedQueue<SimulationObject>();
        createParticles();
        addObject(new Magnet(350, 100));
        addObject(new Magnet(350, 550));
    }

    public void getInput() {
    }

    public void addObject(SimulationObject o) {
        objects.add(o);
    }

    public void removeObject(SimulationObject o) {
        objects.remove(o);
    }

    public void createParticles() {
        Thread one = new Thread() {

            @Override
            public void run() {
                try {
                    int i = 1;
                    while (i == 1) {
                        float random = new Random().nextFloat() * 150;//cria um numero aleatorio entre 1 e 200
                        Particle particle = new Particle((Display.getWidth() / 12) - Particle.SIZE / 2, (Display.getHeight() / 3) + (random) - Particle.SIZE, "a", 12, "positivo", 12, 1);
                        addObject(particle);
                        Thread.sleep(5);
                    }
                } catch (InterruptedException v) {
                    System.out.println(v);
                }
            }
        };
        one.start();
    }

    public void update() {

        for (SimulationObject o : objects) {
            o.update();

            if (o.getX() > 700) {
                removeObject(o);
            }
        }
    }

    public void render() {
        for (SimulationObject o : objects) {
            o.render();
        }
    }
}
