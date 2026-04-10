# Semana 3 — Refuerzo: Análisis de Requerimientos (Parte 1)

## Escenario 1: Plataforma de Batallas Bakugan

### Descripción del proyecto

Una startup quiere lanzar una aplicación web para fanáticos de Bakugan, donde los usuarios puedan coleccionar criaturas, mejorarlas y enfrentarse en combates estratégicos. El sistema debe incluir mecánicas de progresión, gestión de inventario y enfrentamientos entre jugadores.

Los combates **no requieren ser en tiempo real**, pero sí deben mantener **consistencia en los resultados**.

### Inquietudes del cliente

1. **Balance entre criaturas y habilidades** — que ninguna criatura o habilidad sea dominante sobre las demás.
2. **Emparejamientos justos entre jugadores** — que los enfrentamientos se den entre jugadores de nivel y fuerza similares.

---

## Análisis de Requerimientos

### Requerimientos Funcionales

| ID    | Requerimiento                                                                                         | Prioridad |
|-------|-------------------------------------------------------------------------------------------------------|-----------|
| RF-01 | El sistema debe permitir a los usuarios registrarse e iniciar sesión.                                 | Alta      |
| RF-02 | El usuario debe poder coleccionar criaturas Bakugan (obtenerlas por recompensas, tienda o eventos).   | Alta      |
| RF-03 | El usuario debe poder ver y gestionar su inventario de criaturas y objetos.                           | Alta      |
| RF-04 | El sistema debe permitir mejorar criaturas (subir nivel, evolucionar, equipar habilidades).           | Alta      |
| RF-05 | El sistema debe permitir enfrentamientos estratégicos entre dos jugadores (PvP por turnos).           | Alta      |
| RF-06 | Los resultados de batalla deben ser consistentes y deterministas dado el mismo estado inicial.         | Alta      |
| RF-07 | El sistema debe emparejar jugadores de forma justa basándose en un sistema de ranking/ELO.            | Alta      |
| RF-08 | El usuario debe poder consultar su historial de batallas y estadísticas.                              | Media     |
| RF-09 | El sistema debe ofrecer mecánicas de progresión (experiencia, niveles, logros).                       | Media     |
| RF-10 | El sistema debe notificar al usuario sobre resultados de batallas y eventos relevantes.               | Baja      |

### Requerimientos No Funcionales

| ID     | Requerimiento                                                                                        | Categoría       |
|--------|------------------------------------------------------------------------------------------------------|-----------------|
| RNF-01 | Las batallas deben resolverse en menos de 5 segundos en el servidor.                                 | Rendimiento     |
| RNF-02 | El sistema debe soportar al menos 1,000 usuarios concurrentes.                                       | Escalabilidad   |
| RNF-03 | Los datos de inventario y progresión deben persistir sin pérdida ante fallos.                         | Confiabilidad   |
| RNF-04 | La interfaz debe ser responsive y accesible desde navegadores móviles y de escritorio.                | Usabilidad      |
| RNF-05 | Las contraseñas y datos sensibles deben almacenarse cifrados.                                        | Seguridad       |
| RNF-06 | El sistema de balance debe ser configurable sin necesidad de redesplegar la aplicación.               | Mantenibilidad  |

---

## Abordando las inquietudes del cliente

### 1. Balance entre criaturas y habilidades

- **Sistema de tipos con ventajas/desventajas** — Cada criatura pertenece a un tipo (fuego, agua, tierra, etc.) con relaciones de fortaleza y debilidad, evitando que un solo tipo domine.
- **Estadísticas base equilibradas** — Las criaturas tienen stats (ataque, defensa, velocidad, HP) diseñados para que ninguna sea superior en todos los aspectos.
- **Habilidades con costo/beneficio** — Las habilidades más poderosas tienen mayor costo de energía o efectos secundarios negativos.
- **Datos de batalla para ajuste continuo** — Registrar tasas de victoria por criatura/habilidad para detectar desbalances y ajustar mediante parches de balance (RNF-06).

### 2. Emparejamientos justos

- **Sistema de rating ELO** — Cada jugador tiene un puntaje que sube o baja según victorias y derrotas. El matchmaking empareja jugadores con ELO similar.
- **Rango de búsqueda progresivo** — Si no hay oponente cercano en ELO, el rango se amplía gradualmente para reducir tiempos de espera.
- **Penalización por diferencia de poder** — Considerar no solo el ELO sino también el poder total del equipo (suma de niveles/stats de las criaturas seleccionadas).
- **Temporadas competitivas** — Reinicio periódico parcial del ELO para mantener la competitividad y evitar estancamiento en rankings.

---

## Modelo de dominio (entidades principales)

```
Usuario
├── id, nombre, email, contraseña
├── nivel, experiencia, ELO
└── inventario[] ──> Criatura

Criatura
├── id, nombre, tipo, rareza
├── nivel, experiencia
├── stats (HP, ataque, defensa, velocidad)
└── habilidades[] ──> Habilidad

Habilidad
├── id, nombre, tipo, poder
├── costoEnergia, precisión
└── efectoSecundario (opcional)

Batalla
├── id, fecha
├── jugador1, jugador2
├── equipoJ1[], equipoJ2[]
├── turno[], resultado
└── cambioELO

Turno
├── número, criaturasActivas
├── accionJ1, accionJ2
└── resultadoTurno
```

---

## Evidencia

- Identificación de requerimientos funcionales y no funcionales a partir del escenario propuesto.
- Propuestas concretas para las inquietudes del cliente (balance y matchmaking).
- Modelo de dominio inicial con las entidades principales del sistema.

---

## Enlaces de referencia

- [ECI-SportLife](https://github.com/Valero25/ECI-SportLife.git)
- [Tech-Cup-DOSW-2026-1](https://github.com/JoshQ10/Tech-Cup-DOSW-2026-1.git)
- [Diagrama Lucidchart](https://lucid.app/lucidchart/d035776f-7c94-4150-9fb5-55bcacb674df/edit?invitationId=inv_ccfbc0fd-443f-4d4f-b7a1-53f4693b6fe2&page=RtlHv1IFQLn~#)
