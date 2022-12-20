package Clases;

/**
 * 
 * Clase que modela un especialista medico con un unico atributo, su especialidad.
 * @author Sergio Sánchez
 */
public class Especialista extends Medico {
    
    private String especialidad;
    
    /**
     * Crea el especialista que hereda de medico, asignando el valor del 
     * parametro de especialidad al atributo especialidad.
     * @param nombreDelMedico es el valor que se asigna a nombrDelMedico en el constructor de super
     * @param dniMedico es el valor asignado a dniMedico en el constructor
     * @param especialidad es el valor que  asignado al atributo especialidad
     */
    public Especialista(String nombreDelMedico, int dniMedico, String especialidad) {
        super(nombreDelMedico, dniMedico);
        this.especialidad = especialidad;
    }
    
    /**
     * Retorna la especialidad del especialista
     * @return el valor de especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }
    
    /**
     * Asigna el valor del parametro al atributo especialidad
     * @param especialidad es el valor que se asigna al atributo especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Especialista{" + "nombre=" + getNombre() + ", dni=" + getDni() + ", idMedico=" + getIdMedico() + ", estado=" + isEstado() + ", especialidad=" + especialidad + '}';
    }
    
    
}
