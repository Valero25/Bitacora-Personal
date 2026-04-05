# Semana 1 - DOSW Learning Analytics System

## Descripcion

Sistema de analisis academico que procesa informacion de estudiantes y calificaciones
utilizando exclusivamente la Streams API de Java. El ejercicio prohibe el uso de
bucles `for` y `while` para forzar el uso del paradigma funcional.

---

## Requisitos Tecnicos

| Requisito | Detalle |
|-----------|---------|
| Lenguaje | Java 11 |
| Build tool | Maven |
| Pruebas unitarias | JUnit 5 (cobertura minima 80%) |
| Restriccion | Sin bucles `for` ni `while` |
| Paradigma | Programacion funcional - Streams API |
| Control de versiones | GitFlow |

---

## Estructura del Paquete

```
dosw.bitacora.corte2.semana1
|-- Student.java           Modelo de estudiante
|-- Grade.java             Modelo de calificacion
|-- LearningAnalytics.java Logica con 10 ejercicios Streams
```

**Tests**

```
src/test/.../corte2/semana1
|-- LearningAnalyticsTest.java
```

---

## Modelo de Datos

### Student

| Campo | Tipo | Descripcion |
|-------|------|-------------|
| id | String | Identificador unico |
| name | String | Nombre completo |
| team | String | Equipo (NARANJA, AZUL, VERDE) |
| grades | List\<Grade\> | Lista de calificaciones |

### Grade

| Campo | Tipo | Descripcion |
|-------|------|-------------|
| subject | String | Nombre de la materia |
| score | double | Nota numerica (0.0 - 5.0) |
| date | LocalDate | Fecha de evaluacion |
| passed | boolean | Estado de aprobacion |

---

## Ejercicios

| N | Metodo | Descripcion |
|---|--------|-------------|
| 1 | `getStudentsByTeamNaranja` | Filtra estudiantes cuyo equipo sea NARANJA |
| 2 | `getStudentNamesSortedAlphabetically` | Retorna nombres ordenados alfabeticamente |
| 3 | `calculateOverallAverage` | Calcula el promedio general de todas las calificaciones |
| 4 | `getAveragePerSubjectByStudent` | Promedio por materia para un estudiante especifico |
| 5 | `getTopStudentByAverage` | Estudiante con el mayor promedio global |
| 6 | `getFailedSubjectsByTeam` | Cantidad de materias reprobadas agrupadas por equipo |
| 7 | `getTop3StudentsByPassedSubjects` | Top 3 estudiantes con mas materias aprobadas |
| 8 | `groupStudentsByAcademicStatus` | Agrupa: ALTO RENDIMIENTO (>=4.5), REGULAR (3.5-4.49), RIESGO (<3.5) |
| 9 | `getSubjectWithMostFailures` | Materia con mayor numero de reprobaciones |
| 10 | `getPassedAverageBySubjectForNaranjaDescending` | Promedio de aprobadas por materia para equipo NARANJA, ordenado desc |

---

## Codigo Fuente

| Archivo | Ubicacion |
|---------|-----------|
| Student.java | [Student.java](../../src/main/java/dosw/bitacora/corte2/semana1/Student.java) |
| Grade.java | [Grade.java](../../src/main/java/dosw/bitacora/corte2/semana1/Grade.java) |
| LearningAnalytics.java | [LearningAnalytics.java](../../src/main/java/dosw/bitacora/corte2/semana1/LearningAnalytics.java) |
| LearningAnalyticsTest.java | [LearningAnalyticsTest.java](../../src/test/java/dosw/bitacora/corte2/semana1/LearningAnalyticsTest.java) |

---

## Ejecucion

```bash
# Compilar
mvn compile

# Ejecutar pruebas
mvn test

# Verificar cobertura
mvn test -Dcobertura
```
