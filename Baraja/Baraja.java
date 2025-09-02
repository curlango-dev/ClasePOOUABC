import java.util.ArrayList;

/**
 * Write a description of class Baraja here.
 *
 * @author (Cecilia Curlango Rosas)
 * @version 1.0 (1 septiembre 2025)
 */
public class Baraja
{
    private ArrayList<Carta> cartas;
    
    public Baraja() {
        cartas = new ArrayList();
        llenar();
    }
    
    private void llenar() {
        Carta carta;
        for (int i=1; i<=13; i++) {
            carta = new Carta('C',i); // Corazón
            cartas.add(carta);
            carta = new Carta('D',i); // Diamante
            cartas.add(carta);
            carta = new Carta('T',i); // Trebol
            cartas.add(carta);
            carta = new Carta('P',i); // Pica
            cartas.add(carta);
        }
    }
    
}