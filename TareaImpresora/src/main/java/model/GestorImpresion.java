package model;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class GestorImpresion implements CentroImpresion {
    private Queue<Solicitud> colaSolicitudes;
    private List<Impresora> listaImpresoras;

    public GestorImpresion() {
        this.colaSolicitudes = new LinkedList<>();
        this.listaImpresoras = new ArrayList<>();
    }

    public Queue<Solicitud> getColaSolicitudes() {
        return colaSolicitudes;
    }

    public void setColaSolicitudes(Queue<Solicitud> colaSolicitudes) {
        this.colaSolicitudes = colaSolicitudes;
    }

    public List<Impresora> getListaImpresoras() {
        return listaImpresoras;
    }

    public void setListaImpresoras(List<Impresora> listaImpresoras) {
        this.listaImpresoras = listaImpresoras;
    }

    @Override
    public String toString() {
        return "GestorImpresion{" +
                "colaSolicitudes=" + colaSolicitudes +
                ", listaImpresoras=" + listaImpresoras +
                '}';
    }

    @Override
    public void recibirSolicitud(Solicitud solicitud) {
        colaSolicitudes.add(solicitud);
        JOptionPane.showMessageDialog(null, "Solicitud agregada a la cola.\nDocumento: " + solicitud.getDocumento().getTitulo());
    }

    @Override
    public void agregarImpresora(Impresora impresora) {
        listaImpresoras.add(impresora);
    }

    @Override
    public void procesarSiguiente() {
        if (colaSolicitudes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay solicitudes pendientes en la cola.");
            return;
        }

        Solicitud solicitudActual = colaSolicitudes.peek();
        TipoDocumento tipoRequerido = solicitudActual.getDocumento().getTipo();

        Impresora impresoraDisponible = null;

        for (Impresora imp : listaImpresoras) {
            if (imp.getEstado() == Estado.CONECTADA) {

                if (tipoRequerido == TipoDocumento.MODELO_3D && imp instanceof Impresora3D) {
                    impresoraDisponible = imp;
                    break;
                }
                else if (tipoRequerido == TipoDocumento.TEXTO_2D && (imp instanceof Cartucho || imp instanceof Laser)) {
                    impresoraDisponible = imp;
                    break;
                }
            }
        }

        if (impresoraDisponible != null) {
            colaSolicitudes.poll();
            impresoraDisponible.imprimir(solicitudActual.getDocumento());
        } else {
            JOptionPane.showMessageDialog(null, "Aviso: No hay impresoras compatibles conectadas para el documento ["
                    + solicitudActual.getDocumento().getTitulo()
                    + "].\nLa solicitud se quedara en espera en la cola.");
        }
    }
}