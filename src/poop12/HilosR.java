package poop12;

/**
 * La clase HilosR implementa la interfaz Runnable y se utiliza para demostrar
 * la creación y ejecución de un hilo que realiza una serie de impresiones en consola.
 * La clase imprime el número de iteraciones junto con el nombre del hilo actual, 
 * proporcionando un ejemplo claro de la ejecución concurrente de hilos en Java.
 *
 * @version 1.0
 * @author Urbano Meza Joseph Gael
 * @author Camarena Arevalo Yael Eduardo 
 * @author Galindo Mayar Johann Zair
 */
public class HilosR implements Runnable {

    /**
     * Método sobreescrito de la interfaz Runnable.
     * Se ejecuta cuando el hilo está activo y realiza 10 iteraciones, imprimiendo
     * el número de iteración y el nombre del hilo actual en cada paso.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Interacion " + i + " del " + Thread.currentThread().getName());
        }
        System.out.println("Termina el " + Thread.currentThread().getName());
    }
    
}
