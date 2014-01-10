/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

public class UserTest {

    private Date data;
    private int id;
    private float velocidade, campo, carga, massa, fm, freq, per, raio;

    public UserTest(Date data,float velocidade,float campo,float carga,float massa,float fm,float freq,float per,float raio,int id) {
        setCampo(campo);
        setCarga(carga);
        setDATA(data);
        setFm(fm);
        setFreq(freq);
        setMassa(massa);
        setPer(per);
        setRaio(raio);
        setVelocidade(velocidade);
        setId(id);

    }

    public Date getDATA() {
        return data;
    }

    /**
     * @param DATA the DATA to set
     */
    public void setDATA(Date data) {
        this.data = data;
    }

    /**
     * @return the velocidade
     */
    public float getVelocidade() {
        return velocidade;
    }

    /**
     * @param velocidade the velocidade to set
     */
    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
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

    /**
     * @return the carga
     */
    public float getCarga() {
        return carga;
    }

    /**
     * @param carga the carga to set
     */
    public void setCarga(float carga) {
        this.carga = carga;
    }

    /**
     * @return the massa
     */
    public float getMassa() {
        return massa;
    }

    /**
     * @param massa the massa to set
     */
    public void setMassa(float massa) {
        this.massa = massa;
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

    /**
     * @return the freq
     */
    public float getFreq() {
        return freq;
    }

    /**
     * @param freq the freq to set
     */
    public void setFreq(float freq) {
        this.freq = freq;
    }

    /**
     * @return the per
     */
    public float getPer() {
        return per;
    }

    /**
     * @param per the per to set
     */
    public void setPer(float per) {
        this.per = per;
    }

    /**
     * @return the raio
     */
    public float getRaio() {
        return raio;
    }

    /**
     * @param raio the raio to set
     */
    public void setRaio(float raio) {
        this.raio = raio;
    }

    @Override
    public String toString(){
        return "Data:  "+getDATA()+" | Massa:  "+getMassa()+"*10^-31 Kg | Carga:  "+getCarga()+"* 10^-19 q | Campo:  "+getCampo()+"T | Velocidade:  "+getVelocidade()+"m/s";
    }

    public String toStringEmail(){
        return  "Data:  "+getDATA()+
                "\nMassa:  "+getMassa()+"*10^-31 Kg" +
                "\nCarga:  "+getCarga()+"* 10^-19 q"+
                "\nCampo:  "+getCampo()+"T"+
                "\nVelocidade:  "+getVelocidade()+"m/s"+
                "\nForça magnética:  "+ String.valueOf(getFm())+
                "\nFrequência:  "+String.valueOf(getFreq())+
                "\nPeriodo:  "+ String.valueOf(getPer())+
                "\nRaio:  "+ String.valueOf(getRaio());
    }



    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
