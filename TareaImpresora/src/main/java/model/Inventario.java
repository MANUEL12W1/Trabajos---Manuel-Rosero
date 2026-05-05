package model;

public class Inventario {
    public void solicitarImpresion(Documento documento, CentroImpresion centro, Usuario usuario) {
        Solicitud solicitud = new Solicitud(2, documento, usuario);
        centro.recibirSolicitud(solicitud);
    }
}