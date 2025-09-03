
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
    public int getValor() {
        return valor;
    }
    public char getPalo() {
        return palo;
    }
    public boolean esPar() {
        boolean respuesta = false;
        if (valor%2 == 0) {
            respuesta = true;
        }
        return respuesta;
    }
    public String toString() {
        String laCarta;
        switch (valor) {
            case 1: 
                laCarta = "A";
                break;
            case 11:
                laCarta = "J";
                break;
            case 12:
                laCarta = "Q";
                break;
            case 13:
                laCarta = "K";
                break;
            default:
                laCarta = "" + valor;
                break;
        }
        laCarta = laCarta + palo;
        return laCarta;
    }
}