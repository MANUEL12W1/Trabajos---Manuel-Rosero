package co.edu.uniquindio.poo.app.model;
import java.util.ArrayList;

public class TallerBicicletas {
     // Atributos
     private String  nombre;
     private String dueño;
     private int numeroClientes;

     // Relaciones

    private ArrayList<Mecanico> listaMecanicos;
    private ArrayList<Cliente> listClientes;
    private ArrayList<Orden> listOrdenes;

    // Constructor
    public TallerBicicletas (String nombre , String dueño, int numeroClientes ){
        this.nombre = nombre;
        this.dueño = dueño;
        this.numeroClientes = numeroClientes;
        this.listaMecanicos = new ArrayList<>();
        this.listClientes = new ArrayList<>();
        this.listOrdenes = new ArrayList<>();

    }

    // Sets y Gets

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public int getNumeroClientes() {
        return numeroClientes;
    }

    public void setNumeroClientes(int numeroClientes) {
        this.numeroClientes = numeroClientes;
    }

    public ArrayList<Mecanico> getListaMecanicos() {
        return listaMecanicos;
    }

    public void setListaMecanicos(ArrayList<Mecanico> listaMecanicos) {
        this.listaMecanicos = listaMecanicos;
    }

    public ArrayList<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(ArrayList<Cliente> listClientes) {
        this.listClientes = listClientes;
    }

    public ArrayList<Orden> getListOrdenes() {
        return listOrdenes;
    }

    public void setListOrdenes(ArrayList<Orden> listOrdenes) {
        this.listOrdenes = listOrdenes;
    }

    //Metodos
    public void agregarMecanico(Mecanico mecanico){
        listaMecanicos.add(mecanico);
    }
    public void registrarCliente(Cliente cliente){
        listClientes.add(cliente);
        this.numeroClientes = listClientes.size();
    }
    public void crearOrden (Orden orden){
        listOrdenes.add(orden);
    }
    public Mecanico buscarMecanicoPorNombre (String nombre){
        for (Mecanico mecanico : listaMecanicos){
            if (mecanico.getNombre().equalsIgnoreCase(nombre))
                return mecanico;
        }
        return null;
    }


    // Metodo toString

    @Override
    public String toString() {
        return "TallerBicicletas{" +
                "nombre='" + nombre + '\'' +
                ", dueño='" + dueño + '\'' +
                ", numeroClientes=" + numeroClientes +
                ", listaMecanicos=" + listaMecanicos +
                ", listClientes=" + listClientes +
                ", listOrdenes=" + listOrdenes +
                '}';
    }
}
