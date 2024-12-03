package udla.martina.damian.exa.prog2.producto;

import udla.martina.damian.exa.prog2.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Calzado extends Producto {
    private Integer numero;
    private String sexo;
    private String color;
    private static List<Calzado> inventarioCalzado = new ArrayList<>();

    public Calzado(String codigo, String nombre, double precio, Integer cantidad, Integer numero, String sexo, String color) {
        super(codigo, nombre, precio, cantidad);
        this.numero = numero;
        this.sexo = sexo;
        this.color = color;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNumero() {
        return numero;
    }
    @Override
    public void agregarProducto(){
        JOptionPane.showMessageDialog(null, "A continuacion ingresara un nuevo producto / CALZADO");
        String nCodigo= JOptionPane.showInputDialog(null, "Codigo: ");
        setCodigo(nCodigo);
        String nNombre = JOptionPane.showInputDialog(null, "Nombre: ");
        setNombre(nNombre);
        Integer nNumero= Integer.parseInt(JOptionPane.showInputDialog(null, "Talla: "));
        setNumero(nNumero);
        String nSexo = JOptionPane.showInputDialog(null, "Sexo: ");
        setSexo(nSexo);
        String nColor = JOptionPane.showInputDialog(null, "Color: ");
        setColor(nColor);
        double nPrecio = Double.parseDouble(JOptionPane.showInputDialog(null, "Precio: "));
        setPrecios(nPrecio);
        int nCantidad= Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad: "));
        setCantidad(nCantidad);
        Calzado nCalzado = new Calzado(nCodigo,nNombre,nPrecio,nCantidad, nNumero, nSexo, nColor);
        inventarioCalzado.add(nCalzado);
        System.out.println("Producto agregado al stock exitosamente");
        detalleExplicito();
    }

    @Override
    public void detalleExplicito(){
    JOptionPane.showMessageDialog(null, "Informacion del producto\nCodigo"+ getCodigo()+
            "\nNombre:" + getNombre() + "\nTalla: "+ getNumero()+ "\nSexo: " + getSexo()+ "\nColor: " + getColor()
            + "\nPrecio: " + getPrecios() + "\nCantidad: "+ getCantidad() );
    }
    @Override
    public void listarProductos(){
        System.out.println("       INVENTARIO DE CALZADO       \n");
        System.out.printf("%-10s %-20s %-10s %-10s %-15s %-10s %-10s\n",
                "CODIGO", "NOMBRE", "NUMERO", "SEXO", "COLOR", "PRECIO", "CANTIDAD");
        for(Calzado calzado: inventarioCalzado){
            calzado.detalleTabla();
        }
    }
    @Override
    public void detalleTabla(){
        System.out.printf("%-10s %-20s %-10d %-10s %-15s %-10.2f %-10d\n",
                getCodigo(), getNombre(), getNumero(), getSexo(), getColor(), getPrecios(), getCantidad());
    }
    public static Calzado buscarProducto(String id){
     for(Calzado calzado: inventarioCalzado){
         if(calzado.getCodigo().equals(id)){
             return calzado;
         }
     }
        return null;
    }
}
