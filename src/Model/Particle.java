package Model;

import GraphicInterfaces.DrawSimulation;


public class Particle extends SimulationObject {
    public static final int SIZE=4;
    private String nome;
    private double valor_carga;
    private String polaridade;
    private double massa;
    private double velocidade;

    public Particle(float x,float y,String nome,double valor_carga, String polaridade,double massa,double velocidade)
    {
        setX(x);
        setY(y);
        setSx(SIZE);
        setSy(SIZE);
        this.massa=massa;
        this.nome=nome;
        this.polaridade=polaridade;
        this.valor_carga=valor_carga;
        this.velocidade=velocidade;

    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor_carga() {
        return valor_carga;
    }

    public void setValor_carga(double valor_carga) {
        this.valor_carga = valor_carga;
    }

    public String getPolaridade() {
        return polaridade;
    }

    public void setPolaridade(String polaridade) {
        this.polaridade = polaridade;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    void update() {
       setX((float) (getX() + velocidade));
    }

    @Override
    void render() {
        DrawSimulation.drawRect(getX(),getY(),SIZE,SIZE);//draw for testing
    }

}
