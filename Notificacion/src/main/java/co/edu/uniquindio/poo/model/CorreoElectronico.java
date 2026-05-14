package co.edu.uniquindio.poo.model;

import javax.swing.*;
import java.lang.reflect.AnnotatedType;

public class CorreoElectronico extends Notificacion {
    private String email;

    public CorreoElectronico(String codigo, String email) {
        super(codigo);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Estado enviarNotificacion (Noticia noticia){
        JOptionPane.showMessageDialog(null, "Enviando notificacion a correo electronico: " + email);
        return Estado.ENVIADA;
    }
}
