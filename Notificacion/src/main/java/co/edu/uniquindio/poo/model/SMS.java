package co.edu.uniquindio.poo.model;

import javax.swing.*;

public class SMS extends Notificacion {
    private int nTelefono;

    public SMS(String codigo, int nTelefono) {
        super(codigo);
        this.nTelefono = nTelefono;
    }

    public int getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(int nTelefono) {
        this.nTelefono = nTelefono;
    }

    @Override
    public Estado enviarNotificacion(Noticia noticia){
        JOptionPane.showMessageDialog(null, "Enviando notificacion via SMS a: " + nTelefono);
        return Estado.ENVIADA;
    }
}
