package com.lPassword012.app.registroEscuela.modelos;

import com.lPassword012.app.registroEscuela.interfaz.Entrada;

public abstract class Persona {
    private static int contadorId = 0;
    private int id;
    private String nombre;
    private int edad;
    protected String rol; // Nuevo campo para diferenciar el tipo

    public Persona() {
        this.id = ++contadorId;
    }

    // Metodo abstracto para ser implementado por subclases
    public abstract void mostrarDetalles();

    // Getters y Setters
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getRol() {
        return rol;
    }

    // Este metodo para crear un usuario (debe ser manejado por subclases)
    public static Persona generarNuevaPersona(Entrada entrada) {
        System.out.println("\nTipo de usuario:\n1. Alumno\n2. Profesor\n3. Rector");
        int tipo = entrada.ingresarEntero("Seleccione una opción: ");

        System.out.println("Ingresar nombre:");
        String nombre = entrada.ingresarNombre();
        System.out.println("Ingresar edad:");
        int edad = entrada.ingresarEdad();

        switch (tipo) {
            case 1: return new Alumno(nombre, edad);
            case 2: return new Profesor(nombre, edad);
            case 3: return new Rector(nombre, edad);
            default: throw new IllegalArgumentException("Opción inválida. Intente otra vez.");
        }
    }
}