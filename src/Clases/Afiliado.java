package Clases;

/**
 * Un objeto de clase Afiliado tiene los atributos para almacenar el nombre,
 * el dni, el id y el estado, el cual es activo para true e inactivo para false.
 * @author Sergio Sánchez
 */
public class Afiliado extends Persona{
    private int idAfiliado;
    private boolean Estado;
    public static int cantidadDeAfiliados;
    
    /**
     * Crea un afiliado y posiciona los atributos nombreDelAfiliado y dniAfiliado, 
     * ademas de posicionar el estado el sistema.
     * @param nombreDelAfiliado es el vn true, le asigna el id de afiliado acorde
     * a la cantidad de afiliados en ealor a asignar al atributo nombreAfiliado
     * @param dniAfiliado es el valor a asignar al atributo dniAfiliado
     */
    public Afiliado(String nombreDelAfiliado, int dniAfiliado){
        super(nombreDelAfiliado, dniAfiliado);
        Estado = true;
        cantidadDeAfiliados++;
        idAfiliado = cantidadDeAfiliados;
    }
    
    /**
     * Retorna el id del afiliado
     * @return el valor de idAfiliado
     */
    public int getIdAfiliado() {
        return idAfiliado;
    }
    
    /**
     * Asigna el valor del parametro al atributo idAfiliado
     * @param idAfiliado el valor a asignarle al atributo idAfiliado
     */
    public void setIdAfiliado(int idAfiliado) {
        this.idAfiliado = idAfiliado;
    }
    
    /**
     * Retorna el estado del afiliado, false para inactivo, true para activo
     * @return el valor de estado
     */
    public boolean isEstado() {
        return Estado;
    }
    
    /**
     * Asigna el valor del parametro estado al atributo estado
     * @param estado el valor a asignarle al atributo estado
     */
    public void setEstado(boolean estado) {
        this.Estado = estado;
    }
    
    /**
     * Retorna la cantidad de Afiliados que hay
     * @return el valor de cantidadAfiliados
     */
    public static int getCantidadAfiliados() {
        return cantidadDeAfiliados;
    }
    
    /**
     * Retorna los datos del afiliado, su nombre, dni y id.
     * @return el string con los datos del afiliado.
     */
    @Override
    public String toString() {
        return "Afiliado{" + "nombre=" + this.getNombre() + ", dni=" + this.getDni() + ", idAfiliado=" + idAfiliado + ", estado=" + Estado + '}';
    }
}
