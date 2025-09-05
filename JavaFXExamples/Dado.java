package uabc.curlango.demojavafx;

import java.util.Random;

/**
 * Modela un dado de 6 caras.
 *
 * @author (Cecilia Curlango)
 * @version (Agosto 2025)
 */
public class Dado
{
    // instance variables - replace the example below with your own
    private int valor;
    private int lados;

    /**
     * Constructor for objects of class Dado
     */
    public Dado()
    {
        // initialise instance variables
        valor = 1;
        lados = 6;
    }

    public int lanzar() {
        Random rnd = new Random();
        valor = rnd.nextInt(lados)+1;
        return valor;
    }
    
    public int getValor() {
        return valor;
    }
    
    public void setLados(int lados) {
        this.lados = lados;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}