package model;

import javax.swing.JOptionPane;

public class Laser extends Impresora {
    public Laser(String marca, Estado estado) {
        super(marca, estado);
    }

    @Override
    public void imprimir(Documento documento) {
        JOptionPane.showMessageDialog(null, "Imprimiendo en Laser " + marca + "\nTitulo: " + documento.getTitulo() + "\nContenido: " + documento.getContenido());
    }
}
