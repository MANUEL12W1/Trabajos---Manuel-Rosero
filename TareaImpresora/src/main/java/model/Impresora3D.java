package model;

import javax.swing.JOptionPane;

public class Impresora3D extends Impresora {
    public Impresora3D(String marca, Estado estado) {
        super(marca, estado);
    }

    @Override
    public void imprimir(Documento documento) {
        JOptionPane.showMessageDialog(null, "Imprimiendo en 3D " + marca + "\nModelo: " + documento.getTitulo() + "\nDetalles: " + documento.getContenido());
    }
}
