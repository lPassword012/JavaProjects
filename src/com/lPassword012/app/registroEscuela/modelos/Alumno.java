package com.lPassword012.app.registroEscuela.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alumno extends Persona {
    private List<Materia> materias = new ArrayList<>();
    private Map<Integer, Double> calificaciones = new HashMap<>(); // Esto es ID de materia -> calificación

    public Alumno(String nombre, int edad) {
        super();
        this.setNombre(nombre);
        this.setEdad(edad);
        this.rol = "Alumno";
    }

    public void inscribirMateria(Materia materia) {
        materias.add(materia);
        materia.agregarAlumno(this);
        System.out.println("Alumno " + getNombre() + " inscrito en materia: " + materia.getNombre());
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void asignarCalificacion(int materiaId, double calificacion) {
        calificaciones.put(materiaId, calificacion);
    }

    public Double getCalificacion(int materiaId) {
        return calificaciones.getOrDefault(materiaId, null);
    }

    public boolean estaAprobado(int materiaId) {
        Double calificacion = getCalificacion(materiaId);
        return calificacion != null && calificacion >= 6.0;
    }

    public void verCalificaciones() {
        System.out.println("\n=== Calificaciones de " + getNombre() + " ===");
        for (Materia materia : materias) {
            Double calificacion = calificaciones.getOrDefault(materia.getId(), null);
            String estado = (calificacion == null) ? "No calificado" :
                    (estaAprobado(materia.getId()) ? "Aprobado" : "Reprobado");

            System.out.printf("Materia: %s | Calificación: %s | Estado: %s%n",
                    materia.getNombre(),
                    (calificacion == null ? "N/A" : calificacion),
                    estado);
        }
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("ID: %d | Nombre: %s | Edad: %d | Rol: %s | Materias inscritas: %d%n",
                getId(), getNombre(), getEdad(), getRol(), materias.size());
    }
}