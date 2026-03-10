<<<<<<< HEAD
# Semana 3

## Evidencia Técnica

- **Ejercicios de clase:** [Agregar descripción aquí]

- **Ejercicios de casa:** [Agregar descripción aquí]

## Código

[Agregar enlaces o descripciones de código aquí]
=======
# Semana 3

## Ejercicios Completados

### Ejercicio 1: Sistema de Procesamiento de Pagos
- **Patrón:** Factory Method
- **Descripción:** Sistema de comercio electrónico que procesa pagos mediante el método fábrica `createPayment()`. Cada procesador (CreditCard, PayPal, BankTransfer) decide qué tipo concreto de pago instanciar sin que el cliente conozca la implementación
- **Clases creadas:** 9
- **Ubicación:** [patrones/ejercicio1](patrones/ejercicio1/)

### Ejercicio 2: Componentes de Consolas de Juegos
- **Patrón:** Abstract Factory
- **Descripción:** Fábrica abstracta que crea familias de componentes (CPU, GPU, Controlador) para diferentes consolas (PlayStation, Xbox)
- **Clases creadas:** 14
- **Ubicación:** [patrones/ejercicio2](patrones/ejercicio2/)

### Ejercicio 3: Constructor de Muñecos de Juguete
- **Patrón:** Builder
- **Descripción:** Sistema para construir muñecos personalizados paso a paso (cabeza, cuerpo, brazos, piernas, accesorios)
- **Clases creadas:** 6
- **Ubicación:** [patrones/ejercicio3](patrones/ejercicio3/)

### Ejercicio 4: Gasolinera Inteligente
- **Patrón:** Adapter
- **Descripción:** Adaptadores que permiten que cargadores eléctricos (rápidos y lentos) funcionen con la interfaz estándar de suministro de combustible
- **Clases creadas:** 7
- **Ubicación:** [patrones/ejercicio4](patrones/ejercicio4/)

### Ejercicio 5: Sistema de Formas Geométricas
- **Patrón:** Bridge
- **Descripción:** Desacopla formas (Círculo, Cuadrado) de colores (Rojo, Azul) para combinarlas libremente sin explosión de clases
- **Clases creadas:** 7
- **Ubicación:** [patrones/ejercicio5](patrones/ejercicio5/)

### Ejercicio 6: Sistema de Gestión de Bodega
- **Patrón:** Composite
- **Descripción:** Gestión de productos individuales y cajas que pueden contener productos u otras cajas, calculando precios recursivamente
- **Clases creadas:** 4
- **Ubicación:** [patrones/ejercicio6](patrones/ejercicio6/)

### Ejercicio 7: Simulador de Batalla Naval
- **Patrón:** Decorator
- **Descripción:** Barcos que pueden equiparse dinámicamente con módulos adicionales (Blindaje +30 defensa, Radar +10 ataque, Misiles +40 ataque, AntiTorpedos +20 ataque) sin modificar la clase original. Los módulos se combinan mediante `Stream.reduce`
- **Clases creadas:** 8
- **Ubicación:** [patrones/ejercicio7](patrones/ejercicio7/)

### Ejercicio 8: Controles Migratorios - Embajada de Estados Unidos
- **Patrón:** Chain of Responsibility
- **Descripción:** Una persona atraviesa una cadena de controles migratorios (Pasaporte, Antecedentes, Motivo de viaje, Aprobación final). Cada control puede aprobar y pasar al siguiente, o rechazar y detener el proceso. El solicitante no conoce qué control lo rechaza ni cuántos existen
- **Clases creadas:** 8
- **Ubicación:** [patrones/ejercicio8](patrones/ejercicio8/)

### Ejercicio 9: Personajes de Videojuego
- **Patrón:** Command
- **Descripción:** Las acciones del personaje (caminar, saltar, atacar, defenderse) se encapsulan como comandos. El `GameController` ejecuta cualquier acción mediante `pressButton()` sin conocer su implementación interna. Se usa `List.forEach(controller::pressButton)` para ejecutar la secuencia
- **Clases creadas:** 8
- **Ubicación:** [patrones/ejercicio9](patrones/ejercicio9/)

### Ejercicio 10: Viaje a Roma
- **Patrón:** Iterator
- **Descripción:** Un turista recorre lugares emblemáticos de Roma (Colosseum, Roman Forum, Trevi Fountain, Pantheon, Spanish Steps) usando un iterador personalizado. La estructura interna del arreglo no se expone al cliente. `RomeIterator` es una clase independiente que recibe el arreglo por constructor
- **Clases creadas:** 7
- **Ubicación:** [patrones/ejercicio10](patrones/ejercicio10/)

### Ejercicio 11: Aplicación de Navegación
- **Patrón:** Strategy
- **Descripción:** Una app de navegación calcula rutas de distintas maneras (más rápida, más panorámica, más económica). El algoritmo se inyecta en `NavigationApp` y puede cambiarse en tiempo de ejecución con `setRouteStrategy()` sin modificar la aplicación
- **Clases creadas:** 6
- **Ubicación:** [patrones/ejercicio11](patrones/ejercicio11/)

---

## Complicaciones

### 1. Complejidad del Patrón Bridge
**Problema:** Entender la diferencia entre abstracción e implementación y cómo separarlas correctamente.

