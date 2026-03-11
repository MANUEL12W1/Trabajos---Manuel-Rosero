package co.edu.uniquindio.poo.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Orden {
    private String codigo;
    private String descripcion;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private double costo;
    private Taller ownedByTaller;
    private ArrayList<Repuesto> listaRepuestos;
    private EstadoOrden estadoOrden;
    private ArrayList<Mecanico> listaMecanicos;
    private ArrayList<Tarea> listaTareas;
    private Cliente cliente;


    public Orden(String codigo, String descripcion, LocalDate fechaIngreso, LocalDate fechaSalida, double costo, Taller ownedByTaller) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.costo = costo;
        this.ownedByTaller = ownedByTaller;
        this.listaRepuestos = new ArrayList<>();
        this.estadoOrden = estadoOrden;
        this.listaMecanicos = new ArrayList<>();
        this.listaTareas = new ArrayList<>();
        this.cliente = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Taller getOwnedByTaller() {
        return ownedByTaller;
    }

    public void setOwnedByTaller(Taller ownedByTaller) {
        this.ownedByTaller = ownedByTaller;
    }

    public ArrayList<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setListaRepuestos(ArrayList<Repuesto> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public ArrayList<Mecanico> getListaMecanicos() {
        return listaMecanicos;
    }

    public void setListaMecanicos(ArrayList<Mecanico> listaMecanicos) {
        this.listaMecanicos = listaMecanicos;
    }

    public ArrayList<Tarea> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(ArrayList<Tarea> listaTareas) {
        this.listaTareas = listaTareas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    @Override
    public String toString() {
        return "Orden{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaSalida=" + fechaSalida +
                ", costo=" + costo +
                ", ownedByTaller=" + ownedByTaller +
                ", listaRepuestos=" + listaRepuestos +
                ", estadoOrden=" + estadoOrden +
                ", listaMecanicos=" + listaMecanicos +
                ", listaTareas=" + listaTareas +
                ", cliente=" + cliente +
                '}';
    }

}
