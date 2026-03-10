# Bitacora Personal

Esta es mi bitacora personal para practicar y mejorar en programacion. Esta organizada por **cortes academicos**, y dentro de cada corte se encuentran las semanas trabajadas con sus ejercicios y evidencias.

## Estructura

```
corte1/          <- Primer periodo academico (semanas 1-5)
  semana1/         (rama: feature/semana1)
  semana2/         (rama: feature/semana2)
  semana3/         (rama: feature/semana3)
  semana5/         (rama: feature/semana5)

corte2/          <- Segundo periodo academico (semana 6 en adelante)
  semana6/         (proximamente)
  ...

src/             <- Codigo fuente Java organizado por semana
  main/java/dosw/bitacora/semanaX/
```

## Como usar
- Cada semana tiene su carpeta dentro del corte correspondiente con un `README.md` de evidencia.
- El codigo fuente vive en `src/main/java/dosw/bitacora/semanaX/`.
- Usa GitFlow: cada semana crea una rama `feature/semanaX` desde `develop`, trabaja en ella, y mezclala de vuelta a `develop`.
- Haz commits regulares para rastrear el progreso.

## Especificaciones
- **Codigo en repositorio Git**: Todo el codigo se almacena aqui.
- **Ejercicios resueltos**: Incluyen ejercicios de clase y casa, con evidencia en el README de cada semana.
- **GitFlow**: Usa ramas feature para cada semana, mezcladas en `develop`.
- **Cortes**: El repositorio esta dividido en `/corte1` y `/corte2` para organizar los periodos academicos.
