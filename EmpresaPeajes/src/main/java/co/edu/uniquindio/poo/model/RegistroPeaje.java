package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.time.LocalTime;

// Se agregan el Vehículo y el Cobrador como lo pide el requerimiento
public record RegistroPeaje(Vehiculo vehiculo, ICobrador cobrador, double valor, LocalDate fecha, LocalTime hora) {
}