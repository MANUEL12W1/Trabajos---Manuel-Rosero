package co.edu.uniquindio.poo.model;

public abstract  class Notificacion  implements  INotificacion {
    private String codigo;

    public Notificacion(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Notificacion{" +
                "codigo='" + codigo + '\'' +
                '}';
    }
}
