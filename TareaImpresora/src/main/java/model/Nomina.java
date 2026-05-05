package model;

public class Nomina {
    public void solicitarImpresion(Documento documento, CentroImpresion centro, Usuario usuario) {
        Solicitud solicitud = new Solicitud(1, documento, usuario);
        centro.recibirSolicitud(solicitud);
    }
}