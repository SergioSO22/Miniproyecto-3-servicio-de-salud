package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * GestionDeMedicos contiene solo un atributo de tipo Map, en el cual se 
 * almacenan y manejan los objetos de tipo Medico.
 *
 * @author Sergio Sánchez
 */
public class GestionDeMedicos implements IGestionDeDatos {

    private Map<Integer, Medico> listaDeMedicos;

    /**
     * Se activa el atributo listaDeMedicos como un HashMap.
     */
    public GestionDeMedicos() {

        listaDeMedicos = new HashMap<>();
    }

    /**
     * Crea la ventana donde se obtienen los datos para crear un Medico y lo
     * agrega a listaDeMedicos.
     */
    @Override
    public void agregar() {

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del medico que quiere agregar");
        String dni = JOptionPane.showInputDialog("ingrese el dni del medico que quiere agregar");
        int intDni = Integer.parseInt(dni);
        int especialista = JOptionPane.showConfirmDialog(null, "¿Es un especialista?");
        if (especialista == 0) {
            String especialidad = JOptionPane.showInputDialog("¿En que se especializa el medico?");
            Especialista medicoEspecialista = new Especialista(nombre, intDni, especialidad);
            listaDeMedicos.put(medicoEspecialista.getIdMedico(), medicoEspecialista);
        } else {
            Medico medico = new Medico(nombre, intDni);
            listaDeMedicos.put(medico.getIdMedico(), medico);
        }

    }

    /**
     * Actualiza los valores para nombreDelMedico del medico con el id que se haya
     * suministrado.
     */
    @Override
    public void actualizar() {

        String id = JOptionPane.showInputDialog("ingrese el id del medico a actualizar");
        int intId = Integer.parseInt(id);
        if (listaDeMedicos.containsKey(intId)) {
            String nombre = JOptionPane.showInputDialog("ingrese el nuevo nombre del medico");
            (listaDeMedicos.get(intId)).setNombre(nombre);
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en la lista de medicos");
        }
    }

    /**
     * Retorna un String con todos los medicos contenidos en listaDeMedicos
     * @return los datos de cada medico en el atributo listaMedicos
     */
    @Override
    public String listar() {
        
        String cadena = "---------- Medicos ----------\n";
        for (int clave : listaDeMedicos.keySet()) {
            var medico = listaDeMedicos.get(clave);
            cadena += medico + "\n";
        }
        return cadena;
    }

    /**
     * Cambia el estado del atributo estado del medico a false, y lo elimina de
     * listaMedicos, con lo cual se entiende que el medico esta inactivo.
     */
    @Override
    public void eliminar() {

        String id = JOptionPane.showInputDialog("ingrese el id del medico a eliminar");
        int intId = Integer.parseInt(id);

        if (listaDeMedicos.containsKey(intId)) {
            (listaDeMedicos.get(intId)).setEstado(false);
            listaDeMedicos.remove(intId);
            JOptionPane.showMessageDialog(null, "medico eliminido con exito del registro de medicos");
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en la lista de medicos o el id ingresado es incorrecto");
        }
    }

    /**
     * Genera el archivo csv con los datos basicos de los medicos, separados por
     * punto y coma (;) para la persistencia de los datos. el formato del
     * archivo es: nombre - dni - id - estado
     */
    @Override
    public void generarCSV() {

        String archivoCsv = "";
        for (int clave : listaDeMedicos.keySet()) {
            var medico = listaDeMedicos.get(clave);
            if (medico instanceof Especialista) {
                archivoCsv += medico.getNombre() + ";" + medico.getDni() + ";" + medico.getIdMedico() + ";" + medico.isEstado() + ";" + ((Especialista) medico).getEspecialidad() + ";" + "\n";
            } else {
                archivoCsv += medico.getNombre() + ";" + medico.getDni() + ";" + medico.getIdMedico() + ";" + medico.isEstado() + ";" + "\n";
            }
        }
        try {
            /**
             * Metodo para la persistencia de datos en forma de archivo binario:
             */
            FileOutputStream os = new FileOutputStream(new File("src/persistencia/medicos_csv.txt"));
            System.out.println("Empezando el copiado...");
            os.write(archivoCsv.getBytes());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionDeMedicos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionDeMedicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Copiado con exito");
    }
    
    /**
     * El metodo tiene como funcion restaurar los datos llenando el atributo
     * listaMedicos con los datos almacenados en medicos_csv.txt
     */
    @Override
    public void restaurarDatos() {

        File archivo = new File("src/persistencia/medicos_csv.txt");
        StringTokenizer st;
        String cadenaDatos = "";
        try {
            FileReader fr = new FileReader(archivo);
            try ( BufferedReader br = new BufferedReader(fr)) {
                
                String cadena;
                while ((cadena = br.readLine()) != null) {
                    
                    cadenaDatos += cadena;
                    st = new StringTokenizer(cadena, ";");
                    if (st.countTokens() % 5 == 0 && st.countTokens() != 0) {
                        String nombre = st.nextToken();
                        int dni = Integer.parseInt(st.nextToken());
                        int id = Integer.parseInt(st.nextToken());
                        boolean estado = Boolean.parseBoolean(st.nextToken());
                        String especialidad = st.nextToken();
                        System.out.println("Creando y cargando especialistas...");
                        Especialista especialista = new Especialista(nombre, dni, especialidad);
                        especialista.setIdMedico(id);
                        especialista.setEstado(estado);
                        listaDeMedicos.put(especialista.getIdMedico(), especialista);
                        System.out.println("¡especialista cargado con exito!");
                        
                    } else if (st.countTokens() % 4 == 0 && st.countTokens() != 0) {
                        String nombre = st.nextToken();
                        int dni = Integer.parseInt(st.nextToken());
                        int id = Integer.parseInt(st.nextToken());
                        boolean estado = Boolean.parseBoolean(st.nextToken());
                        System.out.println("Creando y cargando medicos...");
                        Medico medico = new Medico(nombre, dni);
                        medico.setIdMedico(id);
                        medico.setEstado(estado);
                        listaDeMedicos.put(medico.getIdMedico(), medico);
                        System.out.println("medico cargado con exito!");
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestionDeAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GestionDeAfiliados.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("Los datos contenidos en medicos_csv son: \n" + cadenaDatos);
            System.out.println("la lista de medicos resultante es: " + listaDeMedicos);
        }
    }
    
    /**
     * Regresa el medico contenido en listaDeMedicos, en la llave idMedico.
     * @param idMedico es la llave en la cual esta almacenado el medico al que
     * desea acceder.
     * @return el medico contenido en listaDeMedicos.get(idMedico)
     */
    public Medico getMedico(int idMedico){
        return listaDeMedicos.get(idMedico);
    }
}
