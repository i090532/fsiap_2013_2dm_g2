package GraphicInterfaces;

import Model.Simulation;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.java.games.input.Keyboard;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.util.glu.Sphere;
import static org.lwjgl.opengl.GL11.*;

public class DrawSimulation {

    private static Simulation simulation;

    private static void initSimulation() {
        simulation = new Simulation();

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

    public static void drawRect(float x, float y, float width, float height) {
        
        drawRect(x, y, width, height, 0);
    }

    private static void drawRect(float x, float y, float width, float height, int rot) {

        glPushMatrix();
        {
            glTranslatef(x, y, 0);
            glRotatef(rot, 0,0,1);

            glBegin(GL_QUADS);
            {
                glVertex2f(0, 0);
                glVertex2f(0, height);
                glVertex2f(width,height);
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
            Display.setDisplayMode(new DisplayMode(794,778));
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

