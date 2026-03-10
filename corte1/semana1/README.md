# Semana 1

## Ejercicios Completados

### Ejercicio 1: Filtrado de Números Pares
- **Tema:** Streams API - Operación `filter()`
- **Descripción:** Filtrar números pares de una lista usando streams
- **Ubicación:** [streams/Ejercicio1.java](streams/Ejercicio1.java)

### Ejercicio 2: Conversión a Mayúsculas
- **Tema:** Streams API - Operación `map()`
- **Descripción:** Convertir nombres a mayúsculas utilizando map
- **Ubicación:** [streams/Ejercicio2.java](streams/Ejercicio2.java)

### Ejercicio 3: Ordenamiento de Números
- **Tema:** Streams API - Operación `sorted()`
- **Descripción:** Ordenar números de manera ascendente
- **Ubicación:** [streams/Ejercicio3.java](streams/Ejercicio3.java)

### Ejercicio 4: Suma de Números
- **Tema:** Streams API - Operación `reduce()`
- **Descripción:** Calcular la suma total de una lista de números
- **Ubicación:** [streams/Ejercicio4.java](streams/Ejercicio4.java)

### Ejercicio 5: Filtrado de Nombres Largos
- **Tema:** Streams API - Combinación de operaciones
- **Descripción:** Filtrar nombres con más de 5 caracteres
- **Ubicación:** [streams/Ejercicio5.java](streams/Ejercicio5.java)

### Ejercicio 6: Procesamiento Completo
- **Tema:** Streams API - Pipeline completo
- **Descripción:** Combinar múltiples operaciones (filter, map, sorted, collect)
- **Ubicación:** [streams/Ejercicio6.java](streams/Ejercicio6.java)

---

## Complicaciones

### 1. Estructura del Proyecto
**Problema:** Dificultad para establecer la estructura adecuada de la bitácora tanto localmente como en GitHub.

**Impacto:** Desorganización inicial del repositorio y archivos dispersos.

### 2. Configuración de Maven e IntelliJ
**Problema:** Nuevos requisitos técnicos como Maven y su configuración en IntelliJ presentaron desafíos.

**Impacto:** Retrasos en el inicio del desarrollo y errores de compilación.

### 3. Gestión con Git y GitHub
**Problema:** Falta de experiencia con comandos de Git y flujo de trabajo con ramas.

**Impacto:** Dificultad para subir ejercicios y mantener un historial ordenado.

### 4. Curva de Aprendizaje
**Problema:** Nuevo contenido de programación funcional y Streams API para algunos estudiantes.

**Impacto:** Requirió tiempo adicional para comprender los conceptos antes de implementarlos.

---

## Soluciones

### Colaboración y Apoyo
- **Compañeros de clase:** Colaboración para resolver problemas de estructura y organización
- **Profesor:** Guía para configuración de Maven e IntelliJ
- **Recursos en línea:** Búsqueda de tutoriales y documentación oficial

### Herramientas de IA
- **Asistencia en código:** Uso de inteligencia artificial para entender conceptos de programación funcional
- **Comandos Git:** Ayuda para aprender y aplicar comandos de Git y GitHub correctamente
- **Resolución de errores:** Apoyo para identificar y corregir problemas de compilación

### Metodología de Prueba y Error
- **Commits frecuentes:** Práctica de commits pequeños y frecuentes para experimentar
- **Ramas de prueba:** Uso de ramas para probar sin afectar el código principal
- **Aprendizaje iterativo:** Aceptar errores como parte del proceso de aprendizaje

---

## Aprendizajes

### Streams API de Java

#### Operaciones Básicas
- **filter():** Filtrar elementos según criterios específicos
- **map():** Transformar elementos de un tipo a otro
- **sorted():** Ordenar elementos de forma natural o personalizada
- **reduce():** Reducir colección a un único valor mediante operación acumulativa
- **collect():** Recolectar resultados en estructuras de datos

#### Programación Funcional
- **Expresiones Lambda:** Sintaxis concisa para funciones anónimas
- **Inmutabilidad:** Los streams no modifican la colección original
- **Operaciones Intermedias vs Terminales:** 
  - Intermedias: filter, map, sorted (lazy evaluation)
  - Terminales: collect, forEach, reduce (desencadenan ejecución)

### Git y GitHub

#### Comandos Fundamentales
- `git init`, `git add`, `git commit`: Gestión básica de repositorio local
- `git branch`, `git checkout`: Trabajo con ramas
- `git push`, `git pull`: Sincronización con repositorio remoto
- `git status`, `git log`: Inspección de estado e historial

#### Flujo de Trabajo
- Uso de ramas feature para desarrollo independiente
- Commits descriptivos para historial claro
- Push regular para respaldo y colaboración

### Maven y Gestión de Proyectos

#### Configuración Básica
- **pom.xml:** Archivo de configuración del proyecto
- **Dependencias:** Gestión automática de librerías
- **Estructura estándar:** src/main/java para código fuente
- **Compilación:** `mvn compile` para compilar el proyecto
- **Ejecución:** Uso de `java -cp` para ejecutar clases compiladas

### Buenas Prácticas

1. **Experimentación segura:** Usar commits frecuentes permite probar sin miedo
2. **Organización desde el inicio:** Estructura clara facilita mantenimiento
3. **Documentación continua:** README actualizado ayuda a recordar aprendizajes
4. **Buscar ayuda:** Colaboración y recursos externos aceleran aprendizaje
5. **Aprender de errores:** Los errores son oportunidades de mejora

### Herramientas de IA en Desarrollo

- **Asistencia en aprendizaje:** Explicaciones claras de conceptos complejos
- **Resolución de problemas:** Identificación rápida de errores
- **Mejores prácticas:** Sugerencias de código idiomático
- **Automatización:** Tareas repetitivas se simplifican

---

## Reflexión Final

La Semana 1 representó una introducción fundamental a herramientas y conceptos esenciales para el desarrollo de software moderno. Aunque hubo múltiples desafíos técnicos, la combinación de colaboración, recursos en línea y herramientas de IA permitió superarlos exitosamente. El aprendizaje de Streams API estableció las bases para programación funcional en Java, mientras que Git/GitHub y Maven se convirtieron en herramientas indispensables para el resto del curso.
