import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class CalculadorDeModa {
    private HashMap<Integer, Numero> numeros = new HashMap<>();

    public void generarNumeros() {
        Random rand = new Random();
        for (int i = 0; i < 2000; i++) {
            int numero = rand.nextInt(20) + 1;
            if (numeros.containsKey(numero)) {
                Numero num = numeros.get(numero);
                num.incrementaFrecuencia();
            } else {
                Numero unoNuevo = new Numero(numero);
                numeros.put(numero, unoNuevo);
            }
        }
    }
    public void encontrarLaModa() {
        // establecer "moda temporal"
        Numero modaTemporal = new Numero(0);
        // recorrer el hashmap
        Iterator<Numero> iterator = numeros.values().iterator();
        if (iterator.hasNext()) {
            modaTemporal = iterator.next();
        }
        while (iterator.hasNext()) {
            Numero numero = iterator.next();
            if (modaTemporal.getFrecuencia() < numero.getFrecuencia()) {
            // comparar la frecuencia de cada numero con la "moda temporal"
                modaTemporal = numero;
            }
        }

        // buscar repeticiones de la "moda temporal"
        iterator = numeros.values().iterator();
        int contadorDeModas = 0;
        while (iterator.hasNext()) {
            Numero numero = iterator.next();
            if (numero.getFrecuencia() == modaTemporal.getFrecuencia()) {
                contadorDeModas++;
            }
        }
        if (contadorDeModas == 1) {
            System.out.println("La Moda es: " + modaTemporal);
        } else {
            System.out.println("No hay moda");
        }
    }
    public HashMap<Integer, Numero> getNumeros() {
        return numeros;
    }
    public static void main(String[] args) {
        CalculadorDeModa calculador = new CalculadorDeModa();
        calculador.generarNumeros();
        HashMap<Integer, Numero> hashNumeros = calculador.getNumeros();

        Collection<Numero> collection = hashNumeros.values();

        Iterator<Numero> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Numero numero = iterator.next();
            System.out.println(numero);
        }

        calculador.encontrarLaModa();

        HashMap hashMap = new HashMap();
        hashMap.put("Naranja", 5);
        hashMap.put( 5,"manzana");
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
