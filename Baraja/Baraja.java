import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * Write a description of class Baraja here.
 *
 * @author (Cecilia Curlango Rosas)
 * @version 1.0 (1 septiembre 2025)
 */
public class Baraja
{
    private ArrayList<Carta> cartas;
    public void ordenar() {
        //Collections.sort(cartas); 
        for (int i=0; i<cartas.size()-1; i++) {
            for (int j=i+1; j<cartas.size(); j++) {
                Carta primera = cartas.get(i);
                Carta segunda = cartas.get(j);
                
                if (primera.getValor() > segunda.getValor()) {
                    
                    cartas.set(i, segunda);
                    cartas.set(j, primera);
                }
                
            }
        }
    }
    public Baraja() {
        cartas = new ArrayList();
        llenar();
    }
    public ArrayList<Carta> extraer5Cartas() {
        ArrayList<Carta> extraidas = new ArrayList();
        for (int i=0; i< 5; i++) {
            Carta carta = cartas.remove(0);
            extraidas.add(carta);
        }
        return extraidas;
    }
    public void eliminarCartasConPalo(char palo) {
        for (int i=0; i<cartas.size(); i++) {
            Carta carta = cartas.get(i);
            if (carta.getPalo() == palo) {
                cartas.remove(i);
                i--;
            }
        }
    }
    public void eliminarCartasPares() {
        for (int i=0; i<cartas.size(); i++) {
            Carta carta = cartas.get(i);
            if (carta.esPar()) {
                cartas.remove(i);
                i--;
            }
        }
    }
    public void otroMezclar() {
        Collections.shuffle(cartas);
    }
    public void mezclar() {
        Random ale = new Random();
        Carta temp;
        Carta laOtra;
        for (int i=0; i<cartas.size(); i++) {
            int j = ale.nextInt(cartas.size());
            // intercambiar las cartas
            temp = cartas.get(i);
            laOtra = cartas.get(j);
            cartas.set(i,laOtra);
            cartas.set(j,temp);
        }
    }
    public void mostrarEnOrdenInverso() {
        for(int i=cartas.size()-1; i>=0; i--) {
            Carta carta = cartas.get(i);
            System.out.println(carta);
        }
    }
    public String toString() {
        String lasCartas = "";
        for (Carta carta : cartas) {
            lasCartas = lasCartas + ", " + carta.toString();
        }
        // for (int i=0; i<cartas.size(); i++) {
            // Carta carta = cartas.get(i);
            // lasCartas = lasCartas + ", " + carta;
        // }
        return lasCartas;
    }
    private void llenar() {
        Carta carta;
        for (int i=1; i<=13; i++) {
            carta = new Carta('❤',i); // Corazón
            cartas.add(carta);
        }
        for (int i=1; i<=13; i++) {
            carta = new Carta('♦',i); // Diamante
            cartas.add(carta);
        }
        for (int i=1; i<=13; i++) {
            carta = new Carta('♣',i); // Trebol
            cartas.add(carta);
        }
        for (int i=1; i<=13; i++) {
            carta = new Carta('♠',i); // Pica
            cartas.add(carta);
        }
    }
    
}