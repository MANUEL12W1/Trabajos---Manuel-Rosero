package co.edu.uniquindio.poo.model;

import javax.swing.*;

public class DispositivoMovil extends Notificacion{
    private String idMovil;

    public DispositivoMovil(String codigo, String idMovil) {
        super(codigo);
        this.idMovil = idMovil;
    }

    public String getIdMovil() {
        return idMovil;
    }

    public void setIdMovil(String idMovil) {
        this.idMovil = idMovil;
    }
    public Estado enviarNotificacion (Noticia noticia){
        JOptionPane.showMessageDialog(null, "Enviando notificacion a movil con id " + idMovil);
        return Estado.ENVIADA;
    }
}
