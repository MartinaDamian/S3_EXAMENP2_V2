package udla.martina.damian.exa.prog2;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String id;
    private String fecha;
    private String idEmpleado;
    private static List<Producto> productosVendidos = new ArrayList<>();
    private double total;
    public Venta(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void agregarProductoV(Producto producto, int cantidad){
        if(producto.getCantidad()>=cantidad){
            producto.reducirCantidad(cantidad);
            productosVendidos.add(producto);
            total+= cantidad*producto.getPrecios();
            System.out.println("Producto " +producto.getNombre() + " agregado a la compra ");
        }else{
            System.out.println("No existe suficiente cantidad para la venta");
        }
    }
    public double getTotal() {
        return total;
    }
    public void impresion(){
        System.out.println( "           VENTA           " +
                "\n ID venta: "+getId() +"\n Fecha: "+getFecha()+"\nID empleado: "+getIdEmpleado());
        System.out.printf("%-10s %-20s %-10s %-10s\n", "CODIGO", "PRODUCTO", "CANTIDAD", "PRECIO");

        for(Producto producto: productosVendidos){
            System.out.printf("%-10s %-20s %-10d %-10.2f\n",
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getCantidadVendida(),
                    producto.getPrecios()); }
        System.out.println("\nTOTAL: " +getTotal());

    }

}
