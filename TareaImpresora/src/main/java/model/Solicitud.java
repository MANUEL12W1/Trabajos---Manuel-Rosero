package model;

import java.time.LocalDateTime;

public class Solicitud {
    private LocalDateTime fechaHora;
    private int orden;
    private Documento documento;
    private Usuario usuario;

    public Solicitud(int orden, Documento documento, Usuario usuario) {
        this.fechaHora = LocalDateTime.now();
        this.orden = orden;
        this.documento = documento;
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "fechaHora=" + fechaHora +
                ", orden=" + orden +
                ", documento=" + documento +
                ", usuario=" + usuario +
                '}';
    }
}
