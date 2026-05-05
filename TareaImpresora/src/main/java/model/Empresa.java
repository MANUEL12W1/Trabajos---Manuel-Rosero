package model;

public class Empresa {
    private String nombre;
    private CentroImpresion centroImpresion;
    private Nomina nomina;
    private Inventario inventario;
    private Pedido Pedido;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.centroImpresion = new GestorImpresion();
        this.nomina = new Nomina();
        this.inventario = new Inventario();
        this.Pedido = new Pedido(100);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CentroImpresion getCentroImpresion() {
        return centroImpresion;
    }

    public void setCentroImpresion(CentroImpresion centroImpresion) {
        this.centroImpresion = centroImpresion;
    }

    public Nomina getNomina() {
        return nomina;
    }

    public void setNomina(Nomina nomina) {
        this.nomina = nomina;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Pedido getPedido() {
        return Pedido;
    }

    public void setPedido(Pedido pedido) {
        Pedido = pedido;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", centroImpresion=" + centroImpresion +
                ", nomina=" + nomina +
                ", inventario=" + inventario +
                ", Pedido=" + Pedido +
                '}';
    }
}