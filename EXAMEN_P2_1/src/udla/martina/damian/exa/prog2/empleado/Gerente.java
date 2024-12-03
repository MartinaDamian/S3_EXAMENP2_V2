package udla.martina.damian.exa.prog2.empleado;

import udla.martina.damian.exa.prog2.Empleado;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Gerente extends Empleado {
    private double bonoAnual;
    private static List<Gerente> cuentaGerente = new ArrayList<>();

    public Gerente(String id, String nombre, double salario, double bonoAnual) {
        super(id, nombre, salario);
        this.bonoAnual = bonoAnual;
    }

    public double getBonoAnual() {
        return bonoAnual;
    }

    public void setBonoAnual(double bonoAnual) {
        this.bonoAnual = bonoAnual;
    }

    @Override
    public void creacionEmpleado(){
        JOptionPane.showMessageDialog(null, "Se creara una cuenta GERENTE");
        String nId= JOptionPane.showInputDialog(null, "ID:");
        setId(nId);
        String nNombre= JOptionPane.showInputDialog(null, "Nombre:");
        setNombre(nNombre);
        double nSalario = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario:"));
        setSalario(nSalario);
        double nBonoAnual = Double.parseDouble(JOptionPane.showInputDialog(null, "Bono anual:"));
        setBonoAnual(nBonoAnual);
        Gerente nGerente = new Gerente(nId, nNombre,nSalario, nBonoAnual);
        cuentaGerente.add(nGerente);
        System.out.println("Cuenta creada exitosamente");
        detalleCuenta();
    }
    @Override
    public void detalleCuenta(){
        JOptionPane.showMessageDialog(null, "Informacion cuenta GERENTE\n" +
                " ID: " + getId() + "\n Nombre: " + getNombre()+"\n Salario: "+getSalario()+"\n Bono anual: " +
                getBonoAnual());
    }
    @Override
    public boolean inicioEmpleado(){
        JOptionPane.showMessageDialog(null, "INICIO SESION - GERENTE");
        String inicioId=JOptionPane.showInputDialog("Ingresar ID");
        Gerente gerenteInicio=null;
        for(Gerente gerente: cuentaGerente){
            if(gerente.getId().equals(inicioId)){
                gerenteInicio=gerente;
                break;
            }
        }
        if(gerenteInicio==null){
            JOptionPane.showMessageDialog(null, "Cuenta no existente, intentelo de nuevo");
            return true;
        }else {
            JOptionPane.showMessageDialog(null,"BIENVENIDO "+ gerenteInicio.getNombre());
            gerenteInicio.detalleCuenta();
            return false;
        }
    }

}
