package com.lPassword012.app.registroEscuela.interfaz;

import com.lPassword012.app.registroEscuela.modelos.*;
import java.util.List;

public class Menu {
    private Entrada entrada = new Entrada();

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Materias");
            System.out.println("3. Operaciones de Alumnos");
            System.out.println("4. Operaciones de Profesores");
            System.out.println("5. Operaciones de Rectores");
            System.out.println("6. Salir");
            opcion = entrada.ingresarEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    menuUsuarios();
                    break;
                case 2:
                    menuMaterias();
                    break;
                case 3:
                    menuAlumnos();
                    break;
                case 4:
                    menuProfesores();
                    break;
                case 5:
                    menuRectores();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida!");
            }
        } while (opcion != 6);
    }

    private void menuUsuarios() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE USUARIOS ===");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Listar todos los usuarios");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("4. Volver al menú principal");
            opcion = entrada.ingresarEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    Persona persona = Persona.generarNuevaPersona(entrada);
                    Escuela.agregarPersona(persona);
                    System.out.println("Registro exitoso!");
                    break;
                case 2:
                    Escuela.mostrarTodos();
                    break;
                case 3:
                    int id = entrada.ingresarEntero("Ingrese ID del usuario a buscar: ");
                    Persona p = Escuela.buscarPersonaPorId(id);
                    if (p != null) {
                        p.mostrarDetalles();
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida!");
            }
        } while (opcion != 4);
    }

    private void menuMaterias() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE MATERIAS ===");
            System.out.println("1. Crear nueva materia");
            System.out.println("2. Listar todas las materias");
            System.out.println("3. Volver al menú principal");
            opcion = entrada.ingresarEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    crearMateria();
                    break;
                case 2:
                    Escuela.mostrarMaterias();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida!");
            }
        } while (opcion != 3);
    }

    private void crearMateria() {
        String nombre = entrada.ingresarTexto("Nombre de la materia: ");

        // Mostrar profesores disponibles
        List<Profesor> profesores = Escuela.getProfesores();
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados. Primero debe registrar un profesor.");
            return;
        }

        System.out.println("\nProfesores disponibles:");
        for (Profesor prof : profesores) {
            System.out.printf("ID: %d | Nombre: %s%n", prof.getId(), prof.getNombre());
        }

        int profId = entrada.ingresarEntero("Seleccione ID del profesor para esta materia: ");
        Persona p = Escuela.buscarPersonaPorId(profId);

        if (p != null && p instanceof Profesor) {
            Profesor profesor = (Profesor) p;
            Materia materia = new Materia(nombre, profesor);
            Escuela.agregarMateria(materia);
            profesor.agregarMateria(materia);
            System.out.println("Materia creada con éxito!");
        } else {
            System.out.println("Profesor no encontrado o ID inválido.");
        }
    }

    private void menuAlumnos() {
        int opcion;
        do {
            System.out.println("\n=== OPERACIONES DE ALUMNOS ===");
            System.out.println("1. Inscribir alumno a materia");
            System.out.println("2. Ver materias de un alumno");
            System.out.println("3. Ver calificaciones de un alumno");
            System.out.println("4. Volver al menú principal");
            opcion = entrada.ingresarEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    inscribirAlumnoAMateria();
                    break;
                case 2:
                    verMateriasAlumno();
                    break;
                case 3:
                    verCalificacionesAlumno();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida!");
            }
        } while (opcion != 4);
    }

    private void inscribirAlumnoAMateria() {
        List<Alumno> alumnos = Escuela.getAlumnos();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        List<Materia> materias = Escuela.getMaterias();
        if (materias.isEmpty()) {
            System.out.println("No hay materias disponibles.");
            return;
        }

        System.out.println("\nAlumnos disponibles:");
        for (Alumno alumno : alumnos) {
            System.out.printf("ID: %d | Nombre: %s%n", alumno.getId(), alumno.getNombre());
        }

        int alumnoId = entrada.ingresarEntero("Seleccione ID del alumno: ");
        Persona p = Escuela.buscarPersonaPorId(alumnoId);

        if (p != null && p instanceof Alumno) {
            Alumno alumno = (Alumno) p;

            System.out.println("\nMaterias disponibles:");
            for (Materia materia : materias) {
                System.out.printf("ID: %d | Nombre: %s | Profesor: %s%n",
                        materia.getId(), materia.getNombre(), materia.getProfesor().getNombre());
            }

            int materiaId = entrada.ingresarEntero("Seleccione ID de la materia: ");
            Materia materia = Escuela.buscarMateriaPorId(materiaId);

            if (materia != null) {
                alumno.inscribirMateria(materia);
            } else {
                System.out.println("Materia no encontrada.");
            }
        } else {
            System.out.println("Alumno no encontrado o ID inválido.");
        }
    }

    private void verMateriasAlumno() {
        int alumnoId = entrada.ingresarEntero("Ingrese ID del alumno: ");
        Persona p = Escuela.buscarPersonaPorId(alumnoId);

        if (p != null && p instanceof Alumno) {
            Alumno alumno = (Alumno) p;
            List<Materia> materias = alumno.getMaterias();

            System.out.println("\n=== Materias de " + alumno.getNombre() + " ===");
            if (materias.isEmpty()) {
                System.out.println("El alumno no está inscrito en ninguna materia.");
            } else {
                for (Materia materia : materias) {
                    System.out.printf("ID: %d | Materia: %s | Profesor: %s%n",
                            materia.getId(), materia.getNombre(), materia.getProfesor().getNombre());
                }
            }
        } else {
            System.out.println("Alumno no encontrado o ID inválido.");
        }
    }

    private void verCalificacionesAlumno() {
        int alumnoId = entrada.ingresarEntero("Ingrese ID del alumno: ");
        Persona p = Escuela.buscarPersonaPorId(alumnoId);

        if (p != null && p instanceof Alumno) {
            Alumno alumno = (Alumno) p;
            alumno.verCalificaciones();
        } else {
            System.out.println("Alumno no encontrado o ID inválido.");
        }
    }

    private void menuProfesores() {
        int opcion;
        do {
            System.out.println("\n=== OPERACIONES DE PROFESORES ===");
            System.out.println("1. Asignar departamento a profesor");
            System.out.println("2. Ver materias impartidas por un profesor");
            System.out.println("3. Calificar alumno");
            System.out.println("4. Ver alumnos por materia");
            System.out.println("5. Volver al menú principal");
            opcion = entrada.ingresarEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    asignarDepartamentoProfesor();
                    break;
                case 2:
                    verMateriasProfesor();
                    break;
                case 3:
                    calificarAlumno();
                    break;
                case 4:
                    verAlumnosPorMateria();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida!");
            }
        } while (opcion != 5);
    }

    private void asignarDepartamentoProfesor() {
        int profId = entrada.ingresarEntero("Ingrese ID del profesor: ");
        Persona p = Escuela.buscarPersonaPorId(profId);

        if (p != null && p instanceof Profesor) {
            Profesor profesor = (Profesor) p;
            String departamento = entrada.ingresarTexto("Nombre del departamento: ");
            profesor.setDepartamento(departamento);
            System.out.println("Departamento asignado con éxito!");
        } else {
            System.out.println("Profesor no encontrado o ID inválido.");
        }
    }

    private void verMateriasProfesor() {
        int profId = entrada.ingresarEntero("Ingrese ID del profesor: ");
        Persona p = Escuela.buscarPersonaPorId(profId);

        if (p != null && p instanceof Profesor) {
            Profesor profesor = (Profesor) p;
            List<Materia> materias = profesor.getMateriasImpartidas();

            System.out.println("\n=== Materias impartidas por " + profesor.getNombre() + " ===");
            if (materias.isEmpty()) {
                System.out.println("El profesor no imparte ninguna materia.");
            } else {
                for (Materia materia : materias) {
                    System.out.printf("ID: %d | Materia: %s | Alumnos inscritos: %d%n",
                            materia.getId(), materia.getNombre(), materia.getCantidadAlumnos());
                }
            }
        } else {
            System.out.println("Profesor no encontrado o ID inválido.");
        }
    }

    private void calificarAlumno() {
        int profId = entrada.ingresarEntero("Ingrese ID del profesor: ");
        Persona p = Escuela.buscarPersonaPorId(profId);

        if (p != null && p instanceof Profesor) {
            Profesor profesor = (Profesor) p;
            List<Materia> materias = profesor.getMateriasImpartidas();

            if (materias.isEmpty()) {
                System.out.println("El profesor no imparte ninguna materia.");
                return;
            }

            System.out.println("\nMaterias impartidas:");
            for (Materia materia : materias) {
                System.out.printf("ID: %d | Materia: %s%n", materia.getId(), materia.getNombre());
            }

            int materiaId = entrada.ingresarEntero("Seleccione ID de la materia: ");
            Materia materia = Escuela.buscarMateriaPorId(materiaId);

            if (materia != null) {
                List<Alumno> alumnos = materia.getAlumnos();
                if (alumnos.isEmpty()) {
                    System.out.println("No hay alumnos inscritos en esta materia.");
                    return;
                }

                System.out.println("\nAlumnos inscritos:");
                for (Alumno alumno : alumnos) {
                    Double calificacion = alumno.getCalificacion(materiaId);
                    System.out.printf("ID: %d | Nombre: %s | Calificación actual: %s%n",
                            alumno.getId(), alumno.getNombre(),
                            (calificacion == null ? "No calificado" : calificacion));
                }

                int alumnoId = entrada.ingresarEntero("Seleccione ID del alumno a calificar: ");
                Persona pAlumno = Escuela.buscarPersonaPorId(alumnoId);

                if (pAlumno != null && pAlumno instanceof Alumno) {
                    Alumno alumno = (Alumno) pAlumno;
                    double calificacion = entrada.ingresarCalificacion();
                    profesor.calificarAlumno(alumno, materiaId, calificacion);
                } else {
                    System.out.println("Alumno no encontrado o ID inválido.");
                }
            } else {
                System.out.println("Materia no encontrada o no impartida por este profesor.");
            }
        } else {
            System.out.println("Profesor no encontrado o ID inválido.");
        }
    }

    private void verAlumnosPorMateria() {
        int profId = entrada.ingresarEntero("Ingrese ID del profesor: ");
        Persona p = Escuela.buscarPersonaPorId(profId);

        if (p != null && p instanceof Profesor) {
            Profesor profesor = (Profesor) p;
            List<Materia> materias = profesor.getMateriasImpartidas();

            if (materias.isEmpty()) {
                System.out.println("El profesor no imparte ninguna materia.");
                return;
            }

            System.out.println("\nMaterias impartidas:");
            for (Materia materia : materias) {
                System.out.printf("ID: %d | Materia: %s%n", materia.getId(), materia.getNombre());
            }

            int materiaId = entrada.ingresarEntero("Seleccione ID de la materia: ");
            profesor.verAlumnosPorMateria(materiaId);
        } else {
            System.out.println("Profesor no encontrado o ID inválido.");
        }
    }

    private void menuRectores() {
        int opcion;
        do {
            System.out.println("\n=== OPERACIONES DE RECTORES ===");
            System.out.println("1. Asignar oficina a rector");
            System.out.println("2. Ver estadísticas de aprobación");
            System.out.println("3. Volver al menú principal");
            opcion = entrada.ingresarEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    asignarOficinaRector();
                    break;
                case 2:
                    verEstadisticasAprobacion();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida!");
            }
        } while (opcion != 3);
    }

    private void asignarOficinaRector() {
        int rectorId = entrada.ingresarEntero("Ingrese ID del rector: ");
        Persona p = Escuela.buscarPersonaPorId(rectorId);

        if (p != null && p instanceof Rector) {
            Rector rector = (Rector) p;
            String oficina = entrada.ingresarTexto("Número o nombre de oficina: ");
            rector.setOficina(oficina);
            System.out.println("Oficina asignada con éxito!");
        } else {
            System.out.println("Rector no encontrado o ID inválido.");
        }
    }

    private void verEstadisticasAprobacion() {
        List<Rector> rectores = Escuela.getRectores();
        if (rectores.isEmpty()) {
            System.out.println("No hay rectores registrados.");
            return;
        }

        System.out.println("\nRectores disponibles:");
        for (Rector rector : rectores) {
            System.out.printf("ID: %d | Nombre: %s%n", rector.getId(), rector.getNombre());
        }

        int rectorId = entrada.ingresarEntero("Seleccione ID del rector: ");
        Persona p = Escuela.buscarPersonaPorId(rectorId);

        if (p != null && p instanceof Rector) {
            Rector rector = (Rector) p;
            rector.verEstadisticasAprobacion();
        } else {
            System.out.println("Rector no encontrado o ID inválido.");
        }
    }

}