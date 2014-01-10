package Model;

import GraphicInterfaces.DrawSimulation;
import java.text.DecimalFormat;

public class Particle extends SimulationObject {

    public float angle = 0;
    public static final int SIZE = 4;
    private String nome;
    private double valor_carga;
    private String polaridade;
    private String direccao;
    private double massa;
    private double velocidade;
    private double frequencia;
    final double PI = 3.141592654;
    private float periodo;
    private float x, y;
    private float raio;
    private String saida;
     boolean check = false,sair=false;

    public Particle(float x, float y, String nome, double valor_carga, String polaridade, double massa, double velocidade, String direccao) {
        setX(x);
        setY(y);
        setSx(SIZE);
        setSy(SIZE);
        this.massa = massa;
        this.nome = nome;
        this.polaridade = polaridade;
        this.valor_carga = valor_carga;
        this.velocidade = velocidade;
        this.direccao = direccao;

    }

    public Particle() {
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
        int simetrico=1;
        if(getSaida().compareToIgnoreCase("baixo")==0) simetrico=-1;
        
        float rad = (float) Math.PI * angle / 360;
        float cos = (float) (getRaio() * Math.cos(rad));
        float sin = (float) (getRaio() * Math.sin(rad));
        if (getX() <= 241 && !check) { //fora do campo
            setX((float) (getX() + 1));
        } else {
            if (getX() >= 242 && getX() < 465 && getY() < 484 && getY() > 260&&!sair) {                 //dentro do campo
                check = true;
                angle += 1;
                setX((float) (getX() + cos));
                setY((float) (getY() + (sin* simetrico)));
            } else {
                    sair=true;
                    setX((float) (getX() + cos));
                    setY((float) (getY() + sin*simetrico));
            }
        }
    }

    @Override
    void render() {
        DrawSimulation.drawRect(getX(), getY(), SIZE, SIZE, 1, 1, 1);//draw for testing
    }

    public void calcularRaio(Physics campo) {
        float raio = (float) ((getVelocidade() * getMassa()) / (getValor_carga() * campo.getCampo()));
        setRaio(raio);
    }

    public void calcularFrequencia() {
        float frequencia = (float) ((getVelocidade() / getRaio()) / (2 * Math.PI));
        setFrequencia(frequencia);
    }

    public void calcularPeriodo() {
        float periodo = (float) (1 / getFrequencia());
        setPeriodo(periodo);

    }

    public void calcularDireccao() {
        if (getDireccao().compareTo("Sai") == 0) {
            if (getPolaridade().compareToIgnoreCase("Positivo") == 0) {
                setSaida("Baixo");
            } else {
                setSaida("Cima");
            }
        } else {
            if (getPolaridade().compareToIgnoreCase("Negativo") == 0) {
                setSaida("Baixo");
            } else {
                setSaida("Cima");
            }
        }
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

    /**
     * @return the frequencia
     */
    public double getFrequencia() {
        return frequencia;
    }

    /**
     * @param frequencia the frequencia to set
     */
    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    /**
     * @return the periodo
     */
    public float getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(float periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the direccao
     */
    public String getDireccao() {
        return direccao;
    }

    /**
     * @param direccao the direccao to set
     */
    public void setDireccao(String direccao) {
        this.direccao = direccao;
    }

    /**
     * @return the saida
     */
    public String getSaida() {
        return saida;
    }

    /**
     * @param saida the saida to set
     */
    public void setSaida(String saida) {
        this.saida = saida;
    }
}
