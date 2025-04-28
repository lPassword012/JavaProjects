package com.lPassword012.app.registroAlumno.interfaz;

import java.util.Scanner;

public class Entrada {

    private String teclado;

    Scanner entrada = new Scanner(System.in);

    public Entrada() {

    }

    public String getTeclado() {
        return this.teclado;
    }

    public void setTeclado(String teclado) {
        this.teclado = teclado;
    }

    public String ingresarNombre() {
        setTeclado(entrada.nextLine());
        if (getTeclado() != null) {
            if (getTeclado() instanceof String) {
                System.out.println("\nRegistrado en la base de datos " + "nuevo usuario: " + getTeclado() + "\n");
                return getTeclado();
            }
        } else {
            System.out.println("\nError, intente otra vez.");
            System.out.println("\nIngresar nombre del usuario ");
            setTeclado(entrada.nextLine());
        }
        return getTeclado();
    }

    public int ingresarEdad() {
        int edad;
        setTeclado(entrada.nextLine());
        edad = Integer.parseInt(getTeclado());
        System.out.println("Registrado en la base de datos " + "Edad: " + edad + "\n");
        return edad;
    }
}
