# Semana 2 - Refuerzo de Combinación de Patrones de Diseño

Versión: 1.0.0 | Corte: 2 | Semana: 2

---

## Descripción

El objetivo de este refuerzo es practicar la **combinación de patrones de diseño** dentro de un mismo sistema, entendiendo cómo se complementan para resolver problemas reales de software.

El módulo contiene **dos ejercicios integrales** que demuestran cómo múltiples patrones trabajan conjuntamente para crear sistemas escalables, mantenibles y extensibles.

---

## Competencias Desarrolladas

- Identificación de patrones de diseño en contextos empresariales
- Combinación efectiva de múltiples patrones en una solución
- Arquitectura de software extensible y flexible
- Documentación técnica de soluciones
- Testing unitario con JUnit 5
- Análisis y cobertura de código

---

## Estructura del Proyecto

```
dosw.bitacora.corte2.semana2
├── ejercicio1/                  # Sistema de Notificaciones
│   ├── Notification.java        # Strategy Pattern
│   ├── EmailNotification.java
│   ├── SMSNotification.java
│   ├── PushNotification.java
│   ├── NotificationFactory.java # Factory Pattern
│   └── NotificationSender.java  # Singleton Pattern
│
├── ejercicio2/                  # Sistema de Procesamiento de Pagos
│   ├── Payment.java             # Modelo
│   ├── PaymentProcessor.java    # Strategy Pattern
│   ├── PayPalProcessor.java
│   ├── StripeProcessor.java
│   ├── CreditCardProcessor.java
│   ├── BankTransferProcessor.java
│   ├── PaymentProcessorFactory.java         # Factory Pattern
│   ├── PaymentValidator.java                # Chain of Responsibility
│   ├── BalanceValidator.java
│   ├── FraudValidator.java
│   ├── TransactionLimitValidator.java
│   ├── ValidationChain.java
│   └── PaymentService.java      # Facade Pattern
```

---

## Ejercicio 1: Sistema de Notificaciones

### Descripción del Problema

Una empresa necesita un sistema que envíe notificaciones a los usuarios a través de diferentes canales:
- Email
- SMS
- Push Notification

El sistema debe permitir que el tipo de notificación cambie dinámicamente, y debe garantizar que exista una única instancia centralizada del servicio de envío.

### Requisitos

- Permitir agregar nuevos tipos de notificación sin modificar código existente
- Existencia de una única instancia del servicio de envío (Singleton)
- Cambio dinámico del comportamiento de envío según el canal elegido

### Patrones de Diseño Utilizados

#### 1. Strategy Pattern (Patrón de Estrategia)

**Tipo:** Patrón de Comportamiento

**Justificación Técnica:**
- Encapsula diferentes algoritmos de envío en clases separadas
- Permite cambiar el algoritmo en tiempo de ejecución
- Elimina condicionales largos (if-else) para seleccionar el tipo de notificación

**Implementación:**
- Interfaz: `Notification`
- Estrategias concretas: `EmailNotification`, `SMSNotification`, `PushNotification`

**Beneficio:**
```java
// Antes (sin patrón)
if (type.equals("EMAIL")) { /* send email */ }
else if (type.equals("SMS")) { /* send SMS */ }
else { /* send push */ }

// Después (con Strategy)
Notification strategy = NotificationFactory.createNotification(type);
strategy.send(recipient, message);
```

#### 2. Factory Pattern (Patrón Fábrica)

**Tipo:** Patrón de Creación

**Justificación Técnica:**
- Centraliza la creación de objetos `Notification`
- Permite agregar nuevas estrategias sin modificar código de cliente
- Encapsula la lógica de instantiación

**Implementación:**
- `NotificationFactory.createNotification(String type)`
- Usa Java 14+ switch expressions

**Beneficio:** Los clientes no conocen las clases concretas, solo trabajan con la interfaz.

#### 3. Singleton Pattern (Patrón Singleton)

**Tipo:** Patrón de Creación

**Justificación Técnica:**
- Garantiza una única instancia del servicio de envío
- Evita múltiples instancias que podrían causar inconsistencias
- Proporciona acceso global controlado

