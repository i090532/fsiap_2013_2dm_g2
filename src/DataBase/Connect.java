/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Model.Magnet;
import Model.Particle;
import Model.User;
import Model.UserTest;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {

    public static void main(String[] args) throws Exception {
    }

    private static Connection ObterConexao() {
        Connection conexao = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            try {
                conexao = DriverManager.getConnection("jdbc:oracle:thin:@gandalf.dei.isep.ipp.pt:1521/pdborcl", "B1_6", "lapr");
            } catch (SQLException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conexao;
    }

    public boolean registarUser(String username, String email, String password) throws SQLException {
        Connection conexao = ObterConexao();
        Statement statement = conexao.createStatement();
        String query = "select * from f_users where sigla ='" + username.toLowerCase() + "'";
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) {
            resultSet.close();
            statement.close();
            conexao.close();
            return false;
        } else {
            query = "INSERT INTO f_users VALUES ('" + username.toLowerCase() + "','" + password + "','" + email + "')";
            statement.executeQuery(query);
            resultSet.close();
            statement.close();
            conexao.close();
            return true;
        }


    }

    public User login(String username, String password) throws SQLException {
        Connection conexao = ObterConexao();
        Statement statement = conexao.createStatement();
        String query = "select * from f_users where sigla ='" + username.toLowerCase() + "'";
        ResultSet resultSet = statement.executeQuery(query);
        User u = null;
        if (resultSet.next() && password.compareTo(resultSet.getString(2)) == 0) {
            u = new User(resultSet.getString(1), resultSet.getString(3), resultSet.getString(2));
            resultSet.close();
            statement.close();
            conexao.close();

        }
        return u;
    }

    public List<UserTest> preencherTest(String userName) throws SQLException {
        try {

            UserTest user;
            List<UserTest> userTest = new ArrayList<UserTest>();
            Connection conexao = ObterConexao();
            Statement statement = conexao.createStatement();
            String query = "select * from F_TESTS where sigla ='" + userName.toLowerCase() + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                user = new UserTest(resultSet.getDate(2),
                        resultSet.getFloat(3),
                        resultSet.getFloat(4),
                        resultSet.getFloat(5),
                        resultSet.getFloat(6),
                        resultSet.getFloat(7),
                        resultSet.getFloat(8),
                        resultSet.getFloat(9),
                        resultSet.getFloat(10),
                        resultSet.getInt(11));
                userTest.add(user);
            }
            return userTest;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean saveSimulation(User u, Particle p, Magnet m, float massa, float carga) {
        try {

            DecimalFormat dc = new DecimalFormat("0.00");
            Connection conexao = ObterConexao();
            Statement statement = conexao.createStatement();
            String query = "INSERT INTO f_tests VALUES " +
                    "('" + u.getUserName() + "'" +
                    ",CURRENT_TIMESTAMP" +
                    "," + p.getVelocidade() +
                    "," + m.getCampo() +
                    "," + carga +
                    "," + massa +
                    "," + m.getFm() +
                    "," + p.getFrequencia() +
                    "," + p.getPeriodo() +
                    "," + p.getRaio() + 
                    ","+1+")";

            statement.executeQuery(query);
            return true;

        } catch (Exception e) {
            return false;
        }
    }


    public void removerTest(UserTest test) throws SQLException {
             Connection conexao = ObterConexao();
            Statement statement = conexao.createStatement();
            String query = "delete from F_TESTS where id ="+ test.getId();
            ResultSet resultSet = statement.executeQuery(query);
    }
}
