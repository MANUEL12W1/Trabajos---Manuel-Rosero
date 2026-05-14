package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conductor extends Persona {
    private final List<Vehiculo> vehiculosAsignados; // Lista de vehículos del conductor

    public Conductor(String nombres, String apellidos, LocalDate fechaNacimiento, String numeroDocumento) {
        super(nombres, apellidos, fechaNacimiento, numeroDocumento);
        this.vehiculosAsignados = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculosAsignados.add(vehiculo);
    }

    public List<Vehiculo> getVehiculosAsignados() {
        return vehiculosAsignados;
    }
}