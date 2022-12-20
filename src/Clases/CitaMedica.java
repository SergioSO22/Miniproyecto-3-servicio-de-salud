package Clases;

import java.util.Calendar;

/**
 * Clase creada con los datos necesarios para una cita medica
 * @author Sergio Sánchez
 */
public class CitaMedica {
    private Afiliado afiliado;
    private String servicioMedico;
    private Medico medico;
    private Consultorio consultorio;
    private Calendar fechaYHora;
    
    /**
     * Crea una cita asignandole los respectivos valores a cada atributo.
     * @param afiliado es el afiliado que pidio la cita
     * @param servicioMedico es el servicio requerido por el afiliado
     * @param medico es el medico asignado a la cita
     * @param consultorio es el sitio donde se dara la atención medica.
     * @param fechaYHora es la fecha y la hora en la que se dara la cita.
     */
    public CitaMedica(Afiliado afiliado, String servicioMedico, Medico medico, Consultorio consultorio, Calendar fechaYHora) {
        this.afiliado = afiliado;
        this.servicioMedico = servicioMedico;
        this.medico = medico;
        this.consultorio = consultorio;
        this.fechaYHora = fechaYHora;
    }
    
    /**
     * Regresa el afiliado asignado a la cita.
     * @return el valor de afiliado
     */
    public Afiliado getAfiliado() {
        return afiliado;
    }
    
    /**
     * Regresa el servicio medico estipulado en la cita
     * @return el valor de servicioMedico
     */
    public String getServicioMedico() {
        return servicioMedico;
    }
    
    /**
     * Regresa el medico asignado a la cita.
     * @return valor del medico.
     */
    public Medico getMedico() {
        return medico;
    }
    
    /**
     * Regresa el consultorio asignado a la cita.
     * @return valor del consultorio.
     */
    public Consultorio getConsultorio() {
        return consultorio;
    }
    
    /**
     * Regresa la fecha y la hora de la cita.
     * @return valor de fechaYHora
     */
    public Calendar getFechaYHora() {
        return fechaYHora;
    }

    @Override
    public String toString() {
        return "CitaMedica\n" + afiliado + "\nservicio = " + servicioMedico + "\n" + medico + "\n" + consultorio + "\nfechaYHora = " + fechaYHora.getTime();
    }
    
    /**
     * modifica la fecha de la cita.
     * @param fechaYHora es el nuevo valor que debe tener el atributo fechaYHora
     */
    public void setFechaYHora(Calendar fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
    
}
