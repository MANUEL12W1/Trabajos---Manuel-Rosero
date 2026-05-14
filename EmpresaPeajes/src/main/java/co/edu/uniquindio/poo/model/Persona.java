package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public abstract class Persona {
    // Declaramos los atributos final para garantizar la inmutabilidad (auditoría)
    protected final String nombres;
    protected final String apellidos;
    protected final LocalDate fechaNacimiento;
    protected final String numeroDocumento;

    public Persona(String nombres, String apellidos, LocalDate fechaNacimiento, String numeroDocumento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public String getNumeroDocumento() { return numeroDocumento; }
}