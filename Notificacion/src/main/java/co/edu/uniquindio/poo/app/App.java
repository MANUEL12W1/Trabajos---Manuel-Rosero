package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        Universidad universidad = new Universidad("Universidad del Quindio");
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la noticia:");
        String desc = JOptionPane.showInputDialog("Ingrese la descripción:");
        Noticia noticia = new Noticia(titulo, desc);
        universidad.agregarNoticia(noticia);

        boolean continuar = true;
        while (continuar) {
            String menu = "Seleccione un medio para agregar a la lista de envío:\n"
                    + "1. Correo Electrónico\n"
                    + "2. SMS\n"
                    + "3. Notificación Push\n"
                    + "4. Enviar";

            String seleccion = JOptionPane.showInputDialog(null, menu);

            if (seleccion == null) {
                continuar = false;
                break;
            }

            try {
                int opcion = Integer.parseInt(seleccion);

                switch (opcion) {
                    case 1:
                        String email = JOptionPane.showInputDialog("Ingrese el correo electrónico:");
                        String codigo = JOptionPane.showInputDialog("Ingrese el codigo:");
                        universidad.agregarNotificacion(new CorreoElectronico(codigo, email));
                        JOptionPane.showMessageDialog(null, "Correo agregado");
                        break;

                    case 2:
                        String telefono = JOptionPane.showInputDialog("Ingrese el número de celular:");
                        int tel = Integer.parseInt(telefono);
                        String codigoSMS = JOptionPane.showInputDialog("Ingrese el codigo:");
                        universidad.agregarNotificacion(new SMS(codigoSMS, tel));
                        JOptionPane.showMessageDialog(null, "SMS agregado");
                        break;

                    case 3:
                        String idMovil = JOptionPane.showInputDialog("Ingrese el ID del dispositivo móvil:");
                        String codigoPush = JOptionPane.showInputDialog("Ingrese el codigo:");
                        universidad.agregarNotificacion(new DispositivoMovil(codigoPush,idMovil));
                        JOptionPane.showMessageDialog(null, "Dispositivo móvil agregado con éxito");
                        break;

                    case 4:
                        continuar = false;
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Ingrese un número del 1 al 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
            }
        }

        if (universidad.getListaNotificaciones().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se seleccionó ningún medio de envío");
        } else {
            StringBuilder reporte = new StringBuilder("Reporte de Envío\n");
            reporte.append("Noticia: ").append(noticia.getTitulo()).append("\n");
            reporte.append("Estado inicial: ").append(noticia.getEstado()).append("\n\n");

            for (Notificacion medio : universidad.getListaNotificaciones()) {
                Estado resultado = medio.enviarNotificacion(noticia);
                noticia.setEstado(resultado);

                reporte.append("- Enviado vía ").append(medio.getClass().getSimpleName())
                        .append(" Estado: ").append(resultado).append("\n");
            }

            reporte.append("\nEstado final de la noticia: ").append(noticia.getEstado());
            JOptionPane.showMessageDialog(null, reporte.toString(), "Resumen Final", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
