/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Particle;
import Model.Physics;
import Model.Magnet;
import org.lwjgl.opengl.Display;

/**
 *
 * @author Andre
 */
public class Controller {
    
    public Controller(){
    }
  public Particle calcularParticle(float massa,float carga,float velocidade,String positividade,String dirCampo,Physics phy,String direccao){
      Particle p=new Particle(0,0," ", carga, positividade, massa, velocidade,direccao);
      p.calcularRaio(phy);
      p.calcularFrequencia();
      p.calcularPeriodo();
      

      return p;
  }
  public Magnet calcularMagnet(float campo,Particle p){
      Physics physics=new Physics(0,0,campo);
      Magnet m=new Magnet(0, 0);
      m.calcularFM(p, physics);
      return m;


  }
}
