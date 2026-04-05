package dosw.bitacora.corte2.semana1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DOSW Learning Analytics System - Tests")
class LearningAnalyticsTest {

    private LearningAnalytics analytics;
    private List<Student> students;

    @BeforeEach
    void setUp() {
        analytics = new LearningAnalytics();

        Student s1 = new Student("S1", "Ana Lopez", "NARANJA", Arrays.asList(
                new Grade("DOSW",  4.8, LocalDate.of(2026, 3, 1), true),
                new Grade("BD",    3.2, LocalDate.of(2026, 3, 2), false),
                new Grade("REDES", 4.5, LocalDate.of(2026, 3, 3), true)
        ));

        Student s2 = new Student("S2", "Carlos Perez", "NARANJA", Arrays.asList(
                new Grade("DOSW",  5.0, LocalDate.of(2026, 3, 1), true),
                new Grade("BD",    5.0, LocalDate.of(2026, 3, 2), true),
                new Grade("REDES", 5.0, LocalDate.of(2026, 3, 3), true)
        ));

        Student s3 = new Student("S3", "Beatriz Torres", "AZUL", Arrays.asList(
                new Grade("DOSW",  2.5, LocalDate.of(2026, 3, 1), false),
                new Grade("BD",    2.8, LocalDate.of(2026, 3, 2), false),
                new Grade("REDES", 3.8, LocalDate.of(2026, 3, 3), true)
        ));

        Student s4 = new Student("S4", "David Gomez", "VERDE", Arrays.asList(
                new Grade("DOSW",  4.5, LocalDate.of(2026, 3, 1), true),
                new Grade("BD",    4.6, LocalDate.of(2026, 3, 2), true),
                new Grade("REDES", 4.7, LocalDate.of(2026, 3, 3), true)
        ));

        Student s5 = new Student("S5", "Elena Ruiz", "NARANJA", Arrays.asList(
                new Grade("DOSW",  3.0, LocalDate.of(2026, 3, 1), false),
                new Grade("BD",    3.9, LocalDate.of(2026, 3, 2), true),
                new Grade("REDES", 4.0, LocalDate.of(2026, 3, 3), true)
        ));

        Student s6 = new Student("S6", "Fernando Castro", "AZUL", Arrays.asList(
                new Grade("DOSW",  2.0, LocalDate.of(2026, 3, 1), false),
                new Grade("BD",    4.5, LocalDate.of(2026, 3, 2), true),
                new Grade("REDES", 4.0, LocalDate.of(2026, 3, 3), true)
        ));

        students = Arrays.asList(s1, s2, s3, s4, s5, s6);
    }

    // -------------------------------------------------------------------------
    // Ejercicio 1
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 1: solo retorna estudiantes del equipo NARANJA")
    void testGetStudentsByTeamNaranja() {
        List<Student> result = analytics.getStudentsByTeamNaranja(students);

        assertEquals(3, result.size());
        assertTrue(result.stream().allMatch(s -> "NARANJA".equals(s.getTeam())));
    }

    @Test
    @DisplayName("Ejercicio 1: lista vacia si no hay estudiantes NARANJA")
    void testGetStudentsByTeamNaranjaEmpty() {
        List<Student> only = Collections.singletonList(
                new Student("X", "X", "AZUL", Collections.emptyList()));
        assertTrue(analytics.getStudentsByTeamNaranja(only).isEmpty());
    }

    // -------------------------------------------------------------------------
    // Ejercicio 2
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 2: nombres ordenados alfabeticamente")
    void testGetStudentNamesSortedAlphabetically() {
        List<String> result = analytics.getStudentNamesSortedAlphabetically(students);

        assertEquals(6, result.size());
        assertEquals("Ana Lopez",      result.get(0));
        assertEquals("Beatriz Torres", result.get(1));
        assertEquals("Carlos Perez",   result.get(2));
        assertEquals("David Gomez",    result.get(3));
        assertEquals("Elena Ruiz",     result.get(4));
        assertEquals("Fernando Castro",result.get(5));
    }

    // -------------------------------------------------------------------------
    // Ejercicio 3
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 3: promedio general es mayor que 0")
    void testCalculateOverallAverage() {
        double avg = analytics.calculateOverallAverage(students);
        assertTrue(avg > 0.0 && avg <= 5.0);
    }

    @Test
    @DisplayName("Ejercicio 3: promedio general lista vacia retorna 0.0")
    void testCalculateOverallAverageEmpty() {
        assertEquals(0.0, analytics.calculateOverallAverage(Collections.emptyList()));
    }

    // -------------------------------------------------------------------------
    // Ejercicio 4
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 4: retorna promedio por materia para un estudiante")
    void testGetAveragePerSubjectByStudent() {
        Student s2 = students.get(1); // Carlos Perez, todas 5.0
        Map<String, Double> result = analytics.getAveragePerSubjectByStudent(s2);

        assertEquals(3, result.size());
        assertEquals(5.0, result.get("DOSW"),  0.001);
        assertEquals(5.0, result.get("BD"),    0.001);
        assertEquals(5.0, result.get("REDES"), 0.001);
    }

