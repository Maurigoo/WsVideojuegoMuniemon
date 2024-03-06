package Videojuego;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Muniemon muniemon1 = null;
        Muniemon muniemon2 = null ;

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Dar de alta primer Muniemon");
            System.out.println("2. Dar de alta segundo Muniemon");
            System.out.println("3. Mostrar primer Muniemon");
            System.out.println("4. Mostrar segundo Muniemon");
            System.out.println("5. Atacar primer Muniemon a segundo Muniemon");
            System.out.println("6. Atacar segundo Muniemon a primer Muniemon");
            System.out.println("7. Salir del programa");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    muniemon1 = darDeAltaMuniemon(sc, "primer");
                    break;
                case 2:
                    muniemon2 = darDeAltaMuniemon(sc, "segundo");
                    break;
                case 3:
                    mostrarMuniemon(muniemon1, "primer");
                    break;
                case 4:
                    mostrarMuniemon(muniemon2, "segundo");
                    break;
                case 5:
                    atacarMuniemon(sc, muniemon1, muniemon2);
                    break;
                case 6:
                    atacarMuniemon(sc, muniemon2, muniemon1);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 7);
        
        sc.close();
    }

    public static Muniemon darDeAltaMuniemon(Scanner sc, String posicion) {
        sc.nextLine();
        System.out.println("Ingrese los datos del " + posicion + " Muniemon:");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Vida: ");
        int vida = sc.nextInt();

        System.out.print("Ataque: ");
        int ataque = sc.nextInt();

        System.out.print("Defensa: ");
        int defensa = sc.nextInt();

        System.out.println("Tipo (AGUA, TIERRA, FUEGO, PLANTA): ");
        sc.nextLine();
        String tipoStr = sc.nextLine().toUpperCase();
        TipoMuniemon tipo = TipoMuniemon.valueOf(tipoStr);

        return new Muniemon(nombre, vida, ataque, defensa, tipo);
    }

    public static void mostrarMuniemon(Muniemon muniemon, String posicion) {
        if (muniemon != null) {
            System.out.println(posicion + " Muniemon:");
            System.out.println("-------------------------------------");
            System.out.println("Nombre: " + muniemon.getNombre());
            System.out.println("Vida: " + muniemon.getVida());
            System.out.println("Ataque: " + muniemon.getAtaque());
            System.out.println("Defensa: " + muniemon.getDefensa());
            System.out.println("Tipo: " + muniemon.getTipo());
            if (muniemon.getVida() <= 0) {
                System.out.println(muniemon.getNombre() + " ha sido derrotado.");
            }
        } else {
            System.out.println("No hay ningún Muniemon dado de alta en la posición " + posicion + ".");
        }
        System.out.println("-------------------------------------");
    }

    public static void atacarMuniemon(Scanner sc, Muniemon atacante, Muniemon objetivo) {
        if (atacante == null || objetivo == null) {
            System.out.println("Primero debes dar de alta ambos Muniemon.");
            return;
        }

        if (atacante.getVida() <= 0) {
            System.out.println(atacante.getNombre() + " no puede atacar porque está muerto.");
            return;
        }

        if (objetivo.getVida() <= 0) {
            System.out.println(objetivo.getNombre() + " no puede ser atacado porque está muerto.");
            return;
        }

        atacante.atacar(objetivo);
    }
}
