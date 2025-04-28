package com.lPassword012.app.registroAlumno.interfaz;

import com.lPassword012.app.registroAlumno.modelos.Persona;
import java.util.Scanner;

public class Menu {

    private int opcion;
    Scanner entrada = new Scanner(System.in);
    Persona persona = new Persona();

    public Menu() {

    }

    public int getOpcion() {
        return this.opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public void mostrarMenu() {
        System.out.println("\nIngrese una opcion");
        System.out.println("1.Ingresar nuevo usuario:");
        opcion = entrada.nextInt();
        switch (getOpcion()) {
            case 1:
                persona.generarNuevaPersona();
                break;

            default:
                System.out.println("\nEsa opcion no existe. Intente nuevamente.\n");
        }
    }
}

