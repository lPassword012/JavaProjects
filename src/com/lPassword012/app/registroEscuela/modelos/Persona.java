package com.lPassword012.app.registroAlumno.modelos;
import com.lPassword012.app.registroAlumno.interfaz.Entrada;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private int id = 1;
    private String nombre;
    private int edad;
    private String profesion;
    private List<String> listaPersonas = new ArrayList<>();

    Entrada entrada = new Entrada();

    public Persona() {

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void generarNuevaPersona(){
        String nombre;
        int edad;
        System.out.println("\nEsperando ingreso de datos");
        System.out.println("Ingresar nombre");
        nombre = entrada.ingresarNombre();
        setNombre(nombre);
        listaPersonas.add(id, getNombre());
        System.out.println("Ingresar edad");
        edad = entrada.ingresarEdad();
        setEdad(edad);
        System.out.println("Entrada de datos finalizado.");
    }
}