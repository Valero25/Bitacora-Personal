# Repaso Parcial  Patrones de Diseño (Semana 3)

Carpeta de referencia rápida con ejemplos mínimos de los **11 patrones** vistos en semana 3,  
más **3 combinaciones** frecuentes en proyectos reales.

---

## Estructura

```
repaso/
 base/
    factorymethod/        Patrón 1  Factory Method
    abstractfactory/      Patrón 2  Abstract Factory
    builder/              Patrón 3  Builder
    adapter/              Patrón 4  Adapter
    bridge/               Patrón 5  Bridge
    composite/            Patrón 6  Composite
    decorator/            Patrón 7  Decorator
    chainofresponsibility/ Patrón 8  Chain of Responsibility
    command/              Patrón 9  Command
    iterator/             Patrón 10  Iterator
    strategy/             Patrón 11  Strategy
 combinaciones/
     combo1/               Factory Method + Strategy
     combo2/               Builder + Decorator
     combo3/               Command + Iterator
```

---

## Patrones Base

### 1. Factory Method
**Propósito:** Delegar la creación de objetos a subclases; el código cliente trabaja con la interfaz, no con clases concretas.

**Estructura mínima:**
```
Notificacion (interfaz producto)
 NotificacionEmail
 NotificacionSMS
Notificador (clase abstracta  creator con crearNotificacion())
 NotificadorEmail
 NotificadorSMS
```

**Clave:** El método `crearNotificacion()` es el Factory Method. La subclase decide qué objeto producir.

---

### 2. Abstract Factory
**Propósito:** Crear familias de objetos relacionados sin especificar sus clases concretas.

**Estructura mínima:**
```
FabricaMuebles (interfaz fábrica abstracta)
 FabricaModerna   SillaModerna, MesaModerna
 FabricaVictoriana  SillaVictoriana, MesaVictoriana
Silla / Mesa (interfaces de producto)
```

**Clave:** La fábrica garantiza compatibilidad entre los productos de la misma familia.

---

### 3. Builder
**Propósito:** Construir objetos complejos paso a paso; separar la construcción de la representación.

**Estructura mínima:**
```
Computadora (producto final)
ComputadoraBuilder (builder con métodos encadenables)
 ComputadoraGaming
 ComputadoraOficina
Ensamblador (director  opcional, organiza los pasos)
```

**Clave:** El Builder retorna `this` en cada método para encadenamiento fluido; `build()` entrega el objeto.

---

### 4. Adapter
**Propósito:** Hacer compatibles dos interfaces incompatibles sin modificar el código existente.

**Estructura mínima:**
```
Reproductor (interfaz objetivo)
ReproductorLegacy (clase existente incompatible)
ReproductorAdapter implements Reproductor
   delega a ReproductorLegacy
```

**Clave:** El Adapter traduce llamadas de la interfaz nueva a la antigua.

---

### 5. Bridge
**Propósito:** Separar una abstracción de su implementación para que ambas puedan variar independientemente.

**Estructura mínima:**
```
Renderer (implementación  interfaz)
 RendererVectorial
 RendererRaster
Forma (abstracción  tiene un Renderer)
 Circulo
 Cuadrado
```

**Clave:** La abstracción (`Forma`) tiene una referencia al `Renderer`; no hereda de él.

---

### 6. Composite
**Propósito:** Tratar objetos individuales y composiciones de objetos de forma uniforme (árbol parte-todo).

**Estructura mínima:**
```
Componente (interfaz común)
 Archivo   (hoja  sin hijos)
 Carpeta   (nodo  contiene Componentes)
```

**Clave:** `Carpeta.mostrar()` itera sus hijos y llama `mostrar()` en cada uno, recursivamente.

---

### 7. Decorator
**Propósito:** Agregar responsabilidades a un objeto dinámicamente, como alternativa a la herencia.

**Estructura mínima:**
```
Cafe (interfaz)
CafeSimple (componente concreto)
CafeDecorador (decorador base  implementa Cafe y tiene un Cafe)
 Leche
 Caramelo
```

**Clave:** El decorador envuelve (`wraps`) al componente y añade comportamiento antes/después.

---

### 8. Chain of Responsibility
**Propósito:** Pasar una solicitud por una cadena de manejadores; cada uno decide si la procesa o la pasa.

**Estructura mínima:**
```
Aprobador (interfaz handler)
AprobadorBase (handler abstracto  guarda referencia al siguiente)
 Supervisor   (aprueba  $500)
 Gerente      (aprueba  $5000)
 Director     (aprueba todo)
```

**Clave:** `setSiguiente()` conecta los eslabones; `pasarAlSiguiente()` propaga la solicitud.

---

### 9. Command
**Propósito:** Encapsular una solicitud como objeto, permitiendo parametrizar, encolar y deshacer operaciones.

