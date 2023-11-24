package poop12;

import java.io.*;
import java.util.StringTokenizer;
/**
 * La clase Alumno representa a un estudiante y maneja operaciones de E/S para guardar y leer
 * información de alumnos utilizando un enfoque multihilo. Cada instancia de Alumno almacena 
 * detalles como el nombre, matrícula, edad y carrera del estudiante.
 *
 * Funciones Principales:
 * - Representar la información de un estudiante.
 * - Guardar un conjunto de alumnos en un archivo de manera concurrente.
 * - Leer la información de los alumnos desde un archivo y crear instancias de Alumno.
 * 
 * @version 1.0
 * @author Urbano Meza Joseph Gael
 * @author Camarena Arevalo Yael Eduardo
 * @author Galindo Mayar Johann Zair
 */
public class Alumno {
    private String nombre;
    private String matricula;
    private int edad;
    private String carrera;

    public Alumno(String nombre, String matricula, int edad, String carrera) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.carrera = carrera;
    }

    // Métodos getter y setter para cada campo

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    

    @Override
    public String toString() {
        return nombre + "," + matricula + "," + edad + "," + carrera;
    }

    public static void guardarAlumnos(Alumno[] alumnos, String archivo) throws InterruptedException {
        Thread guardarThread = new Thread(() -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (Alumno alumno : alumnos) {
                    bw.write(alumno.toString());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo: " + e.getMessage());
            }
        });
        guardarThread.start();
        guardarThread.join(); // Esperar a que el hilo de escritura termine
    }

    public static Alumno[] leerAlumnos(String archivo) {
        final Alumno[] alumnos = new Alumno[5];
        Thread lecturaThread = new Thread(() -> {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                int i = 0;
                while ((linea = br.readLine()) != null && i < alumnos.length) {
                    StringTokenizer st = new StringTokenizer(linea, ",");
                    alumnos[i++] = new Alumno(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), st.nextToken());
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        });
        lecturaThread.start();

        try {
            lecturaThread.join(); // Esperar a que el hilo de lectura termine
        } catch (InterruptedException e) {
            System.out.println("Hilo interrumpido: " + e.getMessage());
        }

        return alumnos;
    }

    public static void main(String[] args) {
        try {
            // Crear 5 objetos Alumno
            Alumno[] alumnosOriginales = {
                new Alumno("Juan", "123", 20, "Ingeniería"),
                new Alumno("Ana", "456", 21, "Matemáticas"),
                new Alumno("Luis", "789", 22, "Física"),
                new Alumno("Maria", "012", 23, "Química"),
                new Alumno("Pedro", "345", 24, "Biología")
            };

            // Guardar alumnos en un archivo
            guardarAlumnos(alumnosOriginales, "alumnos.txt");

            // Leer alumnos del archivo y tokenizar la información
            Alumno[] alumnosLeidos = leerAlumnos("alumnos.txt");

            // Crear 5 alumnos adicionales con información repetida
            Alumno[] alumnosRepetidos = new Alumno[5];
            for (int i = 0; i < alumnosRepetidos.length; i++) {
                alumnosRepetidos[i] = new Alumno(alumnosLeidos[i].nombre, alumnosLeidos[i].matricula, alumnosLeidos[i].edad, alumnosLeidos[i].carrera);
            }

            // Procesamiento adicional si es necesario
            // ...
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
