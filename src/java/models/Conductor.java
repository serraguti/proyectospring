package models;

public class Conductor {

    public Conductor(Coche car) {
        System.out.println("Coche " + car.getMarca());
    }

    //UN CONDUCTOR, TENDRA UN NOMBRE
    //Y UN COCHE
    private String nombre;
    private Coche coche;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }
}
