package udla.martina.damian.exa.prog2.empleado;

import udla.martina.damian.exa.prog2.Empleado;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Empleado {
    private double comision;
    private static List<Vendedor> cuentasVendedor = new ArrayList<>();

    public Vendedor(String id, String nombre, double salario, double comision) {
        super(id, nombre, salario);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public void creacionEmpleado(){
        JOptionPane.showMessageDialog(null, "Se creara una cuenta de VENDEDOR");
        String nId= JOptionPane.showInputDialog(null, "ID:");
        setId(nId);
        String nNombre= JOptionPane.showInputDialog(null, "Nombre:");
        setNombre(nNombre);
        double nSalario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario:"));
        setSalario(nSalario);
        double nComision = Double.parseDouble(JOptionPane.showInputDialog(null, "Comision por venta:"));
        setComision(nComision);
        Vendedor nVendedor = new Vendedor(nId, nNombre,nSalario, nComision);
        cuentasVendedor.add(nVendedor);
        System.out.println("Cuenta creada exitosamente");
        detalleCuenta();
    }
    @Override
    public void detalleCuenta(){
        JOptionPane.showMessageDialog(null, "Informacion cuenta GERENTE\n" +
                " ID: " + getId() + "\n Nombre: " + getNombre()+"\n Salario: "+getSalario()+"\n Comision por venta: " +
                getComision());
    }
    @Override
    public boolean inicioEmpleado(){
        boolean inicio=true;
        JOptionPane.showMessageDialog(null,"INICIO SESION - VENDEDOR");
        String inicioId=JOptionPane.showInputDialog("Ingresar ID");
        Vendedor vendedorInicio=null;
        for(Vendedor vendedor: cuentasVendedor){
            if(vendedor.getId().equals(inicioId)){
                vendedorInicio=vendedor;
                break;
            }
        }
        if(vendedorInicio==null){
            JOptionPane.showMessageDialog(null, "Cuenta no existente");
        }else {
            JOptionPane.showMessageDialog(null,"BIENVENIDO "+ vendedorInicio.getNombre());
            vendedorInicio.detalleCuenta();
            inicio=false;
        }
        return inicio;
    }


}
