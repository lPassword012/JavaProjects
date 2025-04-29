package com.lPassword012.app.registroEscuela.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Escuela {
    private static String nombre = "Escuela Genérica";
    private static List<Persona> personas = new ArrayList<>();
    private static List<Materia> materias = new ArrayList<>();

    public static void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    public static void agregarMateria(Materia materia) {
        materias.add(materia);
    }

    public static List<Persona> getPersonas() {
        return personas;
    }

    public static List<Materia> getMaterias() {
        return materias;
    }

    public static List<Alumno> getAlumnos() {
        return personas.stream()
                .filter(p -> p instanceof Alumno)
                .map(p -> (Alumno) p)
                .collect(Collectors.toList());
    }

    public static List<Profesor> getProfesores() {
        return personas.stream()
                .filter(p -> p instanceof Profesor)
                .map(p -> (Profesor) p)
                .collect(Collectors.toList());
    }

    public static List<Rector> getRectores() {
        return personas.stream()
                .filter(p -> p instanceof Rector)
                .map(p -> (Rector) p)
                .collect(Collectors.toList());
    }

    public static void mostrarTodos() {
        System.out.println("\n=== Listado de Personas ===");
        System.out.println("Total personas: " + personas.size());
        System.out.println("Alumnos: " + getAlumnos().size());
        System.out.println("Profesores: " + getProfesores().size());
        System.out.println("Rectores: " + getRectores().size());

        for (Persona p : personas) {
            p.mostrarDetalles();
        }
    }

    public static void mostrarMaterias() {
        System.out.println("\n=== Listado de Materias ===");
        System.out.println("Total materias: " + materias.size());

        for (Materia m : materias) {
            m.mostrarDetalles();
        }
    }

    public static Persona buscarPersonaPorId(int id) {
        for (Persona p : personas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public static Materia buscarMateriaPorId(int id) {
        for (Materia m : materias) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}