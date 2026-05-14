package co.edu.uniquindio.poo.model;

import javax.management.Notification;
import java.util.ArrayList;

public class Universidad {
    private String nombre;
    private ArrayList<Noticia> listaNoticias;
    private ArrayList<Notificacion> listaNotificaciones;
    private ArrayList<INotificacion> listaINotificaciones;

    public Universidad (String nombre){
        this.nombre = nombre;
        this.listaNoticias = new ArrayList<>();
        this.listaNotificaciones = new ArrayList<>();
        this.listaINotificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Noticia> getListaNoticias() {
        return listaNoticias;
    }

    public void setListaNoticias(ArrayList<Noticia> listaNoticias) {
        this.listaNoticias = listaNoticias;
    }

    public ArrayList<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }

    public void setListaNotificaciones(ArrayList<Notificacion> listaNotificaciones) {
        this.listaNotificaciones = listaNotificaciones;
    }

    public ArrayList<INotificacion> getListaINotificaciones() {
        return listaINotificaciones;
    }

    public void setListaINotificaciones(ArrayList<INotificacion> listaINotificaciones) {
        this.listaINotificaciones = listaINotificaciones;
    }

    @Override
    public String toString() {
        return "Universidad{" +
                "nombre='" + nombre + '\'' +
                ", listaNoticias=" + listaNoticias +
                ", listaNotificaciones=" + listaNotificaciones +
                ", listaINotificaciones=" + listaINotificaciones +
                '}';
    }
    public String agregarNotificacion (Notificacion nueva){
        listaNotificaciones.add(nueva);
        return "Notificacion agregada correctamente";
    }
    public String agregarNoticia (Noticia nueva){
        listaNoticias.add(nueva);
        return "Noticia Agregada correctamente";
    }
}
