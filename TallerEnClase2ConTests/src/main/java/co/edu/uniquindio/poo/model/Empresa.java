package co.edu.uniquindio.poo.model;

import javax.swing.*;
import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", listaEmpleados=" + listaEmpleados +
                '}';
    }

    //CRUD EMPLEADO
    public Empleado buscarEmpleado(String documento) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getDocumento().equals(documento)) {
                return empleado;
            }
        }
        return null;
    }

    public String registrarEmpleado(Empleado nuevoEmpleado) {
        if (buscarEmpleado(nuevoEmpleado.getDocumento()) != null) {
            return "El empleado ya esta registrado";
        }
        listaEmpleados.add(nuevoEmpleado);
        return "El empleado ha sido registrado";
    }

    public void mostrarTodosLosEmpleados() {
        JOptionPane.showMessageDialog(null,"Lista de Empleados");
        if (listaEmpleados.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Agregue empleados, la lista está vacia");
        } else {
            for (Empleado empleado : listaEmpleados) {
                empleado.mostrarInformacion();
            }
        }
    }

    public double calcularNominaTotal() {
        double acumulador = 0;
        for (Empleado empleado : listaEmpleados) {
            acumulador += empleado.calcularSalarioNeto();
        }
        return acumulador;
    }

    public Empleado obtenerMayorSalarioNeto() {
        Empleado empleadoMayorSalario = null;
        for (Empleado empleado : listaEmpleados) {
            if (empleadoMayorSalario == null) {
                empleadoMayorSalario = empleado;
            } else {
                if (empleado.calcularSalarioNeto() > empleadoMayorSalario.calcularSalarioNeto()) {
                    empleadoMayorSalario = empleado;
                }
            }
        }
        return empleadoMayorSalario;
    }

    public void mostrarResumenesPago() {
        if (listaEmpleados.isEmpty()) {
            JOptionPane.showMessageDialog(null,"No hay empleados registrados");
            return;
        }
        for (Empleado empleado : listaEmpleados) {
            ResumenPago r = empleado.generarResumenPago();
            JOptionPane.showMessageDialog(null,
                    "Documento: " + r.documento() +
                            "\nNombre: " + r.nombre() +
                            "\nTipo: " + r.tipoEmpleado() +
                            "\nSalario Bruto: " + r.salarioBruto() +
                            "\nDescuentos: " + r.descuentos() +
                            "\nSalario Neto: " + r.salarioNeto());
        }
    }
    public ArrayList<Empleado> empleadosConSalarioMayorA(double valor) {
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.calcularSalarioNeto() > valor) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }
    public ArrayList<EmpleadoTemporal> temporalesConMasDe(int dias) {
        ArrayList<EmpleadoTemporal> resultado = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            if (empleado instanceof EmpleadoTemporal et && et.getDiasTrabajados() > dias) {
                resultado.add(et);
            }
        }
        return resultado;
    }

}
