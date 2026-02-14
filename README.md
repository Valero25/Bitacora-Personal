# Bitácora Personal - Desarrollo de Software

> _Un viaje de aprendizaje semana a semana, donde la teoría se convierte en código y los errores se transforman en experiencia._

## ¿Qué es esto?

Esta bitácora es mi laboratorio personal de programación: un espacio donde experimento, aprendo y crezco como desarrollador. Cada semana representa un nuevo desafío, desde los fundamentos de programación funcional hasta patrones de diseño avanzados.

No es solo una colección de ejercicios, es un registro vivo de mi evolución como programador, documentando tanto los éxitos como los obstáculos encontrados en el camino.

## Contenido

### Semana 1: Fundamentos con Streams API
Descubriendo el poder de la programación funcional en Java. De filtrar números pares a construir pipelines completos de transformación de datos.

### Semana 2: Patrones de Diseño y SOLID
Aprendiendo a construir código mantenible y escalable. Factory Method, Adapter, Memento y los principios que todo desarrollador debe conocer.

### Semana 3: Patrones Estructurales Avanzados
Dominando Bridge, Composite, Builder y Abstract Factory. Seis ejercicios que demuestran cómo el buen diseño simplifica la complejidad.

## Tecnologías

- **Java 11+** - Lenguaje principal
- **Maven** - Gestión de proyecto y dependencias
- **Git/GitHub** - Control de versiones con GitFlow
- **VS Code** - Entorno de desarrollo
- **IntelliJ IDEA** - IDE alternativo para desarrollo

## Filosofía del Proyecto

```
Pensar → Codificar → Romper → Arreglar → Documentar → Repetir
```

Este repositorio celebra el proceso de aprendizaje completo, no solo el resultado final. Cada commit es un paso adelante, cada error es una lección aprendida.

## Estructura del Proyecto

```
src/main/java/dosw/bitacora/
├── semana1/          # Streams API y programación funcional
├── semana2/          # Patrones de diseño + SOLID
└── semana3/          # Patrones estructurales avanzados
```

Cada carpeta semanal incluye su propio README con:
- Ejercicios completados
- Complicaciones encontradas  
- Soluciones aplicadas
- Aprendizajes clave

## Workflow

Siguiendo GitFlow para mantener un desarrollo organizado:

1. **Feature branches** para cada semana (`feature/semana1`, `feature/semana2`, etc.)
2. **Commits frecuentes** para capturar el progreso incremental
3. **READMEs actualizados** documentando el viaje de aprendizaje
4. **Merge a develop** al completar cada semana

## Cómo Ejecutar

```bash
# Compilar el proyecto
mvn compile

# Ejecutar un ejercicio específico
java -cp target/classes dosw.bitacora.semana3.patrones.ejercicio1.Ejercicio1
```

## Lo que hace especial este proyecto

- **Documentación honesta**: No solo código perfecto, sino el proceso real de aprendizaje
- **Progresión visible**: De conceptos básicos a patrones avanzados
- **Organización clara**: Cada semana es un módulo independiente y autocontenido
- **Aprendizaje iterativo**: Construyendo sobre conocimientos previos semana tras semana

---

_"El código es poesía, los patrones son su gramática, y esta bitácora es mi cuaderno de práctica."_
