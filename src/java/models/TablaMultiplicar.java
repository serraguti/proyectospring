package models;

public class TablaMultiplicar {

    private String operacion;
    private int resultado;

    public TablaMultiplicar() {
    }

    public TablaMultiplicar(String operacion, int resultado) {
        this.operacion = operacion;
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
