import java.util.Comparator;

/**
 * Write a description of class Carta here.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (2025-1)
 */
public abstract class Carta implements Comparable<Carta> {
    private int valor;
    protected Palo palo;
    private String color;
    private int valorBajo;

    public Carta(int valor, Palo palo, String color) {
        this.valor = valor;
        this.palo = palo;
        this.color = color;
        if (valor == 14) {
            valorBajo = 1;
        } else {
            valorBajo = valor;
        }
    }

    public String toString() {
        return switch (valor) {
            case 14 -> palo.getFigura() + "A";
            case 11 -> palo.getFigura() + "J";
            case 12 -> palo.getFigura() + "Q";
            case 13 -> palo.getFigura() + "K";
            case 15-> "Joker";
            default -> palo.getFigura() + valor;
        };
    }

    public boolean tieneElMismoValor(Carta carta) {
        return valor == carta.valor;
    }
    public boolean tieneElMismoPalo(Palo palo) {
        return this.palo.equals(palo);
    }
    public boolean esLaSiguiente(Carta carta) {
        if (valor+1 == carta.valor) {
            return true;
        }
        // verificar si es un As y un 2
        if (valor == 14 && carta.valor == 2) {
            return true;
        }
        return false;
    }
    public int getValor() {
        return valor;
    }
    public Palo getPalo() {
        return palo;
    }
    public String getColor() {
        return color;
    }
    public int getValorBajo() {
        return valorBajo;
    }
}