    // -------------------------------------------------------------------------
    // Ejercicio 5
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 5: el estudiante con mayor promedio es Carlos Perez")
    void testGetTopStudentByAverage() {
        Optional<Student> result = analytics.getTopStudentByAverage(students);

        assertTrue(result.isPresent());
        assertEquals("Carlos Perez", result.get().getName());
    }

    @Test
    @DisplayName("Ejercicio 5: lista vacia retorna Optional vacio")
    void testGetTopStudentByAverageEmpty() {
        assertFalse(analytics.getTopStudentByAverage(Collections.emptyList()).isPresent());
    }

    // -------------------------------------------------------------------------
    // Ejercicio 6
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 6: materias reprobadas por equipo correctas")
    void testGetFailedSubjectsByTeam() {
        Map<String, Long> result = analytics.getFailedSubjectsByTeam(students);

        // NARANJA: Ana(BD) + Elena(DOSW) = 2
        assertEquals(2L, result.get("NARANJA"));
        // AZUL: Beatriz(DOSW+BD) + Fernando(DOSW) = 3
        assertEquals(3L, result.get("AZUL"));
        // VERDE: ninguna
        assertEquals(0L, result.get("VERDE"));
    }

    // -------------------------------------------------------------------------
    // Ejercicio 7
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 7: top 3 estudiantes con mas materias aprobadas")
    void testGetTop3StudentsByPassedSubjects() {
        List<Student> result = analytics.getTop3StudentsByPassedSubjects(students);

        assertEquals(3, result.size());
        // Los dos primeros deben tener 3 aprobadas cada uno
        long first  = result.get(0).getGrades().stream().filter(Grade::isPassed).count();
        long second = result.get(1).getGrades().stream().filter(Grade::isPassed).count();
        assertEquals(3L, first);
        assertEquals(3L, second);
    }

    // -------------------------------------------------------------------------
    // Ejercicio 8
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 8: clasifica correctamente en ALTO RENDIMIENTO, REGULAR, RIESGO")
    void testGroupStudentsByAcademicStatus() {
        Map<String, List<Student>> result = analytics.groupStudentsByAcademicStatus(students);

        // ALTO RENDIMIENTO: Carlos (5.0) y David (4.6)
        assertEquals(2, result.get("ALTO RENDIMIENTO").size());
        // REGULAR: Ana (4.167), Elena (3.633), Fernando (3.5)
        assertEquals(3, result.get("REGULAR").size());
        // RIESGO: Beatriz (3.033)
        assertEquals(1, result.get("RIESGO").size());
        assertEquals("Beatriz Torres", result.get("RIESGO").get(0).getName());
    }

    // -------------------------------------------------------------------------
    // Ejercicio 9
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 9: la materia con mas reprobaciones es DOSW")
    void testGetSubjectWithMostFailures() {
        Optional<String> result = analytics.getSubjectWithMostFailures(students);

        // DOSW: Ana no fallo, Beatriz si, Elena si, Fernando si = 3 fallas
        // BD  : Ana si, Beatriz si = 2 fallas
        assertTrue(result.isPresent());
        assertEquals("DOSW", result.get());
    }

    // -------------------------------------------------------------------------
    // Ejercicio 10
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Ejercicio 10: promedio por materia de NARANJA (aprobadas) ordenado desc")
    void testGetPassedAverageBySubjectForNaranjaDescending() {
        LinkedHashMap<String, Double> result =
                analytics.getPassedAverageBySubjectForNaranjaDescending(students);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        // Verificar que el orden es descendente por promedio
        List<Double> values = new ArrayList<>(result.values());
        for (int i = 0; i < values.size() - 1; i++) {
            assertTrue(values.get(i) >= values.get(i + 1),
                    "Los promedios deben estar en orden descendente");
        }

        // DOSW aprobadas NARANJA: Ana 4.8, Carlos 5.0 -> avg 4.9 (mayor)
        List<String> keys = new ArrayList<>(result.keySet());
        assertEquals("DOSW", keys.get(0));
    }

    @Test
    @DisplayName("Ejercicio 10: retorna LinkedHashMap (preserva orden)")
    void testGetPassedAverageReturnsLinkedHashMap() {
        Object result = analytics.getPassedAverageBySubjectForNaranjaDescending(students);
        assertInstanceOf(LinkedHashMap.class, result);
    }

    // -------------------------------------------------------------------------
    // Helper
    // -------------------------------------------------------------------------
    @Test
    @DisplayName("Helper: promedio de estudiante con todas 5.0 es 5.0")
    void testCalculateStudentAverage() {
        assertEquals(5.0, analytics.calculateStudentAverage(students.get(1)), 0.001);
    }
}
