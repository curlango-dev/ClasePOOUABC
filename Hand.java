import java.util.ArrayList;

public class Hand {
    private ArrayList<Carta> cartas = new ArrayList();

    public Hand(ArrayList<Carta> cartas) {
        this.cartas = cartas;
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
        cuantas = (int)cartas.stream()
                .filter(carta->carta.getValor()>valor)
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
