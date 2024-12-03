package udla.martina.damian.exa.prog2;

import udla.martina.damian.exa.prog2.empleado.Gerente;
import udla.martina.damian.exa.prog2.empleado.Vendedor;
import udla.martina.damian.exa.prog2.producto.Accesorios;
import udla.martina.damian.exa.prog2.producto.Calzado;
import udla.martina.damian.exa.prog2.producto.Ropa;

import javax.swing.*;

public class Inicio {
    private String encargado;
    public void inicioSesion() {
        boolean sesion = true;
        while (sesion) {
            int optionI = Integer.parseInt(JOptionPane.showInputDialog(null, "BIENVENIDO AL SISTEMA DE LA TIENDA DE ROPA\n" +
                    " Escoger como ingresar al sistema\n 1.Inicio de sesion\n 2.Creacion de cuenta\n 3.Salir"));
            switch (optionI) {
                case 1:
                    int optionRol = Integer.parseInt(JOptionPane.showInputDialog(null,
                            " Cual es su rol\n 1.Gerente\n 2.Vendedor\n"));
                    switch (optionRol) {
                        case 1:
                            Gerente gerente = new Gerente("", "", 0.0f, 0.0f);
                            sesion = gerente.inicioEmpleado();
                            encargado = gerente.getId();
                            break;
                        case 2:
                            Vendedor vendedor = new Vendedor("", "", 0.0f, 0.0f);
                            sesion = vendedor.inicioEmpleado();
                            encargado = vendedor.getId();
                            break;
                    }
                    break;
                case 2:
                    int optionCreate = Integer.parseInt(JOptionPane.showInputDialog(null,
                            " Cual es el rol a crear\n 1.Gerente\n 2.Vendedor\n"));
                    switch (optionCreate) {
                        case 1:
                            Gerente gerente = new Gerente("", "", 0.0f, 0.0f);
                            gerente.creacionEmpleado();
                            break;
                        case 2:
                            Vendedor vendedor = new Vendedor("", "", 0.0f, 0.0f);
                            vendedor.creacionEmpleado();
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);

            }
        }
        boolean out = true;
        while (out) {
            int option = Integer.parseInt(JOptionPane.showInputDialog(null, "ESCOJER EL NUMERO DE LA ACCION A REALIZAR\n" +
                    " 1.Realizar Venta\n 2.Visualizar Inventario\n 3.Agregar inventario\n 4.Salir"));
            switch (option) {
                case 1:
                    JOptionPane.showMessageDialog(null, "NUEVA VENTA");
                    Venta venta = new Venta();
                    venta.setId(JOptionPane.showInputDialog(null, "ID de la venta: "));
                    venta.setFecha(JOptionPane.showInputDialog(null, "Fecha: "));
                    venta.setIdEmpleado(encargado);
                    boolean masProducto = true;
                    int cantProducto = 0;
                    while (masProducto) {
                        cantProducto++;
                        int categoria = Integer.parseInt(JOptionPane.showInputDialog(null, "Categoria " +
                                "del producto\n 1.Ropa\n 2.Accesorios\n 3.Calzado\n 4. No mas productos"));
                        if(categoria==4){
                            masProducto=false;
                            break;
                        }
                        String idProducto = JOptionPane.showInputDialog(null, "ID del producto " + cantProducto);
                        switch (categoria) {
                            case 1:
                                Ropa ropa = Ropa.buscarProducto(idProducto);
                                if(ropa==null){
                                    JOptionPane.showMessageDialog(null,"No existe el producto");
                                    cantProducto--;
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Producto "+ ropa.getNombre()+" encontrado");
                                    int cant= Integer.parseInt(JOptionPane.showInputDialog("Cantidad de compra: "));
                                    venta.agregarProductoV(ropa, cant);
                                }
                                break;
                            case 2:
                                Accesorios accesorios = Accesorios.buscarProducto(idProducto);
                                if(accesorios==null){
                                    JOptionPane.showMessageDialog(null,"No existe el producto");
                                    cantProducto--;
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Producto "+ accesorios.getNombre()+" encontrado");
                                    int cant= Integer.parseInt(JOptionPane.showInputDialog("Cantidad de compra: "));
                                    venta.agregarProductoV(accesorios, cant);
                                }
                                break;
                            case 3:
                                Calzado calzado = Calzado.buscarProducto(idProducto);
                                if(calzado==null){
                                    JOptionPane.showMessageDialog(null,"No existe el producto");
                                    cantProducto--;
                                    break;
                                }else{
                                    JOptionPane.showMessageDialog(null, "Producto "+ calzado.getNombre()+" encontrado");
                                    int cant= Integer.parseInt(JOptionPane.showInputDialog("Cantidad de compra: "));
                                    venta.agregarProductoV(calzado, cant);
                                }
                                break;

                        }
                    }
                    //Impresion de la venta
                    venta.impresion();
                    break;
                case 2:
                    int option2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoger la seccion a visualizar\n" +
                            " 1.Ropa\n 2.Accesorios\n 3.Calzado\n 4.Todas"));
                    switch (option2) {
                        case 1:
                            Ropa ropa = new Ropa("", "", 0.0f, 0, "", "", "");
                            ropa.listarProductos();
                            break;
                        case 2:
                            Accesorios accesorios = new Accesorios("", "", 0.0f, 0, "");
                            accesorios.listarProductos();
                            break;
                        case 3:
                            Calzado calzado = new Calzado("", "", 0.0f, 0, 0, "", "");
                            calzado.listarProductos();
                            break;
                        case 4:
                            Ropa ropa1 = new Ropa("", "", 0.0f, 0, "", "", "");
                            ropa1.listarProductos();
                            Accesorios accesorios1 = new Accesorios("", "", 0.0f, 0, "");
                            accesorios1.listarProductos();
                            Calzado calzado1 = new Calzado("", "", 0.0f, 0, 0, "", "");
                            calzado1.listarProductos();
                            break;
                    }
                    break;
                case 3:
                    int option3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoger la seccion donde se agregara el inventario\n" +
                            " 1.Ropa\n 2.Accesorios\n 3.Calzado"));
                    switch (option3) {
                        case 1:
                            Ropa ropa = new Ropa("", "", 0.0f, 0, "", "", "");
                            ropa.agregarProducto();
                            break;
                        case 2:
                            Accesorios accesorios = new Accesorios("", "", 0.0f, 0, "");
                            accesorios.agregarProducto();
                            break;
                        case 3:
                            Calzado calzado = new Calzado("", "", 0.0f, 0, 0, "", "");
                            calzado.agregarProducto();
                            break;
                    }
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "GRACIAS POR USAR NUESTRO SISTEMA");
                    out = false;
                    break;

            }
        }
    }
}
