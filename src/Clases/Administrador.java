package Clases;

/**
 * Esta clase va a servir para simular el sistema de autenticacion.
 * Al momento de ejecutar el programa se va a crear un objeto de tipo 
 * Administrador con el nombre de usuario y contraseña.
 * @author Sergio Sánchez
 */
public class Administrador {
    private final String nombreDeUsuario = "admin";
    private final char[] contrasenia = {'1', '2', '3', '4'};
    
    /**
     * Crea que el administrador simulando tener los datos para hacer la 
     * autenticacion.
     */
    public Administrador() {
    }
    
    /**
     * Regresa el nombre del usuario
     * @return el valor de nombreDeUsuario
     */
    public String getNombreUsuario() {
        return nombreDeUsuario;
    }
    
    /**
     * Regresa la contrasena
     * @return el valor de contrasena
     */
    public char[] getContrasenia() {
        return contrasenia;
    }
}
