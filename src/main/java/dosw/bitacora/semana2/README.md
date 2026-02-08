# 📚 Semana 2

## ✅ Ejercicios Completados

### Patrones de Diseño

#### Ejercicio 1: Sistema de Notificaciones
- **Patrón:** Factory Method
- **Descripción:** Sistema que envía diferentes tipos de notificaciones (Email, SMS, Push) utilizando el patrón Factory Method para crear las instancias apropiadas
- **Clases creadas:** 6
- **Ubicación:** [patrones/ejercicio1](patrones/ejercicio1/)

#### Ejercicio 2: Sistema de Impresión
- **Patrón:** Adapter
- **Descripción:** Adaptadores que permiten usar diferentes tipos de impresoras (Epson, Canon) con una interfaz común de impresión moderna
- **Clases creadas:** 5
- **Ubicación:** [patrones/ejercicio2](patrones/ejercicio2/)

#### Ejercicio 3: Editor de Texto con Historial
- **Patrón:** Memento
- **Descripción:** Editor de texto que permite guardar y restaurar estados anteriores usando el patrón Memento para gestionar el historial de cambios
- **Clases creadas:** 4
- **Ubicación:** [patrones/ejercicio3](patrones/ejercicio3/)

### Principios SOLID

#### Ejercicio 4: Calculadora Extensible
- **Principios:** Open/Closed, Liskov Substitution
- **Descripción:** Calculadora que implementa operaciones (suma, resta, multiplicación, división) siguiendo principios SOLID, permitiendo agregar nuevas operaciones sin modificar el código existente
- **Clases creadas:** 7
- **Ubicación:** [solid/ejercicio4](solid/ejercicio4/)

### Ejercicios de Repaso

#### Ejercicio Repaso 1: Filtrado de Números
- **Descripción:** Sistema que filtra y procesa números pares e impares usando streams, con explicaciones paso a paso
- **Ubicación:** [repaso/EjercicioRepaso1.java](repaso/EjercicioRepaso1.java)

#### Ejercicio Repaso 2: Procesamiento de Palabras
- **Descripción:** Análisis de palabras (filtrar largas, convertir a mayúsculas, ordenar) con operaciones adicionales de streams
- **Ubicación:** [repaso/EjercicioRepaso2.java](repaso/EjercicioRepaso2.java)

#### Ejercicio Repaso 3: Gestión de Usuarios
- **Descripción:** Filtrado y procesamiento de usuarios con múltiples criterios (edad, email) usando streams
- **Ubicación:** [repaso/EjercicioRepaso3.java](repaso/EjercicioRepaso3.java)

---

## ⚠️ Complicaciones

### 1. Traducir Teoría a Código
**Problema:** Poder pasar la teoría a código.

**Impacto:** Requirió comprender bien los conceptos antes de implementarlos correctamente.

### 2. Comprensión del Patrón Memento
**Problema:** Entender cómo separar correctamente las responsabilidades entre Originator, Memento y Caretaker.

**Impacto:** Riesgo de exponer el estado interno del objeto incorrectamente.

### 3. Implementación de Principios SOLID
**Problema:** Aplicar correctamente el principio Open/Closed en la calculadora para permitir extensiones sin modificaciones.

**Impacto:** Necesitó diseñar una interfaz `Operation` apropiada para todas las operaciones.

---

## 💡 Soluciones

### Clases Separadas
Reorganizamos todos los ejercicios para usar clases independientes en lugar de clases internas:
- Cada clase en su propio archivo
- Mejor organización por paquetes (ejercicio1, ejercicio2, etc.)
- Facilita el mantenimiento y la comprensión del código

### Patrón Memento
Implementación correcta con tres componentes:
- **TextEditor (Originator):** Crea y restaura mementos
- **TextMemento (Memento):** Almacena el estado inmutable
- **History (Caretaker):** Gestiona la colección de mementos

### Principios SOLID en Calculadora
```java
// Interfaz Operation permite agregar operaciones sin modificar Calculator
public interface Operation {
    double execute(double a, double b);
}

// Calculator usa composición en lugar de múltiples métodos
public class Calculator {
    public double calculate(double a, double b, Operation operation) {
        return operation.execute(a, b);
    }
}
```

### Ejercicios de Repaso
Creamos ejercicios adicionales con:
- Explicaciones paso a paso de cada operación
- Comentarios detallados del flujo de datos
- Múltiples ejemplos de uso de streams

---

## 🎓 Aprendizajes

### Patrones de Diseño

#### Factory Method
- Delega la creación de objetos a subclases
- Útil cuando el tipo exacto de objeto no se conoce hasta tiempo de ejecución
- Ejemplo: `NotificationFactory` decide qué tipo de notificación crear

#### Adapter
- Convierte la interfaz de una clase en otra que el cliente espera
- Permite que clases incompatibles trabajen juntas
- Ejemplo: `EpsonAdapter` adapta `EpsonPrinter` a `ModernPrinter`

#### Memento
- Captura y externaliza el estado interno sin violar encapsulación
- Permite deshacer/rehacer operaciones
- Ejemplo: `TextEditor` guarda estados en `History`

### Principios SOLID

#### Single Responsibility Principle (SRP)
- Cada clase tiene una única razón para cambiar
- `Calculator` solo coordina, cada `Operation` implementa su lógica

#### Open/Closed Principle (OCP)
- Abierto para extensión, cerrado para modificación
- Agregar nueva operación: crear nueva clase, sin tocar `Calculator`

#### Liskov Substitution Principle (LSP)
- Las subclases deben ser sustituibles por sus clases base
- Todas las `Operation` implementan el mismo contrato

### Buenas Prácticas de Java

1. **Organización de Código:**
   - Un archivo por clase pública
   - Paquetes organizados por funcionalidad
   - Nombres descriptivos y consistentes

2. **Streams API:**
   - Uso de `filter()`, `map()`, `sorted()`, `collect()`
   - Operaciones intermedias vs terminales
   - Expresiones lambda concisas

3. **Diseño de Interfaces:**
   - Interfaces pequeñas y cohesivas
   - Métodos con propósito claro
   - Facilitan testing y extensibilidad

### Diferencias Entre Patrones Creacionales

- **Factory Method vs Abstract Factory:**
  - Factory Method: Un tipo de producto
  - Abstract Factory: Familias de productos relacionados

- **Factory vs Constructor:**
  - Factory: Mayor flexibilidad, puede retornar subtipos
  - Constructor: Siempre retorna instancia de esa clase exacta

### Aplicaciones Prácticas

1. **Factory Method:** Sistemas de logging, notificaciones, creación de documentos
2. **Adapter:** Integración con APIs legacy, wrappers de librerías externas
3. **Memento:** Editores de texto, juegos (save/load), sistemas de auditoría
4. **SOLID:** Cualquier aplicación que requiera mantenibilidad y extensibilidad


