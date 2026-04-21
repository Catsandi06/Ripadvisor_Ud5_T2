package net.salesianos;

/**
 * Clase que representa un restaurante en el sistema de ranking RipAdvisor.
 * Almacena la informacion de restaurantes incluyendo nombre, direccion,
 * tipo de cocina y puntuacion para el ranking.
 */
public class Restaurante {
    private String nombre;
    private String direccion;
    private String tipoCocina;
    private int puntuacion;
    private String valoracion;

    public Restaurante() {
    }

    public Restaurante(String nombre, String direccion, String tipoCocina, int puntuacion, String valoracion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoCocina = tipoCocina;
        this.puntuacion = puntuacion;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoCocina() {
        return tipoCocina;
    }

    public void setTipoCocina(String tipoCocina) {
        this.tipoCocina = tipoCocina;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Restaurante: " + nombre + "\n" +
               "Direccion: " + direccion + "\n" +
               "Tipo de cocina: " + tipoCocina + "\n" +
               "Puntuacion: " + puntuacion + "/5" + "\n" +
               "Valoracion: " + valoracion;
    }

    public boolean tienePuntuacionAlta() {
        return puntuacion >= 4;
    }
}