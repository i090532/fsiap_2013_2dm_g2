/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataBase.Connect;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class User {
    private Connect db;
    private String userName, email, password;
    private List userSimulation=new ArrayList<UserTest>();

    public User(String userName, String email, String password) throws SQLException {
        db=new Connect();
        setUserName(userName);
        setPassword(password);
        setEmail(email);
        preencherTest();
    }

    public User() {

    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userSimulation
     */
    public List<UserTest> getUserSimulation() {
        return userSimulation;
    }

    /**
     * @param userSimulation the userSimulation to set
     */
    public void setUserSimulation(List<UserTest> userSimulation) {
        this.userSimulation = userSimulation;
    }

    public void preencherTest() throws SQLException {

        setUserSimulation(db.preencherTest(getUserName()));
    }
}
