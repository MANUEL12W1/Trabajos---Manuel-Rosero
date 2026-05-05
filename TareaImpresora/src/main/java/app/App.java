package app;

import model.*;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        String nombreEmpresa = JOptionPane.showInputDialog("Ingrese el nombre de la Empresa:");
        Empresa miEmpresa = new Empresa(nombreEmpresa);
        CentroImpresion centro = miEmpresa.getCentroImpresion();

        boolean salir = false;
        while (!salir) {
            String menu = "SISTEMA DE IMPRESION - " + nombreEmpresa + "\n\n"
                    + "1. Agregar nueva impresora\n"
                    + "2. Enviar impresion desde Nomina\n"
                    + "3. Enviar impresion desde Inventario\n"
                    + "4. Enviar impresion desde Pedidos\n"
                    + "5. Procesar siguiente en la cola\n"
                    + "6. Salir\n\n"
                    + "Ingrese el numero de la opcion:";

            String input = JOptionPane.showInputDialog(null, menu);

            if (input == null) {
                salir = true;
                continue;
            }

            int opcion = 0;
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un numero valido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    String marca = JOptionPane.showInputDialog("Ingrese la marca de la impresora:");

                    String menuTipo = "Seleccione el tipo:\n1. Cartucho\n2. Laser\n3. 3D";
                    String tipoStr = JOptionPane.showInputDialog(menuTipo);

                    String menuEstado = "Seleccione el estado:\n1. Conectada\n2. Desconectada";
                    String estadoStr = JOptionPane.showInputDialog(menuEstado);

                    Estado estado = (estadoStr != null && estadoStr.equals("1")) ? Estado.CONECTADA : Estado.DESCONECTADA;
                    Impresora nuevaImpresora = null;

                    if (tipoStr != null) {
                        if (tipoStr.equals("1")) {
                            nuevaImpresora = new Cartucho(marca, estado);
                        } else if (tipoStr.equals("2")) {
                            nuevaImpresora = new Laser(marca, estado);
                        } else if (tipoStr.equals("3")) {
                            nuevaImpresora = new Impresora3D(marca, estado);
                        }
                    }

                    if (nuevaImpresora != null) {
                        centro.agregarImpresora(nuevaImpresora);
                        JOptionPane.showMessageDialog(null, "Impresora agregada correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al crear la impresora. Opcion no valida.");
                    }
                    break;

                case 2:
                case 3:
                case 4:
                    String nombreUsuario = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");
                    String idUsuario = JOptionPane.showInputDialog("Ingrese el ID del usuario:");
                    Usuario usuario = new Usuario(nombreUsuario, idUsuario);

                    String tituloDoc = JOptionPane.showInputDialog("Ingrese el titulo del documento:");
                    String contenidoDoc = JOptionPane.showInputDialog("Ingrese el contenido del documento:");

                    String menuTipoDoc = "Seleccione el tipo de documento:\n1. Texto normal (2D)\n2. Modelo (3D)";
                    String tipoDocStr = JOptionPane.showInputDialog(menuTipoDoc);

                    TipoDocumento tipoArchivo = (tipoDocStr != null && tipoDocStr.equals("2")) ? TipoDocumento.MODELO_3D : TipoDocumento.TEXTO_2D;

                    Documento doc = new Documento(tituloDoc, contenidoDoc, tipoArchivo);

                    if (opcion == 2) {
                        miEmpresa.getNomina().solicitarImpresion(doc, centro, usuario);
                    } else if (opcion == 3) {
                        miEmpresa.getInventario().solicitarImpresion(doc, centro, usuario);
                    } else {
                        miEmpresa.getPedido().solicitarImpresion(doc, centro, usuario);
                    }
                    break;

                case 5:
                    centro.procesarSiguiente();
                    break;
                case 6:
                    salir = true;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion no reconocida. Intente de nuevo.");
            }
        }
    }
}