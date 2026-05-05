package model;

import javax.swing.JOptionPane;

public class Cartucho extends Impresora {
    public Cartucho(String marca, Estado estado) {
        super(marca, estado);
    }

    @Override
    public void imprimir(Documento documento) {
        JOptionPane.showMessageDialog(null, "Imprimiendo en Cartucho " + marca + "\nTitulo: " + documento.getTitulo() + "\nContenido: " + documento.getContenido());
    }
}