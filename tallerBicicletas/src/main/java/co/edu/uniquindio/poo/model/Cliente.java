package co.edu.uniquindio.poo.model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String identificacion;
    private String telefono;
    private int numeroBicicletas;
    private String direccion;
    private LocalDate fechaNacimiento;

    private Taller ownedByTaller;
    private ArrayList<Bicicleta> listaBicicletas;
    private ArrayList<Orden> listaOrdenes;

    public Cliente(String nombre, String identificacion, String telefono, int numeroBicicletas, String direccion, LocalDate fechaNacimiento, Taller ownedByTaller) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroBicicletas = numeroBicicletas;
        this.ownedByTaller = ownedByTaller;
        this.listaBicicletas = new ArrayList<>();
        this.listaOrdenes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumeroBicicletas() {
        return numeroBicicletas;
    }

    public void setNumeroBicicletas(int numeroBicicletas) {
        this.numeroBicicletas = numeroBicicletas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Taller getOwnedByTaller() {
        return ownedByTaller;
    }

    public void setOwnedByTaller(Taller ownedByTaller) {
        this.ownedByTaller = ownedByTaller;
    }

    public ArrayList<Bicicleta> getListaBicicletas() {
        return listaBicicletas;
    }

    public void setListaBicicletas(ArrayList<Bicicleta> listaBicicletas) {
        this.listaBicicletas = listaBicicletas;
    }

    public ArrayList<Orden> getListaOrdenes() {
        return listaOrdenes;
    }

    public void setListaOrdenes(ArrayList<Orden> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", numeroBicicletas=" + numeroBicicletas +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", ownedByTaller=" + ownedByTaller +
                ", listaBicicletas=" + listaBicicletas +
                ", listaOrdenes=" + listaOrdenes +
                '}';
    }
}
