import java.util.*;

/**
 * Write a description of class IUTexto here.
 *
 * @author (Cecilia Curlango Rosas)
 * @version (a version number or a date)
 */
public class IUTexto
{
    public ArrayList prueba() {
        ArrayList al = new ArrayList();
        al.add(5);
        al.add(4);
        al.add(3);
        al.add(2);
        al.add(1);
        Collections.sort(al);
        return al;
    }
    public void mostrar() {
        Carta carta = new Carta('P', 5);
        System.out.println(carta);
        Baraja baraja = new Baraja();
        System.out.println(baraja);
    }
}