package com.lPassword012.app.registroEscuela.interfaz;

import java.util.Scanner;

public class Entrada {
    private Scanner scanner = new Scanner(System.in);

    public String ingresarNombre() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        while (nombre.trim().isEmpty()) {
            System.out.println("Error! Ingrese un nombre válido:");
            nombre = scanner.nextLine();
        }
        return nombre;
    }

    public int ingresarEdad() {
        while (true) {
            try {
                System.out.print("Edad: ");
                int edad = Integer.parseInt(scanner.nextLine());
                if (edad <= 0) {
                    System.out.println("Error! La edad debe ser un número positivo.");
                    continue;
                }
                return edad;
            } catch (NumberFormatException e) {
                System.out.println("Error! Ingrese un número válido.");
            }
        }
    }

    public double ingresarCalificacion() {
        while (true) {
            try {
                System.out.print("Calificación (0-10): ");
                double calificacion = Double.parseDouble(scanner.nextLine());
                if (calificacion < 0 || calificacion > 10) {
                    System.out.println("Error! La calificación debe estar entre 0 y 10.");
                    continue;
                }
                return calificacion;
            } catch (NumberFormatException e) {
                System.out.println("Error! Ingrese un número válido.");
            }
        }
    }

    public String ingresarTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int ingresarEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error! Ingrese un número válido.");
            }
        }
    }
}