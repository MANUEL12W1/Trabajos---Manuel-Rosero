package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.time.LocalTime;

public class Empresa {
    private String nombre;
    private LocalTime horaEntradaEmpresa;
    private ArrayList<Empleado> listaEmpleados;

    public Empresa(String nombre, LocalTime horaEntradaEmpresa) {
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
        this.horaEntradaEmpresa = horaEntradaEmpresa;
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

    public LocalTime getHoraEntradaEmpresa() {
        return horaEntradaEmpresa;
    }

    public void setHoraEntradaEmpresa(LocalTime horaEntradaEmpresa) {
        this.horaEntradaEmpresa = horaEntradaEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", horaEntradaEmpresa=" + horaEntradaEmpresa +
                ", listaEmpleados=" + listaEmpleados +
                '}';
    }

    public String registrarEmpleado(String nombre, String cedula, LocalTime horaEntrada, LocalTime horaSalida, Empresa ownedByEmpresa) {
        String resultado = "";

        Empleado empleadoEncontrado = buscarEmpleado(cedula);
        if (empleadoEncontrado != null) {
            resultado = "Ya se encuentra registrado";
        } else {
            Empleado empleado = new Empleado(nombre, cedula, horaEntrada, horaSalida, this);
            listaEmpleados.add(empleado);
            resultado = "Empleado Agregado";
        }
        return resultado;
    }

    public Empleado buscarEmpleado(String cedula) {
        Empleado empleadoAux = null;
        for (Empleado aux : listaEmpleados) {
            if (aux.getCedula().equalsIgnoreCase(cedula)) {
                return aux;
            }
        }
        return empleadoAux;
    }

    public String actualizarEmpleado(String nombre, String cedula, LocalTime horaEntrada, LocalTime horaSalida, Empresa ownedByEmpresa) {
        String resultado = "";

        Empleado empleadoEncontrado = buscarEmpleado(cedula);
        if (empleadoEncontrado == null) {
            resultado = "No existe ese empleado";
        } else {
            empleadoEncontrado.setNombre(nombre);
            empleadoEncontrado.setCedula(cedula);
            empleadoEncontrado.setHoraEntrada(horaEntrada);
            empleadoEncontrado.setHoraSalida(horaSalida);
            resultado = "Empleado actualizado";
        }
        return resultado;
    }
    public ArrayList<Empleado> consultarEmpleadosTarde() {
        ArrayList<Empleado> resultado = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.llegoTarde(this.horaEntradaEmpresa)) {
                resultado.add(empleado);
            }
        }
        return resultado;
    }
}
