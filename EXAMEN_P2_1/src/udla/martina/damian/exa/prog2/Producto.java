package udla.martina.damian.exa.prog2;

abstract public class Producto {
    private String codigo;
    private String nombre;
    private double precios;
    private Integer cantidad;
    private Integer cantidadVendida;

    public Producto(String codigo, String nombre, double precios, Integer cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precios = precios;
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecios() {
        return precios;
    }

    public void setPrecios(double precios) {
        this.precios = precios;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Integer cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public abstract void agregarProducto();
    public abstract void detalleExplicito();
    public abstract void detalleTabla();
    public abstract void listarProductos();
    public void reducirCantidad(Integer cantidadVendida){
        this.cantidad -= cantidadVendida;
        this.cantidadVendida= cantidadVendida;
    }



}
