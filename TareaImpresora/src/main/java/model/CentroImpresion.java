package model;

public interface CentroImpresion {
    void recibirSolicitud(Solicitud solicitud);
    void procesarSiguiente();
    void agregarImpresora(Impresora impresora);
}