# 📚 Semana 3

## ✅ Ejercicios Completados

### Ejercicio 1: Sistema de Procesamiento de Pagos
- **Patrón:** Bridge + Factory Method
- **Descripción:** Sistema que procesa pagos combinando diferentes métodos de pago (Tarjeta de Crédito, PayPal, Transferencia Bancaria) con diferentes procesadores (Nacional e Internacional)
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

---

## ⚠️ Complicaciones

### 1. Complejidad del Patrón Bridge
**Problema:** Entender la diferencia entre abstracción e implementación y cómo separarlas correctamente.

**Impacto:** Requirió análisis cuidadoso en ejercicios 1 y 5 para identificar qué debe ir en cada jerarquía.

### 2. Recursividad en Composite
**Problema:** Implementar correctamente el cálculo recursivo de precios en la estructura de árbol.

**Impacto:** Necesitó atención especial en el método `getPrecio()` de la clase Caja.

---

## 💡 Soluciones

### Separación Bridge
- **Abstracción:** Características que pueden evolucionar (Formas, Métodos de Pago)
- **Implementación:** Detalles de bajo nivel (Colores, Procesadores)
- **Puente:** Composición en lugar de herencia

### Composite Pattern
- Interfaz común (`ItemBodega`) para hojas y compuestos
- Lista de componentes en la clase `Caja`
- Método `getPrecio()` recursivo que suma todos los elementos

---

## 🎓 Aprendizajes

### Patrones Estructurales
1. **Bridge:** Evita explosión de clases al separar abstracción de implementación
2. **Adapter:** Permite que interfaces incompatibles trabajen juntas
3. **Composite:** Trata objetos individuales y composiciones de manera uniforme

### Patrones Creacionales
1. **Factory Method:** Delega la creación de objetos a subclases
2. **Abstract Factory:** Crea familias de objetos relacionados
3. **Builder:** Construye objetos complejos paso a paso

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

### Diferencias Clave Entre Patrones
- **Bridge vs Adapter:** Bridge se diseña desde el inicio, Adapter resuelve incompatibilidades existentes
- **Abstract Factory vs Factory Method:** Abstract Factory crea familias de objetos, Factory Method crea un tipo
- **Composite vs Decorator:** Composite estructura parte-todo, Decorator agrega responsabilidades

---

## 📊 Estadísticas

- **Total de ejercicios:** 6
- **Total de clases creadas:** 47
- **Patrones implementados:** 6 diferentes
- **Líneas de código:** ~800+
- **Tiempo estimado:** 6-8 horas
