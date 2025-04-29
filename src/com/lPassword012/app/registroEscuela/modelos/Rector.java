package com.lPassword012.app.registroEscuela.modelos;

import java.util.List;

public class Rector extends Persona {
    private String oficina;

    public Rector(String nombre, int edad) {
        super();
        this.setNombre(nombre);
        this.setEdad(edad);
        this.rol = "Rector";
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getOficina() {
        return oficina;
    }

    public void verEstadisticasAprobacion() {
        System.out.println("\n=== Estadísticas de Aprobación ===");
        List<Materia> materias = Escuela.getMaterias();

        for (Materia materia : materias) {
            int totalAlumnos = materia.getAlumnos().size();
            int aprobados = 0;
            int reprobados = 0;
            int noCalificados = 0;

            for (Alumno alumno : materia.getAlumnos()) {
                Double calificacion = alumno.getCalificacion(materia.getId());
                if (calificacion == null) {
                    noCalificados++;
                } else if (alumno.estaAprobado(materia.getId())) {
                    aprobados++;
                } else {
                    reprobados++;
                }
            }

            System.out.printf("Materia: %s | Profesor: %s | Total Alumnos: %d | Aprobados: %d | Reprobados: %d | No calificados: %d%n",
                    materia.getNombre(), materia.getProfesor().getNombre(),
                    totalAlumnos, aprobados, reprobados, noCalificados);
        }
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("ID: %d | Nombre: %s | Edad: %d | Rol: %s | Oficina: %s%n",
                getId(), getNombre(), getEdad(), getRol(),
                (oficina != null ? oficina : "No asignada"));
    }
}