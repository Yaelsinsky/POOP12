package poop12;

/**
 * La clase HilosT extiende la clase Thread y se utiliza para demostrar
 * la creación y ejecución de un hilo que realiza impresiones en consola.
 * Esta clase, al extender Thread directamente, proporciona una forma de 
 * ejecutar un hilo con su propio método run(), mostrando el nombre del hilo
 * y el número de iteración en cada paso.
 *
 * @version 1.0
 * @author Urbano Meza Joseph Gael
 * @author Camarena Arevalo Yael Eduardo 
 * @author Galindo Mayar Johann Zair
 */
public class HilosT extends Thread {

    /**
     * Constructor para la clase HilosT. Inicializa un hilo con un nombre específico.
     * 
     * @param name El nombre del hilo.
     */
    public HilosT(String name) {
        super(name);
    }

    /**
     * Método sobreescrito de la clase Thread.
     * Se ejecuta cuando el hilo está activo y realiza 10 iteraciones, imprimiendo
     * el número de iteración y el nombre del hilo en cada paso.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Interacion " + i + " de " + getName());
        }
        System.out.println("Termina el " + getName());
    }
    
}