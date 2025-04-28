package com.lPassword012.app.registroEscuela.modelos;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {
    private String departamento;
    private List<Materia> materiasImpartidas = new ArrayList<>();

    public Profesor(String nombre, int edad) {
        super();
        this.setNombre(nombre);
        this.setEdad(edad);
        this.rol = "Profesor";
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void agregarMateria(Materia materia) {
        materiasImpartidas.add(materia);
    }

    public List<Materia> getMateriasImpartidas() {
        return materiasImpartidas;
    }

    public void calificarAlumno(Alumno alumno, int materiaId, double calificacion) {
        alumno.asignarCalificacion(materiaId, calificacion);
        System.out.println("Calificación asignada al alumno " + alumno.getNombre() + ": " + calificacion);
    }

    public void verAlumnosPorMateria(int materiaId) {
        for (Materia materia : materiasImpartidas) {
            if (materia.getId() == materiaId) {
                System.out.println("\n=== Alumnos de la materia: " + materia.getNombre() + " ===");
                List<Alumno> alumnos = materia.getAlumnos();
                System.out.println("Total de alumnos: " + alumnos.size());

                for (Alumno alumno : alumnos) {
                    Double calificacion = alumno.getCalificacion(materiaId);
                    String estado = (calificacion == null) ? "No calificado" :
                            (alumno.estaAprobado(materiaId) ? "Aprobado" : "Reprobado");

                    System.out.printf("ID: %d | Nombre: %s | Calificación: %s | Estado: %s%n",
                            alumno.getId(), alumno.getNombre(),
                            (calificacion == null ? "N/A" : calificacion),
                            estado);
                }
                return;
            }
        }
        System.out.println("No se encontró la materia con ID: " + materiaId);
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("ID: %d | Nombre: %s | Edad: %d | Rol: %s | Departamento: %s | Materias: %d%n",
                getId(), getNombre(), getEdad(), getRol(),
                (departamento != null ? departamento : "No asignado"),
                materiasImpartidas.size());
    }
}