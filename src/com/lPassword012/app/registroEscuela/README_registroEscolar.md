# 🗂️ Estructura del Sistema

⚠️ El sistema de registro tiene una estructura basica pero aun falta implementar muchas funcionalidades

## 🎓 Conceptos Aprendidos (en el proyecto escolar)
- Encapsulacion
- Metodos getter y setter
- Herencia y polimorfismo
- sobrescritura de un metodo (override)
- Manejo de colecciones
- Diseño de arquitectura en capas
- Validación de entradas

## 📝 Descripcion:

Sistema de gestion escolar es una aplicacion de consola para administrar usuarios de un colegio. Permite registrar usuarios, asignar calificaciones, gestionar inscripciones y generar estadisticas academicas

## 📌 Clases Principales:

1. **Persona (Abstracta):** Base para Alumno, Profesor y Rector
2. **Alumno:** Puede inscribirse a materias y tiene calificaciones
3. **Profesor:** Puede impartir materias y calificar alumnos
4. **Rector:** Puede ver estadísticas de aprobacion y reprobacion
5. **Materia:** Contiene informacion sobre las asignaturas y sus alumnos
6. **Escuela:** Maneja el registro global de personas y materias

## 📌 Funcionalidades por Rol:

### ➡️ Para Alumnos:

* Inscribirse a materias
* Ver sus materias inscritas
* Ver sus calificaciones y estado (aprobado/reprobado)

### ➡️ Para Profesores:

* Impartir materias
* Ver alumnos inscritos en sus materias
* Asignar calificaciones a los alumnos
* Ver si los alumnos aprobaron o reprobaron

### ➡️ Para Rectores:

* Ver estadisticas generales de los alumnos

### ➡️ Sistema de Menus:
El sistema presenta un menú principal que permite:
1. Gestionar usuarios (alumnos, profesores, rectores)
2. Gestionar materias
3. Operaciones especificas para alumnos
4. Operaciones especificas para profesores
5. Operaciones especificas para rectores

## 📌 Como Usar el Sistema:

1. Al iniciar, selecciona la opcion "Registrar nuevo usuario" para crear alumnos, profesores y rectores
2. Luego crea materias y asígnales profesores
3. Inscribe alumnos a las materias
4. Como profesor, puedes calificar a los alumnos
5. Como rector, puedes ver las estadisticas generales

## 📝 Mejoras Futuras:
1. Agregar mas reportes y funcionalidades. 
2. Agregar persistencia de datos con bases de datos
3. Implementar una interfaz grafica (GUI)

## 🤝 Como Contribuir
1. Haz un fork del proyecto
2. Crea una rama (`git checkout -b feature/nueva-funcionalidad`)
3. Implementa tus cambios
4. Abre un Pull Request describiendo:
   - Problema resuelto
   - Cambios realizados
   - Capturas (si aplica)