**Implementación:**
- Constructor privado
- `getInstance()` sincronizado
- Inicialización con estrategia por defecto

**Beneficio:** Centralización de control y consistencia del servicio.

### Diagrama UML - Ejercicio 1

```
┌─────────────────────────┐
│    Notification         │
│   <<interface>>         │
├─────────────────────────┤
│ + send(String, String) │
└─────────────────────────┘
          ▲
          │ implements
    ┌─────┼─────┐
    │     │     │
┌───┴──┐┌──┴───┐┌────┴───┐
│Email││ SMS││Push│
└──────┘└──────┘└────────┘

┌──────────────────────────────┐
│ NotificationFactory          │
│ <<Factory>>                  │
├──────────────────────────────┤
│ + createNotification(type)   │
└──────────────────────────────┘
          │ creates
          ▼
      Notification

┌──────────────────────────────────┐
│ NotificationSender               │
│ <<Singleton>> + <<Strategy>>     │
├──────────────────────────────────┤
│ - instance: NotificationSender   │
│ - currentStrategy: Notification  │
├──────────────────────────────────┤
│ + getInstance()                  │
│ + setNotificationStrategy(type)  │
│ + send(String, String)           │
└──────────────────────────────────┘
```

### Uso del Ejercicio 1

```java
// Obtener la única instancia
NotificationSender sender = NotificationSender.getInstance();

// Cambiar estrategia dinámicamente
sender.setNotificationStrategy("EMAIL");
sender.send("user@example.com", "Hola!");

sender.setNotificationStrategy("SMS");
sender.send("+573001234567", "Código: 1234");

sender.setNotificationStrategy("PUSH");
sender.send("device-id-123", "Nueva actualización disponible");
```

---

## Ejercicio 2: Sistema de Procesamiento de Pagos

### Descripción del Problema

Una plataforma de comercio electrónico necesita procesar pagos usando distintos proveedores:
- PayPal
- Stripe
- Tarjeta de crédito
- Transferencia bancaria

Cada proveedor tiene una API diferente. Antes de procesar, el sistema debe ejecutar validaciones en cadena:
1. Validar saldo
2. Validar fraude
3. Validar límite de transacciones

### Requisitos

- Integrar proveedores externos con interfaces distintas
- Agregación/eliminación flexible de validaciones
- Extensibilidad para nuevos proveedores sin modificar código principal

### Patrones de Diseño Utilizados

#### 1. Factory Pattern (Patrón Fábrica)

**Tipo:** Patrón de Creación

**Justificación Técnica:**
- Crea instancias de `PaymentProcessor` según el método seleccionado
- Desacopla la creación del procesador del código cliente
- Facilita agregar nuevos procesadores

**Implementación:**
- `PaymentProcessorFactory.createProcessor(String method)`

#### 2. Strategy Pattern (Patrón de Estrategia)

**Tipo:** Patrón de Comportamiento

**Justificación Técnica:**
- Encapsula cada algoritmo de procesamiento en una clase
- Permite cambiar el procesador en tiempo de ejecución
- Cada procesador implementa la misma interfaz: `PaymentProcessor`

**Implementación:**
- Interfaz: `PaymentProcessor`
- Estrategias: `PayPalProcessor`, `StripeProcessor`, `CreditCardProcessor`, `BankTransferProcessor`

#### 3. Chain of Responsibility Pattern (Cadena de Responsabilidad)

**Tipo:** Patrón de Comportamiento

**Justificación Técnica:**
- Crea una cadena de validadores
- Cada validador procesa y decide si pasa al siguiente
- Permite agregar/quitar validadores dinámicamente

**Implementación:**
- Clase abstracta: `PaymentValidator`
- Validadores concretos: `BalanceValidator`, `FraudValidator`, `TransactionLimitValidator`
- Gestor: `ValidationChain`

