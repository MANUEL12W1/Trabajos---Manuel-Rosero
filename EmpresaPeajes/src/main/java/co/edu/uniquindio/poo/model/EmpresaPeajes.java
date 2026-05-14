package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmpresaPeajes {
    private String nombre;
    private List<Persona> listaPersonas;
    private List<ICobrador> listaCobradores;
    private List<Vehiculo> listaVehiculos;
    private List<EstacionPeaje> listaEstaciones;

    public EmpresaPeajes(String nombre) {
        this.nombre = nombre;
        this.listaPersonas = new ArrayList<>();
        this.listaCobradores = new ArrayList<>();
        this.listaVehiculos = new ArrayList<>();
        this.listaEstaciones = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }
    public List<Camion> obtenerCamionesPesadosYFrecuentes() {
        List<Camion> camionesFiltrados = new ArrayList<>();
        for (Vehiculo vehiculoActual : listaVehiculos) {
            if (vehiculoActual instanceof Camion) {
                Camion camionActual = (Camion) vehiculoActual;
                if (camionActual.getCapacidadCarga() > 10.0 && camionActual.getNumeroPeajes() > 5) {
                    camionesFiltrados.add(camionActual);
                }
            }
        }
        return camionesFiltrados;
    }

}