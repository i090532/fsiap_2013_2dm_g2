package GraphicInterfaces;

import Model.Particle;
import Model.Simulation;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class DrawSimulation {

    private static Particle p;
    private static Simulation simulation;

    public DrawSimulation(Particle p) {
        this.p = p;

    }

    private static void initSimulation() {
        simulation = new Simulation(p);

    }

    private static void getInput() {
        simulation.getInput();

    }

    private static void update() {
        simulation.update();
    }

    private static void render() {
        glClear(GL_COLOR_BUFFER_BIT);
        glLoadIdentity();

        simulation.render();

        Display.update();
        Display.sync(60);
    }

    public static void simulationLoop() {
        while (!Display.isCloseRequested()) {
            getInput();
            update();
            render();
        }
    }

    public static void drawRect(float x, float y, float width, float height, int red, int green, int blue) {

        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            glRotatef(0, 0, 0, 1);

            glBegin(GL_QUADS);
            {
                glColor3f(red, green, blue);
                glVertex2f(0, 0);
                glVertex2f(0, height);
                glVertex2f(width, height);
                glVertex2f(width, 0);

            }
            glEnd();

        }
        glPopMatrix();
    }

    private static void initGl() {

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), 0, Display.getHeight(), -1, 1);
        glMatrixMode(GL_MODELVIEW);


        glClearColor(0, 0, 0, 1);

        glDisable(GL_DEPTH_TEST);
    }

    private static void cleanUp() {
        Display.destroy();

    }

    private static void initDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(794, 700));
            Display.create();
            Display.setVSyncEnabled(true);
        } catch (LWJGLException ex) {
            Logger.getLogger(DrawSimulation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

        //initialize program
        initDisplay();
        initGl();

        initSimulation();

        simulationLoop();
        cleanUp();
    }
}

