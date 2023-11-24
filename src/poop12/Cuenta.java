package poop12;

/**
 * La clase Cuenta extiende Thread y se utiliza para demostrar el manejo de operaciones
 * bancarias básicas en un entorno multihilo. Permite realizar operaciones de depósito y
 * extracción de dinero simulando un entorno bancario simple.
 *
 * @version 1.0
 * @author Urbano Meza Joseph Gael
 * @author Camarena Arevalo Yael Eduardo 
 * @author Galindo Mayar Johann Zair
 */
public class Cuenta extends Thread {
    private static long saldo = 0; // Saldo compartido entre todas las instancias de Cuenta

    /**
     * Constructor de la clase Cuenta. Inicializa un hilo con un nombre específico.
     *
     * @param name El nombre del hilo.
     */
    public Cuenta(String name) {
        super(name);
    }

    /**
     * Método sobreescrito de la clase Thread. Se ejecuta cuando el hilo inicia.
     * Realiza operaciones de depósito o extracción basadas en el nombre del hilo.
     */
    public void run() {
        if (getName().equals("Deposito 1") || getName().equals("Deposito 2")) {
            this.depositarDinero(100);
        } else {
            this.extraerDinero(50);
        }
        System.out.println("Termina el " + getName());
    }

    /**
     * Método sincronizado para depositar dinero en la cuenta. Notifica a todos los hilos
     * después de realizar un depósito.
     *
     * @param cantidad La cantidad de dinero a depositar.
     */
    public synchronized void depositarDinero(int cantidad) {
        saldo += cantidad;
        System.out.println("Se depositaron " + cantidad + " pesos");
        notifyAll();
    }

    /**
     * Método sincronizado para extraer dinero de la cuenta. Si el saldo es insuficiente,
     * el hilo espera. Notifica a todos los hilos después de realizar un retiro.
     *
     * @param cantidad La cantidad de dinero a extraer.
     */
    public synchronized void extraerDinero(int cantidad) {
        try {
            if (saldo < 0) {
                System.out.println(getName() + " espera deposito" + " Saldo = " + saldo);
                sleep(5000);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        saldo -= cantidad;
        System.out.println(getName() + " extrajo " + cantidad + " pesos.\nSaldo restante = " + saldo);
        notifyAll();
    }

    /**
     * Método principal que inicia la aplicación. Crea y arranca hilos para simular
     * operaciones bancarias.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        new Cuenta("Acceso 1").start();
        new Cuenta("Acceso 2").start();
        new Cuenta("Deposito 1").start();
        new Cuenta("Deposito 2").start();
        System.out.println("Termina el hilo principal");
    }
}
