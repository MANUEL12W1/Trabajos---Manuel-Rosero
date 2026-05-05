package model;

public class Pedido {
    private int idPedido;

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido=" + idPedido +
                '}';
    }

    public void solicitarImpresion(Documento documento, CentroImpresion centro, Usuario usuario) {
        Solicitud solicitud = new Solicitud(3, documento, usuario);
        centro.recibirSolicitud(solicitud);
    }
}