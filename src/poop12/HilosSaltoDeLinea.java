package poop12;

/**
 * La clase HilosSaltoDeLinea implementa la interfaz Runnable y se utiliza para demostrar
 * la creación de un hilo que realiza saltos de línea en la consola. Este hilo imprime
 * 1000 líneas vacías, lo que puede ser útil para entender la ejecución y el comportamiento
 * de los hilos en Java, así como el efecto de imprimir múltiples líneas en la consola.
 *
 * @version 1.0
 * @author Urbano Meza Joseph Gael
 * @author Camarena Arevalo Yael Eduardo 
 * @author Galindo Mayar Johann Zair
 */
public class HilosSaltoDeLinea implements Runnable {

    /**
     * Método sobreescrito de la interfaz Runnable.
     * Se ejecuta cuando el hilo está activo, imprimiendo 1000 líneas vacías en la consola.
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("");
        }
    }
}