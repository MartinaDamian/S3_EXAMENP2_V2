package udla.martina.damian.exa.prog2.producto;

import udla.martina.damian.exa.prog2.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Accesorios extends Producto {
    private String tipo;
    private static List<Accesorios> inventarioAccesorios= new ArrayList<>();

    public Accesorios(String codigo, String nombre, double precios, Integer cantidad, String tipo) {
        super(codigo, nombre, precios, cantidad);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static List<Accesorios> getInventarioAccesorios() {
        return inventarioAccesorios;
    }

    public static void setInventarioAccesorios(List<Accesorios> inventarioAccesorios) {
        Accesorios.inventarioAccesorios = inventarioAccesorios;
    }

    @Override
    public void agregarProducto(){
        JOptionPane.showMessageDialog(null, "A continuacion ingresara un nuevo producto");
        String nCodigo= JOptionPane.showInputDialog(null, "Codigo: ");
        setCodigo(nCodigo);
        String nNombre = JOptionPane.showInputDialog(null, "Nombre: ");
        setNombre(nNombre);
        String nTipo = JOptionPane.showInputDialog(null, "Tipo de accesorio: ");
        setTipo(nTipo);
        double nPrecio = Double.parseDouble(JOptionPane.showInputDialog(null, "Precio: "));
        setPrecios(nPrecio);
        int nCantidad= Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad: "));
        setCantidad(nCantidad);
        Accesorios nAccesorio = new Accesorios(nCodigo,nNombre,nPrecio,nCantidad,nTipo);
        inventarioAccesorios.add(nAccesorio);
        System.out.println("Producto agregado al stock exitosamente");
        detalleExplicito();
    }

    @Override
    public void detalleExplicito(){
        JOptionPane.showMessageDialog(null, "Informacion del producto\nCodigo"+ getCodigo()+
                "\nNombre:" + getNombre() + "\nTipo de ropa: "+ getTipo()+  "\nPrecio: "
                + getPrecios() + "\nCantidad: "+ getCantidad() );
    }

    @Override
    public void listarProductos(){
        System.out.println("       INVENTARIO DE ACCESORIOS        \n");
        System.out.printf("%-10s %-20s %-10s %-10s %-10s\n", "CODIGO", "NOMBRE", "TIPO", "PRECIO", "CANTIDAD");

        for(Accesorios accesorios: inventarioAccesorios){
            accesorios.detalleTabla();
        }
    }
    @Override
    public void detalleTabla(){
        System.out.printf("%-10s %-20s %-10s %-10.2f %-10d\n",
                getCodigo(), getNombre(), getTipo(), getPrecios(), getCantidad());

    }
    public static Accesorios buscarProducto(String id){
        for(Accesorios accesorios : inventarioAccesorios){
            if(accesorios.getCodigo().equals(id)){
                return accesorios;
            }
        }
        return null;
    }
}
