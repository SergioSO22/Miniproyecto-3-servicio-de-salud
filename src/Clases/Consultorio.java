package Clases;

/**
 * Clase que modela un consultorio mediante los atributos de nombre y disponibilidad.
 * @author Sergio Sánchez
 */
public class Consultorio {
    private String nombre;
    private boolean disponibilidad;
    
    /**
     * Crea un consultorio y le asigna un nombre y disponibilidad.
     * @param nombre es el valor del atributo nombre.
     * @param disponibilidad es el valor del atributo disponibilidad.
     */
    public Consultorio(String nombre, boolean disponibilidad) {
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
    }
    
    /**
     * Retorna el nombre del consultorio
     * @return el valor de nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Actualiza el nombre del consultorio
     * @param nombre es el valor a asignar al atributo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Regresa si el consultorio esta disponible.
     * @return valor de disponibilidad.
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    
    /**
     * Actualiza la disponibilidad del consultorio
     * @param disponibilidad es el valor del atributo disponibilidad.
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public String toString() {
        return "Consultorio{" + "nombre=" + nombre + ", disponibilidad=" + disponibilidad + '}';
    }
    
}
