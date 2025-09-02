
/**
 * Carta de una baraja inglesa.
 *
 * @author (Cecilia Curlango)
 * @version 1.0 (1 septiembre 2025)
 */
public class Carta
{
    private char palo;
    private int valor;
    private boolean caraArriba;
    
    public Carta(char palo, int valor) {
        this.palo = palo;
        this.valor = valor;
        caraArriba = true;
    }
    
    // getters/setters
    
    public String toString() {
        String laCarta;
        laCarta = "" + valor + palo;
        return laCarta;
    }
}