**Pipeline de Validación:**
```
Payment
  │
  ▼
BalanceValidator (¿Tiene saldo?)
  │
  ├─ NO ──> REJECTED
  │
  ├─ SÍ
       │
       ▼
    FraudValidator (¿Es fraudulento?)
       │
       ├─ SÍ ──> REJECTED
       │
       ├─ NO
            │
            ▼
         TransactionLimitValidator (¿Dentro del límite?)
            │
            ├─ NO ──> REJECTED
            │
            └─ SÍ ──> VALID (proceed to payment processing)
```

#### 4. Facade Pattern (Patrón Fachada)

**Tipo:** Patrón Estructural

**Justificación Técnica:**
- Simplifica el acceso al sistema complejo
- Orquesta múltiples patrones: Chain of Responsibility + Factory + Strategy
- Proporciona una interfaz unificada

**Implementación:**
- `PaymentService` encapsula toda la lógica
- Clientes solo interactúan con `PaymentService`

**Beneficio:** Encapsulación de complejidad del sistema.

### Diagrama UML - Ejercicio 2

```
┌─────────────────────────┐
│ Payment                 │
│ <<Model>>               │
├─────────────────────────┤
│ - transactionId: String │
│ - amount: double        │
│ - status: String        │
└─────────────────────────┘

┌─────────────────────────────┐
│    PaymentProcessor         │
│   <<interface>>             │
├─────────────────────────────┤
│ + processPayment(Payment)   │
└─────────────────────────────┘
          ▲
          │ implements
    ┌─────┼─────┬─────┐
    │     │     │     │
┌───┴──┐┌──┴──┐┌──┴──┐┌───┴──┐
│PPal││Stripe││Card││Bank│
└────┘└────┘└────┘└────┘

┌────────────────────────────────┐
│ PaymentValidator               │
│ <<abstract>> + <<ChainOfResp>> │
├────────────────────────────────┤
│ # protected nextValidator      │
├────────────────────────────────┤
│ + setNext(Validator)           │
│ + validate(Payment)            │
│ # abstract doValidate()        │
└────────────────────────────────┘
          ▲
          │ extends
    ┌─────┼─────┐
    │     │     │
    │     │     │
Balance  Fraud  Limit

┌──────────────────────────┐
│ ValidationChain          │
│ <<Manager>>              │
├──────────────────────────┤
│ - firstValidator         │
├──────────────────────────┤
│ + validatePayment()      │
└──────────────────────────┘

┌────────────────────────────┐
│ PaymentService             │
│ <<Facade>>                 │
├────────────────────────────┤
│ - validationChain          │
├────────────────────────────┤
│ + processPayment(Payment)  │
└────────────────────────────┘
        │ uses
        ├─> ValidationChain
        └─> PaymentProcessorFactory
```

### Uso del Ejercicio 2

```java
// Crear servicio (encapsula todo)
PaymentService paymentService = new PaymentService();

// Crear pago
Payment payment = new Payment("TXN-001", "PAYPAL", "USER-123", 150.0);

// Procesar (incluyendo validaciones automáticas)
boolean success = paymentService.processPayment(payment);

// Sistema ejecuta:
// 1. Validaciones en cadena
// 2. Procesamiento con proveedor seleccionado
// 3. Retorna resultado
```

---

## Requisitos Técnicos

| Aspecto | Detalle |
|--------|---------|
| Lenguaje | Java 21 |
| Build Tool | Maven 3.6+ |
| Testing | JUnit 5 |
| Coverage | JaCoCo (≥80%) |
| Analysis | SonarQube |
| Compile Level | 21 |

---

## Metodología de Desarrollo

Para cada ejercicio se realiza:

1. **Identificación de Patrones**
   - Nombre del patrón
   - Tipo del patrón
   - Justificación técnica

2. **Diagramas UML**
   - Relaciones entre clases
   - Interfaces y herencia
   - Flujo de interacciones

3. **Implementación de Código**
   - Aplicación de patrones
   - Siguiendo principios SOLID
   - Documentación en javadoc

4. **Pruebas Unitarias**
   - 100% cobertura de métodos públicos
   - Casos de éxito y fallo
   - Validación de comportamiento

5. **Análisis de Calidad**
   - Cobertura de código (JaCoCo)
   - Análisis estático (SonarQube)
   - Métricas de complejidad

