public class Numero {
    private int valor;
    private int frecuencia = 1;
    public Numero(int valor) {
        this.valor = valor;
    }

    public void incrementaFrecuencia() {
        frecuencia++;
    }

    public int getFrecuencia() {
        return frecuencia;
    }
    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "(" + valor + ") " + frecuencia;
    }
}
