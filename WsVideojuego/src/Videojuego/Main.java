package Videojuego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Muniemon muniemon = null;

        int opcion = 0;
        do {
            System.out.println("Menú:");
            System.out.println("1. Dar de alta Muniemon");
            System.out.println("2. Mostrar Muniemon");
            System.out.println("3. Salir del programa :( ");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    muniemon = darDeAltaMuniemon(scanner);
                    break;
                case 2:
                    mostrarMuniemon(muniemon);
                    break;
                case 3:
                    System.out.println("Saliendo del programa :)");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 3);
        
        scanner.close();
    }

    public static Muniemon darDeAltaMuniemon(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Ingresa los datos del Muniemon:");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Vida: ");
        int vida = scanner.nextInt();

        System.out.print("Ataque: ");
        int ataque = scanner.nextInt();

        System.out.print("Defensa: ");
        int defensa = scanner.nextInt();

        System.out.println("Tipo (AGUA, TIERRA, FUEGO, PLANTA): ");
        scanner.nextLine();
        String tipoStr = scanner.nextLine().toUpperCase();
        TipoMuniemon tipoMuniemon = TipoMuniemon.valueOf(tipoStr);

        return new Muniemon(nombre, vida, ataque, defensa, tipoMuniemon);
    }

    public static void mostrarMuniemon(Muniemon muniemon) {
        if (muniemon != null) {
        	System.out.println("---------------------------------");
            System.out.println("Muniemon:");
            System.out.println("Nombre: " + muniemon.getNombre());
            System.out.println("Vida: " + muniemon.getVida());
            System.out.println("Ataque: " + muniemon.getAtaque());
            System.out.println("Defensa: " + muniemon.getDefensa());
            System.out.println("Tipo: " + muniemon.getTipo());
            System.out.println("---------------------------------");
        } else {
            System.out.println("No hay ningún Muniemon dado de alta.");
        }
    }
}