**Estructura mínima:**
```
Comando (interfaz  ejecutar())
Luz (receptor  sabe cómo hacer el trabajo)
 EncenderLuz implements Comando
 ApagarLuz   implements Comando
ControlRemoto (invocador  presiona comandos sin saber qué hacen)
```

**Clave:** El invocador solo conoce la interfaz `Comando`, no las clases concretas ni el receptor.

---

### 10. Iterator
**Propósito:** Proporcionar acceso secuencial a elementos de una colección sin exponer su representación interna.

**Estructura mínima:**
```
Iterador<T> (interfaz  hasNext(), next())
Coleccion<T> (interfaz  crearIterador())
ListaNumeros implements Coleccion<Integer>
NumerosIterador implements Iterador<Integer>
```

**Clave:** La colección crea su propio iterador; el cliente solo usa `hasNext`/`next`.

---

### 11. Strategy
**Propósito:** Definir una familia de algoritmos intercambiables y encapsular cada uno.

**Estructura mínima:**
```
Ordenamiento (estrategia  ordenar(int[]))
 OrdenamientoBurbuja
 OrdenamientoQuick
Sorter (contexto  tiene un Ordenamiento, setEstrategia() en runtime)
```

**Clave:** El contexto delega la ejecución a la estrategia; se puede cambiar en tiempo de ejecución.

---

## Combinaciones

### Combo 1  Factory Method + Strategy
**Por qué juntos?**  
Factory Method crea el objeto correcto  Strategy define qué hace ese objeto.  
Útil cuando el algoritmo a usar depende de qué tipo de objeto se creó.

**Ejemplo:** App de navegación  `BiciCreador` produce `RutaBici`; `AutoCreador` produce `RutaAuto`.  
El método `navegar()` usa el Factory Method internamente y luego ejecuta la Strategy.

```
TransporteCreador (abstract  Factory Method: crearEstrategia())
 AutoCreador   RutaAuto  implements TransporteStrategy
 BiciCreador   RutaBici
 BusCreador    RutaBus
```

**Punto de unión:** `crearEstrategia()` es Factory Method; `calcularRuta()` es Strategy.

---

### Combo 2  Builder + Decorator
**Por qué juntos?**  
Builder crea el objeto base con sus atributos esenciales  Decorator agrega características opcionales sin tocar la clase base.  
Evita la explosión de subclases para cada combinación de opciones.

**Ejemplo:** Pizzería  `PizzaBuilder` construye la pizza base (`tamano`, `masa`, `salsa`),  
luego `ToppingQueso` y `ToppingJamon` la decoran dinámicamente.

```
PizzaBuilder  PizzaBase implements Pizza
ToppingDecorador (abstract, implements Pizza, tiene un Pizza)
 ToppingQueso
 ToppingJamon
```

**Punto de unión:** Builder produce el componente base que el Decorator envuelve.

---

### Combo 3  Command + Iterator
**Por qué juntos?**  
Command convierte acciones en objetos almacenables  Iterator recorre esos objetos para ejecutarlos en orden.  
Patrón clásico para macros, replay de acciones o sistemas de undo-redo.

**Ejemplo:** Editor de texto  `MacroGrabador` almacena `EscribirAccion` y `BorrarAccion` (Commands).  
`HistorialIterador` recorre la lista y ejecuta cada acción en secuencia.

```
Accion (Command interface  ejecutar())
 EscribirAccion
 BorrarAccion
MacroGrabador (invocador  graba y expone iterador)
HistorialIterador implements IteradorAcciones
```

**Punto de unión:** `MacroGrabador.iterador()` devuelve un Iterator sobre la lista de Commands.

---

## Cómo ejecutar

```bash
# Compilar todo
mvn compile -q

# Ejecutar un ejemplo base
mvn exec:java "-Dexec.mainClass=dosw.bitacora.semana3.repaso.base.strategy.RepasoStrategy"

# Ejecutar una combinación
mvn exec:java "-Dexec.mainClass=dosw.bitacora.semana3.repaso.combinaciones.combo3.Combo3CommandIterator"
```

---

## Cuándo usar cada patrón

| Patrón | Señal de uso |
|---|---|
| Factory Method | Necesito crear objetos pero la subclase elige cuáles |
| Abstract Factory | Necesito familias de objetos compatibles entre sí |
| Builder | El objeto tiene muchos parámetros opcionales |
| Adapter | Tengo código legacy incompatible con la interfaz nueva |
| Bridge | Quiero variar abstracción e implementación independientemente |
| Composite | Tengo estructuras árbol con operaciones uniformes |
| Decorator | Quiero agregar comportamiento sin modificar la clase |
| Chain of Responsibility | Una solicitud puede ser manejada por varios objetos |
| Command | Necesito encolar, registrar o deshacer operaciones |
| Iterator | Necesito recorrer una colección sin exponer su internos |
| Strategy | El algoritmo debe ser intercambiable en runtime |