---

## Archivos Fuente

### Ejercicio 1: Notificaciones

| Archivo | Ubicación |
|---------|-----------|
| Notification | [ejercicio1/Notification.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio1/Notification.java) |
| EmailNotification | [ejercicio1/EmailNotification.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio1/EmailNotification.java) |
| SMSNotification | [ejercicio1/SMSNotification.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio1/SMSNotification.java) |
| PushNotification | [ejercicio1/PushNotification.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio1/PushNotification.java) |
| NotificationFactory | [ejercicio1/NotificationFactory.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio1/NotificationFactory.java) |
| NotificationSender | [ejercicio1/NotificationSender.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio1/NotificationSender.java) |

### Ejercicio 2: Pagos

| Archivo | Ubicación |
|---------|-----------|
| Payment | [ejercicio2/Payment.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/Payment.java) |
| PaymentProcessor | [ejercicio2/PaymentProcessor.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/PaymentProcessor.java) |
| PayPalProcessor | [ejercicio2/PayPalProcessor.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/PayPalProcessor.java) |
| StripeProcessor | [ejercicio2/StripeProcessor.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/StripeProcessor.java) |
| CreditCardProcessor | [ejercicio2/CreditCardProcessor.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/CreditCardProcessor.java) |
| BankTransferProcessor | [ejercicio2/BankTransferProcessor.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/BankTransferProcessor.java) |
| PaymentProcessorFactory | [ejercicio2/PaymentProcessorFactory.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/PaymentProcessorFactory.java) |
| PaymentValidator | [ejercicio2/PaymentValidator.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/PaymentValidator.java) |
| BalanceValidator | [ejercicio2/BalanceValidator.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/BalanceValidator.java) |
| FraudValidator | [ejercicio2/FraudValidator.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/FraudValidator.java) |
| TransactionLimitValidator | [ejercicio2/TransactionLimitValidator.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/TransactionLimitValidator.java) |
| ValidationChain | [ejercicio2/ValidationChain.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/ValidationChain.java) |
| PaymentService | [ejercicio2/PaymentService.java](../../src/main/java/dosw/bitacora/corte2/semana2/ejercicio2/PaymentService.java) |

---

## Ejecución

### Compilación

```bash
mvn clean compile
```

### Pruebas

```bash
mvn test
```

### Cobertura de Código

```bash
mvn test jacoco:report
```

Reporte disponible en: `target/site/jacoco/index.html`

---

## Matriz de Patrones de Diseño

| Ejercicio | Patrón | Tipo | Objetivo | Beneficio |
|-----------|--------|------|----------|-----------|
| 1 | Strategy | Comportamiento | Cambiar algoritmo en tiempo de ejecución | Flexibilidad de comportamiento |
| 1 | Factory | Creación | Centralizar creación de objetos | Desacoplamiento |
| 1 | Singleton | Creación | Única instancia global | Control centralizado |
| 2 | Factory | Creación | Crear procesadores de pago | Extensibilidad |
| 2 | Strategy | Comportamiento | Diferentes procesos de pago | Flexibilidad del procesador |
| 2 | Chain of Resp | Comportamiento | Validaciones secuenciales | Composición flexible |
| 2 | Facade | Estructural | Interfaz simplificada | Encapsulación de complejidad |

---

## Principios SOLID Aplicados

- **S**ingle Responsibility: Cada clase tiene una única responsabilidad
- **O**pen/Closed: Abierto para extensión, cerrado para modificación
- **L**iskov Substitution: Subtipos intercambiables
- **I**nterface Segregation: Interfaces específicas
- **D**ependency Inversion: Depender de abstracciones

---

## Notas Pedagógicas

La combinación de patrones diseño crea:
- Sistemas más mantenibles
- Código más testeable
- Mayor flexibilidad para cambios futuros
- Mejor comunicación entre desarrolladores

Comprender cómo los patrones se complementan es fundamental para arquitectura de software profesional.

---

**Estado:** Completado | **Última actualización:** 2026-04-04 | **Licencia:** Propietaria DOSW