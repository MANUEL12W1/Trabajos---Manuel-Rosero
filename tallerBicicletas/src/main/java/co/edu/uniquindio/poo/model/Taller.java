package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Taller {
    private String nombre;
    private String direccion;

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Bicicleta> listaBicicletas;
    private ArrayList<Mecanico> listaMecanicos;
    private ArrayList<Orden> listaOrdenes;
    private ArrayList<Repuesto> listaRepuestos;

    public Taller (String nombre , String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;

        this.listaClientes = new ArrayList<>();
        this.listaBicicletas = new ArrayList<>();
        this.listaMecanicos = new ArrayList<>();
        this.listaOrdenes = new ArrayList<>();
        this.listaRepuestos = new ArrayList<>();
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre (){
        return nombre;
    }
    public void setListaClienftes (ArrayList<Cliente> listaClientes){
        this.listaClientes = listaClientes;
    }
    public ArrayList<Cliente> getListaClientes (){
        return listaClientes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Bicicleta> getListaBicicletas() {
        return listaBicicletas;
    }

    public void setListaBicicletas(ArrayList<Bicicleta> listaBicicletas) {
        this.listaBicicletas = listaBicicletas;
    }

    public ArrayList<Mecanico> getListaMecanicos() {
        return listaMecanicos;
    }

    public void setListaMecanicos(ArrayList<Mecanico> listaMecanicos) {
        this.listaMecanicos = listaMecanicos;
    }

    public ArrayList<Orden> getListaOrdenes() {
        return listaOrdenes;
    }

    public void setListaOrdenes(ArrayList<Orden> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    public ArrayList<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setListaRepuestos(ArrayList<Repuesto> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }

    @Override
    public String toString() {
        return "Taller{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaBicicletas=" + listaBicicletas +
                ", listaMecanicos=" + listaMecanicos +
                ", listaOrdenes=" + listaOrdenes +
                ", listaRepuestos=" + listaRepuestos +
                '}';
    }

    // CRUD CLIENTE

    /**
     * Metodo para registrar un cliente
     * @param nombre
     * @param identificacion
     * @param telefono
     * @param numeroBicicletas
     * @param direccion
     * @param fechaNacimiento
     * @return
     */


    public String registrarCliente(String nombre, String identificacion, String telefono, int numeroBicicletas, String direccion, LocalDate fechaNacimiento){
        String resultado = "";
        // Verificar si el cliente esta registrado
        Cliente clienteEncontrado = buscarCliente(identificacion);
        if(clienteEncontrado != null) {
            resultado = "Ya se encuentra registrado";
        }else{
            Cliente cliente = new Cliente(nombre, identificacion, telefono,  numeroBicicletas, direccion,  fechaNacimiento,this);
            listaClientes.add(cliente);
            resultado = "Cliente Agregado";
        }

        return resultado;

    }
    public Cliente buscarCliente (String identificacion){
        Cliente clienteAux = null;
        for ( Cliente aux : listaClientes){
            if (aux.getIdentificacion().equalsIgnoreCase(identificacion)){
                return aux;
            }
        }
        return clienteAux;
    }
    public String actualizarCliente(String nuevoNombre, String identificacion, String telefono, int numeroBicicletas, String direccion, LocalDate fechaNacimiento){
        String resultado = "";
        // Verificar si el cliente esta registrado
        Cliente clienteEncontrado = buscarCliente(identificacion);
        if(clienteEncontrado == null) {
            resultado = "No existe ese cliente";
        }else{
            clienteEncontrado.setNombre(nuevoNombre);
            clienteEncontrado.setDireccion(direccion);
            clienteEncontrado.setIdentificacion(identificacion);
            clienteEncontrado.setTelefono(telefono);
            clienteEncontrado.setNumeroBicicletas(numeroBicicletas);
            clienteEncontrado.setFechaNacimiento(fechaNacimiento);
            resultado = "Cliente actualizado";
        }

        return resultado;

    }

    // CRUD DE MECANICO
    public String registrarMecanico(String nombre, String telefono, String salario){
        String resultado = "";

        Mecanico mecanicoEncontrado = buscarMecanico(nombre);
        if(mecanicoEncontrado != null) {
            resultado = "Ya se encuentra registrado";
        }else{
            Mecanico mecanico = new Mecanico(nombre, telefono, salario,this);
            listaMecanicos.add(mecanico);
            resultado = "Mecanico Agregado";
        }

        return resultado;

    }
    public Mecanico buscarMecanico (String nombre){
        Mecanico mecanicoAux = null;
        for ( Mecanico aux : listaMecanicos){
            if (aux.getNombre().equalsIgnoreCase(nombre)){
                return aux;
            }
        }
        return mecanicoAux;
    }
    public String actualizarMecanico(String nombre, String telefono,String salario){
        String resultado = "";
        Mecanico mecanicoEncontrado = buscarMecanico(nombre);
        if(mecanicoEncontrado == null) {
            resultado = "No existe ese cliente";
        }else{
            mecanicoEncontrado.setNombre(nombre);
            mecanicoEncontrado.setTelefono(telefono);
            mecanicoEncontrado.setSalario(salario);

            resultado = "Mecanico actualizado";
        }

        return resultado;
    }
    public ArrayList<Bicicleta> buscarBicicletasArregladasPorMecanico(String nombreMecanico) {
        ArrayList<Bicicleta> bicicletasArregladas = new ArrayList<>();

        for (Orden orden : listaOrdenes) {
            for (Mecanico mecanico : orden.getListaMecanicos()) {
                if (mecanico.getNombre().equalsIgnoreCase(nombreMecanico)) {
                    for (Bicicleta bicicleta : listaBicicletas) {
                        if (bicicleta.getListaOrdenesServicio().contains(orden)) {
                            bicicletasArregladas.add(bicicleta);
                        }
                    }
                    break;
                }
            }
        }
        return bicicletasArregladas;
    }
    //CRUD Bicicleta
    public String registrarBicicleta(String marca, String serial, String color){
        String resultado = "";

        Bicicleta bicicletaEncontrado = buscarBicicleta(serial);
        if(bicicletaEncontrado != null) {
            resultado = "Ya se encuentra registrado";
        }else{
            Bicicleta bicicleta = new Bicicleta(marca,serial,color,this);
            listaBicicletas.add(bicicleta);
            resultado = "Bicicleta Agregado";
        }

        return resultado;

    }
    public Bicicleta buscarBicicleta (String serial){
        Bicicleta bicicletaAux = null;
        for ( Bicicleta aux : listaBicicletas){
            if (aux.getSerial().equalsIgnoreCase(serial)){
                return aux;
            }
        }
        return bicicletaAux;
    }
    public String actualizarBicicleta(String marca, String serial, String color){
        String resultado = "";
       Bicicleta bicicletaEncontrado = buscarBicicleta(serial);
        if(bicicletaEncontrado == null) {
            resultado = "No existe esa bicicleta";
        }else{
            bicicletaEncontrado.setMarca(marca);
            bicicletaEncontrado.setSerial(serial);
            bicicletaEncontrado.setColor(color);

            resultado = "Bicicleta actualizada";
        }

        return resultado;

    }

    //CRUD ORDEN
    public String registrarOrden(String codigo, String descripcion, LocalDate fechaIngreso, LocalDate fechaSalida, double costo){
        String resultado = "";

        Orden ordenEncontrado = buscarOrden(codigo);
        if(ordenEncontrado != null) {
            resultado = "Ya se encuentra registrado";
        }else{
            Orden orden = new Orden(codigo, descripcion,fechaIngreso,fechaSalida,costo,this);
            listaOrdenes.add(orden);
            resultado = "Orden Agregada";
        }

        return resultado;

    }
    public Orden buscarOrden (String codigo){
        Orden ordenAux = null;
        for ( Orden aux : listaOrdenes){
            if (aux.getCodigo().equalsIgnoreCase(codigo)){
                return aux;
            }
        }
        return ordenAux;
    }
    public String actualizarOrden(String codigo, String descripcion, LocalDate fechaIngreso, LocalDate fechaSalida, double costo){
        String resultado = "";
        Orden ordenEncontrado = buscarOrden(codigo);
        if(ordenEncontrado == null) {
            resultado = "No existe esa orden";
        }else{
            ordenEncontrado.setCodigo(codigo);
            ordenEncontrado.setDescripcion(descripcion);
            ordenEncontrado.setFechaIngreso(fechaIngreso);
            ordenEncontrado.setFechaSalida(fechaSalida);
            ordenEncontrado.setCosto(costo);
            resultado = "Orden actualizada";
        }

        return resultado;

    }

    //CRUD REPUESTO
    public String registrarRepuesto(String nombre, double costo, int cantidad){
        String resultado = "";

        Repuesto repuestoEncontrado = buscarRepuesto(nombre);
        if(repuestoEncontrado != null) {
            resultado = "Ya se encuentra registrado";
        }else{
            Repuesto repuesto = new Repuesto(nombre,costo,cantidad,this);
            listaRepuestos.add(repuesto);
            resultado = "Repuesto Agregado";
        }

        return resultado;

    }
    public Repuesto buscarRepuesto (String nombre){
        Repuesto repuestoAux = null;
        for ( Repuesto aux : listaRepuestos){
            if (aux.getNombre().equalsIgnoreCase(nombre)){
                return aux;
            }
        }
        return repuestoAux;
    }
    public String actualizarRepuesto(String nombre, double costo, int cantidad){
        String resultado = "";
        Repuesto repuestoEncontrado = buscarRepuesto(nombre);
        if(repuestoEncontrado == null) {
            resultado = "No existe ese repuesto";
        }else{
           repuestoEncontrado.setNombre(nombre);
           repuestoEncontrado.setCosto(costo);
           repuestoEncontrado.setCantidad(cantidad);
            resultado = "Repuesto actualizado";
        }

        return resultado;

    }
}