**Impacto:** Requirió análisis cuidadoso en el ejercicio 5 para identificar qué debe ir en cada jerarquía.

### 2. Recursividad en Composite
**Problema:** Implementar correctamente el cálculo recursivo de precios en la estructura de árbol.

**Impacto:** Necesitó atención especial en el método `getPrecio()` de la clase `Caja`.

### 3. Stream.reduce con tipos distintos en Decorator
**Problema:** Al usar `Stream<Function<Barco,Barco>>.reduce(barcoBase, ...)`, el compilador no acepta la forma de 2 argumentos porque el tipo identidad (`Barco`) difiere del tipo del stream (`Function<Barco,Barco>`).

**Impacto:** Se requirió la forma de 3 argumentos de `reduce` añadiendo un combinador `(b1, b2) -> b2`.

### 4. Clases internas en Iterator
**Problema:** La primera implementación de `RomeIterator` era una clase interna privada dentro de `TourRoute`, lo que dificulta la legibilidad y las pruebas.

**Impacto:** Se refactorizó a una clase independiente que recibe el arreglo `Place[]` por constructor.

### 5. Modelado de la cadena en Chain of Responsibility
**Problema:** Decidir si el handler abstracto debe exponer el siguiente eslabón como `protected` o gestionar el avance internamente.

**Impacto:** Se optó por un método `pasarAlSiguiente()` en el handler abstracto para que los controles concretos no dependan del campo `siguiente` directamente.

---

## Soluciones

### Separación Bridge
- **Abstracción:** Características que pueden evolucionar (Formas)
- **Implementación:** Detalles de bajo nivel (Colores)
- **Puente:** Composición en lugar de herencia

### Composite Pattern
- Interfaz común (`ItemBodega`) para hojas y compuestos
- Lista de componentes en la clase `Caja`
- Método `getPrecio()` recursivo que suma todos los elementos

### Decorator con Stream.reduce
- Usar la forma de 3 argumentos: `reduce(identidad, acumulador, combinador)`
- El combinador `(b1, b2) -> b2` satisface el compilador en streams secuenciales

### Iterator sin clases internas
- `RomeIterator` como clase de nivel superior recibe el arreglo por constructor
- `TourRoute` solo instancia `new RomeIterator(places)` en `createIterator()`

### Chain of Responsibility encapsulado
- Método `pasarAlSiguiente(request)` en el handler abstracto encapsula la delegación
- Los controles concretos solo llaman `pasarAlSiguiente()` sin acceder al campo `siguiente`

### Strategy intercambiable en tiempo de ejecución
- `NavigationApp` recibe la estrategia por constructor y la expone con `setRouteStrategy()`
- El cliente cambia el algoritmo sin tocar la clase de contexto

---

## Aprendizajes

### Patrones Estructurales
1. **Bridge:** Evita explosión de clases al separar abstracción de implementación
2. **Adapter:** Permite que interfaces incompatibles trabajen juntas
3. **Composite:** Trata objetos individuales y composiciones de manera uniforme
4. **Decorator:** Agrega responsabilidades a objetos de forma dinámica sin modificar su clase

### Patrones Creacionales
1. **Factory Method:** Delega la creación de objetos a subclases
2. **Abstract Factory:** Crea familias de objetos relacionados
3. **Builder:** Construye objetos complejos paso a paso

### Patrones de Comportamiento
1. **Chain of Responsibility:** Pasa solicitudes a lo largo de una cadena de manejadores
2. **Command:** Encapsula una acción como objeto, desacoplando emisor de receptor
3. **Iterator:** Recorre una colección sin exponer su estructura interna
4. **Strategy:** Define una familia de algoritmos intercambiables en tiempo de ejecución

### Principios de Diseño
- **Composición sobre herencia:** Los patrones favorecen composición para mayor flexibilidad
- **Programación a interfaces:** Permite cambiar implementaciones sin afectar clientes
- **Responsabilidad única:** Cada clase tiene un propósito claro y específico
- **Abierto/Cerrado:** Fácil agregar nuevos tipos sin modificar código existente

### Buenas Prácticas
- Usar clases separadas en lugar de clases internas para mejor organización
- Formatear salidas apropiadamente según el tipo de dato
- Documentar patrones y decisiones de diseño en comentarios
- Estructurar código en paquetes por ejercicio para claridad
- Preferir inyección por constructor para dependencias obligatorias

### Diferencias Clave Entre Patrones
- **Bridge vs Adapter:** Bridge se diseña desde el inicio, Adapter resuelve incompatibilidades existentes
- **Abstract Factory vs Factory Method:** Abstract Factory crea familias de objetos, Factory Method crea un tipo
- **Composite vs Decorator:** Composite estructura parte-todo, Decorator agrega responsabilidades
- **Chain of Responsibility vs Strategy:** CoR elige dinámicamente quién procesa, Strategy elige cómo procesar
- **Command vs Strategy:** Command encapsula una acción con su receptor, Strategy encapsula un algoritmo reemplazable

---

## Estadísticas

- **Total de ejercicios:** 11
- **Total de clases creadas:** 84
- **Patrones implementados:** 11 diferentes
- **Líneas de código:** ~1500+
- **Tiempo estimado:** 12-15 horas
>>>>>>> origin/master
