import java.util.ArrayList;
import java.util.stream.Collectors;

public class Hand {
    private ArrayList<Carta> cartas = new ArrayList();

    public Hand(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    /**
     * Método en Mano que regrese un ArrayList
     * con todas las cartas que tienen el mismo valor.
     *
     * @return ArrayList con las cartas iguales
     */
    public ArrayList<Carta> getCartasIguales() {
        ArrayList<Carta> cartasIguales = new ArrayList();
        // ordenar las cartas
        ordenar();
        for (int i=0; i<cartas.size(); i++) {
            if (i < cartas.size()-1
                    && cartas.get(i).getValor() == cartas.get(i+1).getValor()) {
                cartasIguales.add(cartas.get(i));
                int j = i+1;
                // recorrer el resto del arreglo sacando las repetidas
                while (j < cartas.size()
                        && cartas.get(i).getValor()==cartas.get(j).getValor()) {
                    cartasIguales.add(cartas.get(j));
                    j++;
                }
                break;
            }
        }
        return cartasIguales;
    }

    private void ordenar() {
        // usando bubble sort que es de lo peor
        for (int i=0; i<cartas.size(); i++) {
            for (int j=i+1; j<cartas.size(); j++) {
                Carta carta = cartas.get(i);
                Carta carta2 = cartas.get(j);
                if (carta.getValor() > carta2.getValor()) {
                    Carta aux = carta;
                    carta = carta2;
                    carta2 = aux;
                }
            }
        }
    }
    /**
     * Revisa la mano y verifica si hay n cartas del mismo valor
     * @param cantidad de cartas que se buscan
     * @return true si hay N cartas con el mismo valor
     */
    private boolean hayNCartasDelMismoValor(int valor) {
        boolean hay = false;
        int cuantasHay = 0;
        for (Carta carta : cartas) {
            for (Carta carta2 : cartas) {
                if (carta.getValor()==carta2.getValor()) {
                    cuantasHay++;
                }
            }
            if (cuantasHay>=valor) {
                hay = true;
                break;
            } else {
                cuantasHay = 0;
            }
        }
        return hay;
    }
    /**
     * Método en Mano que indique si contiene un par.
     * @return true si hay una tercia, false si no
     */
    public boolean hayPar() {
        boolean hay = false;
        if (hayNCartasDelMismoValor(2)) {
            hay = true;
        }
        return hay;
    }
    /**
     * Método en Mano que indique si contiene una tercia.
     * @return true si hay una tercia, false si no
     */
    public boolean hayTercia() {
        boolean hay = false;
        if (hayNCartasDelMismoValor(3)) {
            hay = true;
        }
        return hay;
    }
    /**
     * Escribe un método en Mano que regrese
     * un ArrayList con todas las cartas rojas
     * que tiene.
     *
     * @return ArrayList con las cartas rojas
     */
    public ArrayList<Carta> getCartasRojas() {
        ArrayList<Carta> cartasRojas = new ArrayList();
        for (Carta carta : cartas) {
            if (carta.getPalo()=='❤' ||
            carta.getPalo() == '♦') {
                cartasRojas.add(carta);
            }
        }
        return cartasRojas;
    }
    /**
     * Escribe un método en Mano que regrese
     * un ArrayList con todas las cartas rojas
     * que tiene.
     * UTILIZANDO LAMBDAS
     * @return ArrayList con las cartas rojas
     */
    public ArrayList<Carta> getCartasRojasLamdas() {
        ArrayList<Carta> cartasRojas = new ArrayList();
        cartasRojas = (ArrayList) cartas.stream()
                .filter(carta -> carta.getPalo()=='❤' || carta.getPalo() == '♦')
                .collect(Collectors.toList());

        return cartasRojas;
    }
    /**
     * Método en Mano que regrese un valor
     * indicando cuántas cartas tienen valor mayor que 5.
     */
    public int cuantasCartasValenMasDe5() {
        return cuantasCartasValenMasDe(5);
    }

    private int cuantasCartasValenMasDe(int valor) {
        int cuantas = 0;
        for (Carta carta : cartas) {
            if (carta.getValor() > valor) {
                cuantas++;
            }
        }
        return cuantas;
    }

    /**
     * Método en Mano que regrese un valor
     * indicando cuántas cartas tienen valor mayor que 5.
     * UTILIZANDO LAMBDAS
     */
    public int cuantasCartasValenMasDeLambdas(int valor) {
        int cuantas = 0;
        cuantas = (int) cartas.stream()
                .filter(carta -> carta.getValor() > valor)
                .count();
        return cuantas;
    }

    /**
     * Método en Mano que indique si ésta contiene
     * cartas de un palo particular, el cual recibe como parámetro.
     * Demuestra que funciona, llamando al método desde el main().
     *
     * @return true si hay al menos una carta con ese palo
     */
    public boolean contieneCartaConPalo(char palo) {
        boolean contieneCarta = false;
        for (Carta carta : cartas) {
            if (carta.getPalo() == palo) {
                contieneCarta = true;
            }
        }
        return contieneCarta;
    }

    /**
     * Método en Mano que indique si ésta contiene
     * cartas de un palo particular, el cual recibe como parámetro.
     * Demuestra que funciona, llamando al método desde el main().
     * UTILIZA LAMBDAS
     *
     * @return true si hay al menos una carta con ese palo
     */
    public boolean contieneCartaConPaloLambdas(char palo) {
        boolean contieneCarta = false;
        int cuantasHay = (int) cartas.stream().
                filter(carta -> carta.getPalo() == palo)
                .count();

        if (cuantasHay > 0) {
            contieneCarta = true;
        }

        return contieneCarta;
    }

    @Override
    public String toString() {
        return cartas.toString();
    }
}
