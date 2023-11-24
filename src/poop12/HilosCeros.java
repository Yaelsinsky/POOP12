package poop12;

/**
 * La clase HilosCeros implementa la interfaz Runnable y se utiliza para demostrar
 * la creación de un hilo que imprime una serie de ceros. Esta clase representa un hilo
 * simple que imprime 1000 ceros en la consola, mostrando cómo se puede implementar un
 * hilo que ejecute una tarea específica.
 *
 * @version 1.0
 * @author Urbano Meza Joseph Gael
 * @author Camarena Arevalo Yael Eduardo 
 * @author Galindo Mayar Johann Zair
 */
public class HilosCeros implements Runnable {

    /**
     * Método sobreescrito de la interfaz Runnable.
     * Se ejecuta cuando el hilo está activo, imprimiendo 1000 ceros en la consola.
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("0");
        }
    }   
}


