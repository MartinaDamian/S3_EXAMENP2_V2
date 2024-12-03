package udla.martina.damian.exa.prog2.producto;

import udla.martina.damian.exa.prog2.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Ropa extends Producto {
    private String talla;
    private String sexo;
    private String categoria;
    private static List<Ropa> inventarioRopa = new ArrayList<>();

    public Ropa(String codigo, String nombre, double precios, Integer cantidad, String talla, String sexo, String categoria) {
        super(codigo, nombre, precios, cantidad);
        this.talla = talla;
        this.sexo = sexo;
        this.categoria = categoria;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void agregarProducto(){
        JOptionPane.showMessageDialog(null, "A continuacion ingresara un nuevo producto");
        String nCodigo= JOptionPane.showInputDialog(null, "Codigo: ");
        setCodigo(nCodigo);
        String nNombre = JOptionPane.showInputDialog(null, "Nombre: ");
        setNombre(nNombre);
        String nTalla = JOptionPane.showInputDialog(null, "Talla: ");
        setTalla(nTalla);
        String nSexo = JOptionPane.showInputDialog(null, "Sexo: ");
        setSexo(nSexo);
        String nCategoria = JOptionPane.showInputDialog(null, "Categoria: ");
        setCategoria(nCategoria);
        double nPrecio = Double.parseDouble(JOptionPane.showInputDialog(null, "Precio: "));
        setPrecios(nPrecio);
        int nCantidad= Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad: "));
        setCantidad(nCantidad);
        Ropa nRopa = new Ropa(nCodigo,nNombre,nPrecio,nCantidad,nTalla, nSexo,nCategoria);
        inventarioRopa.add(nRopa);
        System.out.println("Producto agregado al stock exitosamente");
        detalleExplicito();

    }

    @Override
    public void detalleExplicito(){
        JOptionPane.showMessageDialog(null, "Informacion del producto\nCodigo"+ getCodigo()+
                "\nNombre:" + getNombre() + "\nTallas disponibles: "+ getTalla()+ "\nSexo: " + getSexo() + "\nCategoria: " + getCategoria() +"\nPrecio: " + getPrecios() + "\nCantidad: "
                + getCantidad() );
    }
    @Override
    public void listarProductos(){
        System.out.println("       INVENTARIO DE ROPA        \n");
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-10s %-10s\n",
                "CODIGO", "NOMBRE", "TALLA", "SEXO", "CATEGORIA", "PRECIO", "CANTIDAD");
        for(Ropa ropa: inventarioRopa){
            ropa.detalleTabla();
        }
    }
    @Override
    public void detalleTabla(){
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-10.2f %-10d\n",
                getCodigo(), getNombre(), getTalla(), getSexo(), getCategoria(), getPrecios(), getCantidad());
    }
    public static Ropa buscarProducto(String id){
        for(Ropa ropa : inventarioRopa){
            if(ropa.getCodigo().equals(id)){
                return ropa;
            }
        }
        return null;
    }
}
