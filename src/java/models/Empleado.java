package models;

public class Empleado {

    private int idEmpleado;
    private String apellido;
    private String oficio;
    private int salario;
    private int departamento;

    public Empleado() {
    }

    public Empleado(int id, String apellido, String oficio,
             int salario, int departamento) {
        this.idEmpleado = id;
        this.apellido = apellido;
        this.oficio = oficio;
        this.salario = salario;
        this.departamento = departamento;
    }

    public Empleado(int id, String apellido, String oficio,
             int salario) {
        this.idEmpleado = id;
        this.apellido = apellido;
        this.oficio = oficio;
        this.salario = salario;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
