package com.lPassword012.app.registroEscuela.modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private static int contadorId = 0;
    private int id;
    private String nombre;
    private Profesor profesor;
    private List<Alumno> alumnos = new ArrayList<>();

    public Materia(String nombre, Profesor profesor) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public int getCantidadAlumnos() {
        return alumnos.size();
    }

    public void mostrarDetalles() {
        System.out.printf("ID: %d | Materia: %s | Profesor: %s | Alumnos: %d%n",
                id, nombre, profesor.getNombre(), alumnos.size());
    }
}