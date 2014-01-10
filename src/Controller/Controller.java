/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataBase.Connect;
import Model.Particle;
import Model.Physics;
import Model.Magnet;
import Model.User;
import Model.UserTest;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.lwjgl.opengl.Display;

/**
 *
 * @author Andre
 */
public class Controller {

    private Connect db;

    public Controller() {
        db = new Connect();
    }

    public Particle calcularParticle(float massa, float carga, float velocidade, String positividade, String dirCampo, Physics phy, String direccao) {
        Particle p = new Particle(0, 0, " ", carga, positividade, massa, velocidade, direccao);
        p.calcularRaio(phy);
        p.calcularFrequencia();
        p.calcularPeriodo();
        p.calcularDireccao();


        return p;
    }

    public Magnet calcularMagnet(float campo, Particle p) {
        Physics physics = new Physics(0, 0, campo);
        Magnet m = new Magnet(0, 0);
        m.calcularFM(p, physics);
        return m;


    }

    public boolean registarUser(String username, String email, String password) throws SQLException {
        return db.registarUser(username, email, password);
    }

    public User login(String username, String password) throws SQLException {
        return db.login(username, password);
    }

    public boolean saveSimulation(User u, Particle p, Magnet m, float massa, float carga) {
        return db.saveSimulation(u, p, m, massa, carga);
    }

    public void removerTest(UserTest test) throws SQLException {
        db.removerTest(test);
    }
}
