package Model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.lwjgl.opengl.Display;

public class Simulation {

    private ConcurrentLinkedQueue<SimulationObject> objects;

    public Simulation(Particle p) {
        objects = new ConcurrentLinkedQueue<SimulationObject>();
        createParticles(p);
        addObject(new Magnet(350, 250));
        addObject(new Magnet(350, 495));
        addObject(new Physics(240,270,0));
    }

    public void getInput() {
    }

    public void addObject(SimulationObject o) {
        objects.add(o);
    }

    public void removeObject(SimulationObject o) {
        objects.remove(o);
    }

    public void createParticles(final Particle p) {
      Thread one = new Thread() {
            @Override
            public void run() {
                try {
                    int i = 1;
                    while (i == 1) {
                        Particle particle = new Particle((Display.getWidth() / 12) - Particle.SIZE / 2, (Display.getHeight() / 3) + 100 - Particle.SIZE, "a", p.getValor_carga(), "positivo", 12, p.getVelocidade(),"");
                        addObject(particle);
                        Thread.sleep(100);
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
