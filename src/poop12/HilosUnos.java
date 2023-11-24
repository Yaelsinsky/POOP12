package poop12;

/**
 * La clase HilosUnos implementa la interfaz Runnable y se utiliza para demostrar
 * la creación de un hilo que imprime una serie de unos. Este hilo imprime 1000 unos
 * en la consola, proporcionando un ejemplo simple de cómo un hilo puede realizar
 * una tarea repetitiva en un programa Java.
 *
 * @version 1.0
 * @author Urbano Meza Joseph Gael
 * @author Camarena Arevalo Yael Eduardo 
 * @author Galindo Mayar Johann Zair
 */
public class HilosUnos implements Runnable {

    /**
     * Método sobreescrito de la interfaz Runnable.
     * Se ejecuta cuando el hilo está activo, imprimiendo 1000 unos en la consola.
     */
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("1");
        }
    }
}
