package poop12;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase POOP12 contiene el método main y se utiliza para iniciar la ejecución 
 * de varios hilos como parte de una demostración del manejo de hilos en Java.
 * Esta clase crea e inicia hilos que realizan diferentes tareas, como imprimir ceros,
 * unos o realizar saltos de línea, mostrando cómo diferentes hilos pueden ejecutarse
 * concurrentemente en un programa Java.
 *
 * @version 1.0
 * @author Urbano Meza Joseph Gael
 * @author Camarena Arevalo Yael Eduardo 
 * @author Galindo Mayar Johann Zair
 */
public class POOP12 {

    /**
     * El método principal de la aplicación. Este método inicia varios hilos para
     * demostrar la ejecución concurrente y las capacidades de multihilo de Java.
     * 
     * @param args Argumentos de línea de comandos (no utilizados en esta aplicación).
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        HiloT hilo1 = new HiloT("Primer Hilo");
        hilo1.start();
        new HiloT("Segundo Hilo").start();
        new Thread(new HiloR(),"Tercer Hilo").start();
        for(int i =0;i < 10; i++){
            System.out.println("Interacion "+i+ "del main");
        }
        System.out.println("Termina el Main");*/
        
        
        // Ejemplo de cómo iniciar diferentes hilos para realizar tareas específicas
        new Thread (new HilosCeros(), "Hilos Ceros").start();
        new Thread (new HilosUnos(), "Hilos Unos").start();
        new Thread (new HilosSaltoDeLinea(), "Hilos Salto De Linea ").start();
        
        // Tareas de alumnos
        Alumno[] alumnosOriginales = {
            new Alumno("Juan", "12345", 20, "Ingeniería"),
            new Alumno("Ana", "67890", 21, "Matemáticas"),
            new Alumno("Luis", "11223", 22, "Física"),
            new Alumno("Maria", "33445", 23, "Química"),
            new Alumno("Pedro", "55667", 24, "Biología"),
            // ... inicialización de los demás alumnos
        };

        try {
            Alumno.guardarAlumnos(alumnosOriginales, "alumnos.txt");
        } catch (InterruptedException ex) {
            Logger.getLogger(POOP12.class.getName()).log(Level.SEVERE, null, ex);
        }
        Alumno[] alumnosLeidos = Alumno.leerAlumnos("alumnos.txt");

        // Procesamiento adicional si es necesario
        for (Alumno alumno : alumnosLeidos) {
            if (alumno != null) {
                System.out.println(alumno);
            }
        }
    }
}       
