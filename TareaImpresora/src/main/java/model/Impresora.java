package model;
public abstract class Impresora {
    protected String marca;
    protected Estado estado;

    public Impresora(String marca, Estado estado) {
        this.marca = marca;
        this.estado = estado;
    }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public String getMarca() { return marca; }


    public abstract void imprimir(Documento documento);
}