package udla.martina.damian.exa.prog2;

abstract public class Empleado {
    private String id;
    private String nombre;
    private double salario;

    public Empleado(String id, String nombre, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }
    public abstract void creacionEmpleado();
    public abstract boolean inicioEmpleado();
    public abstract void detalleCuenta();

}
