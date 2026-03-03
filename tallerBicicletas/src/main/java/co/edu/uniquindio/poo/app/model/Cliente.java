package co.edu.uniquindio.poo.app.model;

public class Cliente {
    private String nombre;
    private String telefono;
    private String correo;
    private int numeroBicicletasRegistradas;

    // Relaciones

    private Bicicleta bicicleta;

    // Constructor
    public Cliente (String nombre, String telefono, String correo, int numeroBicicletasRegistradas){
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.numeroBicicletasRegistradas = numeroBicicletasRegistradas;

    }

    //Get y Set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroBicicletasRegistradas() {
        return numeroBicicletasRegistradas;
    }

    public void setNumeroBicicletasRegistradas(int numeroBicicletasRegistradas) {
        this.numeroBicicletasRegistradas = numeroBicicletasRegistradas;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }
    // Metodos

    // toString

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", numeroBicicletasRegistradas=" + numeroBicicletasRegistradas +
                ", bicicleta=" + bicicleta +
                '}';
    }
}
