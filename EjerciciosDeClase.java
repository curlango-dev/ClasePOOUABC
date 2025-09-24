public class EjerciciosDeClase {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        baraja.mezclar();
        Hand mano;
        mano = new Hand(baraja.extraer5Cartas());
        System.out.println(mano.toString());

        System.out.println("La mano contiene cartas con ❤");
        // operador ternario ? :
        String respuesta = mano.contieneCartaConPaloLambdas('❤') ? "si" : "no";
        System.out.println(respuesta);

        int cuantas = mano.cuantasCartasValenMasDeLambdas(5);
        System.out.println("La mano contiene " + cuantas + " mayores a 5.");

    }
}
