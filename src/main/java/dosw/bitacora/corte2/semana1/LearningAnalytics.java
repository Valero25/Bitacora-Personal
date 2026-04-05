package dosw.bitacora.corte2.semana1;

import java.util.*;
import java.util.stream.*;

/**
 * DOSW Learning Analytics System
 * Semana 1 - Corte 2: Programacion Funcional y Pruebas Unitarias
 *
 * Reglas:
 * - Prohibido usar ciclos for o while.
 * - Uso correcto de Streams API.
 */
public class LearningAnalytics {

    // -------------------------------------------------------------------------
    // Ejercicio 1: Obtener todos los estudiantes del equipo NARANJA
    // -------------------------------------------------------------------------
    public List<Student> getStudentsByTeamNaranja(List<Student> students) {
        return students.stream()
                .filter(s -> "NARANJA".equals(s.getTeam()))
                .collect(Collectors.toList());
    }

    // -------------------------------------------------------------------------
    // Ejercicio 2: Obtener todos los nombres de estudiantes ordenados alfabeticamente
    // -------------------------------------------------------------------------
    public List<String> getStudentNamesSortedAlphabetically(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    // -------------------------------------------------------------------------
    // Ejercicio 3: Calcular el promedio general de todos los scores del sistema
    // -------------------------------------------------------------------------
    public double calculateOverallAverage(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0.0);
    }

    // -------------------------------------------------------------------------
    // Ejercicio 4: Retornar por estudiante el promedio por materia
    //              Map<materia, promedio>
    // -------------------------------------------------------------------------
    public Map<String, Double> getAveragePerSubjectByStudent(Student student) {
        return student.getGrades().stream()
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ));
    }

    // -------------------------------------------------------------------------
    // Ejercicio 5: Retornar el estudiante con el promedio general mas alto
    // -------------------------------------------------------------------------
    public Optional<Student> getTopStudentByAverage(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(this::calculateStudentAverage));
    }

    // -------------------------------------------------------------------------
    // Ejercicio 6: Retornar materias reprobadas por equipo
    //              Map<equipo, cantidad de materias reprobadas>
    // -------------------------------------------------------------------------
    public Map<String, Long> getFailedSubjectsByTeam(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getTeam,
                        Collectors.summingLong(s -> s.getGrades().stream()
                                .filter(g -> !g.isPassed())
                                .count())
                ));
    }

    // -------------------------------------------------------------------------
    // Ejercicio 7: Top 3 estudiantes con mas materias aprobadas (orden descendente)
    // -------------------------------------------------------------------------
    public List<Student> getTop3StudentsByPassedSubjects(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingLong(
                        (Student s) -> s.getGrades().stream().filter(Grade::isPassed).count()
                ).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    // -------------------------------------------------------------------------
    // Ejercicio 8: Agrupar estudiantes por estado academico
    //   ALTO RENDIMIENTO -> promedio >= 4.5
    //   REGULAR          -> promedio entre 3.5 y 4.49
    //   RIESGO           -> promedio < 3.5
    // -------------------------------------------------------------------------
    public Map<String, List<Student>> groupStudentsByAcademicStatus(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> {
                    double avg = calculateStudentAverage(s);
                    if (avg >= 4.5) return "ALTO RENDIMIENTO";
                    if (avg >= 3.5) return "REGULAR";
                    return "RIESGO";
                }));
    }

    // -------------------------------------------------------------------------
    // Ejercicio 9: Obtener la materia con mas reprobaciones
    // -------------------------------------------------------------------------
    public Optional<String> getSubjectWithMostFailures(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .filter(g -> !g.isPassed())
                .collect(Collectors.groupingBy(Grade::getSubject, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // -------------------------------------------------------------------------
    // Ejercicio 10: Solo equipo NARANJA -> notas aprobadas -> promedio por materia
    //               ordenado descendente -> LinkedHashMap preservando orden
    // -------------------------------------------------------------------------
    public LinkedHashMap<String, Double> getPassedAverageBySubjectForNaranjaDescending(List<Student> students) {
        return students.stream()
                .filter(s -> "NARANJA".equals(s.getTeam()))
                .flatMap(s -> s.getGrades().stream())
                .filter(Grade::isPassed)
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    // -------------------------------------------------------------------------
    // Helper: calcular promedio general de un estudiante
    // -------------------------------------------------------------------------
    public double calculateStudentAverage(Student student) {
        return student.getGrades().stream()
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0.0);
    }
}
