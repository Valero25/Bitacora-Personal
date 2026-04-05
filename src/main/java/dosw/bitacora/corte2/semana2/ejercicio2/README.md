# Ejercicio 2: Sistema de Procesamiento de Pagos

Versión: 1.0.0 | Corte: 2 | Semana: 2

---

## Descripción

Sistema completo de procesamiento de pagos que integra múltiples proveedores de pago y ejecuta validaciones en cadena antes de procesar. Implementa cuatro patrones de diseño trabajando conjuntamente para crear una solución robusta y extensible.

---

## Problema a Resolver

Una plataforma de comercio electrónico necesita:

1. Procesar pagos con diferentes proveedores (PayPal, Stripe, Tarjeta, Transferencia)
2. Ejecutar validaciones antes de procesar (Saldo, Fraude, Límites)
3. Integrar APIs con interfaces distintas
4. Permitir agregar nuevos proveedores sin cambiar código

### Requisitos Funcionales

- Procesar pagos por PayPal
- Procesar pagos por Stripe
- Procesar pagos por Tarjeta de Crédito
- Procesar pagos por Transferencia Bancaria
- Validar saldo disponible
- Detectar transacciones fraudulentas
- Verificar límites de transacción
- Cambiar proveedor según la selección del usuario

### Requisitos Técnicos

- Validaciones ejecutables en cadena
- Cada validación decide si continúa o detiene el proceso
- Nuevos procesadores sin modificar código principal
- Interfaz uniforme para todos los procesadores

---

## Patrones de Diseño Implementados

### 1. Factory Pattern (Patrón Fábrica)

Tipo: Patrón de Creación

Propósito: Centralizar la creación de procesadores de pago según el método seleccionado.

Implementación en el código:
- Clase: `PaymentProcessorFactory`
- Método: `createProcessor(String paymentMethod)`

Ventajas:
- Desacopla creación de uso
- Facilita agregar nuevos procesadores
- Cambios centralizados
- Clientes no conocen implementaciones

Ejemplo de uso:
```java
PaymentProcessor processor = PaymentProcessorFactory.createProcessor("PAYPAL");
processor.processPayment(payment);
```

Tipos soportados:
- "PAYPAL" -> PayPalProcessor
- "STRIPE" -> StripeProcessor
- "CREDITCARD" -> CreditCardProcessor
- "BANKTRANSFER" -> BankTransferProcessor

---

### 2. Strategy Pattern (Patrón de Estrategia)

Tipo: Patrón de Comportamiento

Propósito: Encapsular diferentes algoritmos de procesamiento y permitir seleccionar en tiempo de ejecución.

Implementación en el código:
- Interfaz: `PaymentProcessor`
- Estrategias concretas: PayPalProcessor, StripeProcessor, CreditCardProcessor, BankTransferProcessor

Ventajas:
- Cada procesador es independiente
- Fácil agregar nuevos procesadores
- Cada uno implementa su lógica de negocio
- Sin condicionales complejos

Ejemplo de uso:
```java
Payment payment = new Payment("TX-001", "STRIPE", "USER-123", 150.0);
PaymentProcessor processor = new StripeProcessor();
boolean success = processor.processPayment(payment);
```

---

### 3. Chain of Responsibility Pattern (Cadena de Responsabilidad)

Tipo: Patrón de Comportamiento

Propósito: Pasar una solicitud a través de una cadena de validadores, donde cada uno decide si continúa o detiene el proceso.

Implementación en el código:
- Clase abstracta: `PaymentValidator`
- Validadores concretos: BalanceValidator, FraudValidator, TransactionLimitValidator
- Gestor: `ValidationChain`

Ventajas:
- Validaciones desacopladas
- Fácil agregar/remover validadores
- Orden flexible
- Cada validador es responsable de una tarea

Cadena de validación:
```
BalanceValidator (¿Tiene suficiente saldo?)
        |
        v
FraudValidator (¿Es una transacción legítima?)
        |
        v
TransactionLimitValidator (¿Está dentro del límite?)
        |
        v
Procesamiento del pago
```

Validadores:

**BalanceValidator:**
- Valida que el usuario tenga suficiente saldo
- Consulta saldo en sistema
- Compara con monto de transacción

**FraudValidator:**
- Detecta patrones sospechosos
- Analiza anomalías
- Simula scoring de fraude

**TransactionLimitValidator:**
- Verifica límite de transacciones por día
- Verifica monto máximo por día
- Respeta políticas de límites

---

### 4. Facade Pattern (Patrón Fachada)

Tipo: Patrón Estructural

Propósito: Proporcionar una interfaz simplificada que encapsula la complejidad del sistema.

Implementación en el código:
- Clase: `PaymentService`
- Orquesta: ValidationChain + PaymentProcessorFactory

Ventajas:
- Interfaz simple para clientes
- Encapsula complejidad
- Orquesta múltiples patrones
- Punto de entrada uniforme

Responsabilidades:
1. Ejecutar validaciones
2. Si pasan, procesar pago
3. Retornar resultado
4. Actualizar estado de pago

Ejemplo de uso:
```java
PaymentService service = new PaymentService();
Payment payment = new Payment("TX-001", "PAYPAL", "USER-123", 200.0);
boolean success = service.processPayment(payment);
// Maneja toda la lógica internamente
```

---

## Diagrama UML

```
Payment (Model)
    |
    v
PaymentService (Facade)
    |
    +-- ValidationChain
    |       |
    |       +-- PaymentValidator (abstract)
    |           |
    |           +-- BalanceValidator
    |           +-- FraudValidator
    |           +-- TransactionLimitValidator
    |
    +-- PaymentProcessorFactory
            |
            +-- PaymentProcessor (interface)
                |
                +-- PayPalProcessor
                +-- StripeProcessor
                +-- CreditCardProcessor
                +-- BankTransferProcessor
```

---

## Estructura de Archivos

```
ejercicio2/
├── Payment.java                     # Modelo de datos
├── PaymentProcessor.java            # Interfaz Strategy
├── PayPalProcessor.java             # Estrategia para PayPal
├── StripeProcessor.java             # Estrategia para Stripe
├── CreditCardProcessor.java         # Estrategia para Tarjeta
├── BankTransferProcessor.java       # Estrategia para Transferencia
├── PaymentProcessorFactory.java     # Factory Pattern
├── PaymentValidator.java            # Clase abstracta para cadena
├── BalanceValidator.java            # Validador de saldo
├── FraudValidator.java              # Validador de fraude
├── TransactionLimitValidator.java   # Validador de límites
├── ValidationChain.java             # Gestor de cadena
└── PaymentService.java              # Facade Pattern
```

---

## Descripción de Clases Clave

### Payment.java

Modelo que representa una transacción de pago.

Atributos:
- `transactionId`: Identificador único de la transacción
- `paymentMethod`: Método de pago (PAYPAL, STRIPE, etc)
- `userId`: ID del usuario que realiza el pago
- `amount`: Monto a pagar
- `status`: Estado actual (PENDING, COMPLETED, REJECTED, FAILED)

### PaymentProcessor.java

Interfaz que define el comportamiento de un procesador de pago.

Método:
- `processPayment(Payment)`: Procesa el pago y retorna resultado

### PaymentValidator.java

Clase abstracta que define el comportamiento de un validador en la cadena.

Responsabilidades:
- Validar un aspecto específico
- Pasar al siguiente validador
- Detener si la validación falla

Métodos:
- `validate(Payment)`: Inicia validación
- `doValidate(Payment)`: Implementar validación específica
- `setNext(PaymentValidator)`: Encadenar validador

### ValidationChain.java

Gestor que construye y ejecuta la cadena de validadores.

Responsabilidades:
- Construir la cadena en orden correcto
- Iniciar el proceso de validación
- Retornar resultado

Orden de cadena:
1. BalanceValidator
2. FraudValidator
3. TransactionLimitValidator

### PaymentService.java

Facade que orquesta todo el sistema.

Método principal:
- `processPayment(Payment)`: Procesa pago completo

Flujo:
1. Valida el pago (ValidationChain)
2. Si falla, marca como REJECTED
3. Si pasa, procesa con factory
4. Retorna resultado

---

## Flujo de Ejecución Completo

```
1. Cliente crea Payment
   |
   v
2. Cliente llama PaymentService.processPayment()
   |
   v
3. PaymentService ejecuta ValidationChain.validatePayment()
   |
   +-- BalanceValidator.validate()
   |   ¿Tiene saldo? -> NO: Rechaza, retorna false
   |                -> SÍ: Continúa a siguiente
   |
   +-- FraudValidator.validate()
   |   ¿Es fraudulento? -> SÍ: Rechaza, retorna false
   |                     -> NO: Continúa a siguiente
   |
   +-- TransactionLimitValidator.validate()
       ¿Dentro de límite? -> NO: Rechaza, retorna false
                          -> SÍ: Pasa todas, retorna true
   |
   v
4. Si pasa validación:
   a. PaymentService obtiene procesador con Factory
   b. Ejecuta processor.processPayment()
   c. Retorna resultado
   |
5. Si falla validación:
   a. Marca payment como REJECTED
   b. Retorna false
```

---

## Casos de Uso

### Caso 1: Pago exitoso con PayPal

```java
PaymentService service = new PaymentService();
Payment payment = new Payment("TXN-001", "PAYPAL", "USER-001", 150.0);

// El sistema:
// 1. Valida saldo (OK)
// 2. Valida fraude (OK)
// 3. Valida límite (OK)
// 4. Procesa con PayPalProcessor
// 5. Retorna true
boolean success = service.processPayment(payment);
```

### Caso 2: Pago rechazado por saldo insuficiente

```java
PaymentService service = new PaymentService();
Payment payment = new Payment("TXN-002", "STRIPE", "USER-002", 100000.0);

// El sistema:
// 1. Valida saldo (FALLA: no tiene suficiente)
// 2. Marca como REJECTED
// 3. Retorna false
// 4. NO continúa a siguientes validaciones
// 5. NO procesa el pago
boolean success = service.processPayment(payment);
```

### Caso 3: Pago rechazado por fraude

```java
PaymentService service = new PaymentService();
Payment payment = new Payment("TXN-003", "CREDITCARD", "USER-003", 75000.0);

// El sistema:
// 1. Valida saldo (OK)
// 2. Valida fraude (FALLA: monto sospechoso)
// 3. Marca como REJECTED
// 4. Retorna false
// 5. NO procesa el pago
boolean success = service.processPayment(payment);
```

### Caso 4: Pago rechazado por límite

```java
PaymentService service = new PaymentService();
Payment payment = new Payment("TXN-004", "BANKTRANSFER", "USER-004", 150000.0);

// El sistema:
// 1. Valida saldo (OK)
// 2. Valida fraude (OK)
// 3. Valida límite (FALLA: excede límite diario)
// 4. Marca como REJECTED
// 5. Retorna false
// 6. NO procesa el pago
boolean success = service.processPayment(payment);
```

---

## Extensibilidad

### Agregar nuevo procesador

1. Crear clase que implemente PaymentProcessor
2. Agregar caso en PaymentProcessorFactory.createProcessor()
3. Listo, sin cambiar código existente

```java
// Nuevo procesador
public class ApplePayProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(Payment payment) {
        // Lógica de Apple Pay
        return true;
    }
}

// Agregar a factory
case "APPLEPAY":
    return new ApplePayProcessor();
```

### Agregar nuevo validador

1. Crear clase que extienda PaymentValidator
2. Implementar doValidate()
3. Agregar a ValidationChain.buildChain()
4. Encadenar con otro validador

```java
// Nuevo validador
public class GeolocationValidator extends PaymentValidator {
    protected boolean doValidate(Payment payment) {
        // Validar geolocalización
        return true;
    }
}

// Agregar a cadena
geolocationValidator.setNext(fraudValidator);
fraudValidator.setNext(limitValidator);
```

---

## Principios SOLID

S - Single Responsibility
- PayPalProcessor solo procesa PayPal
- BalanceValidator solo valida saldo
- PaymentService orquesta el flujo

O - Open/Closed
- Abierto para agregar procesadores/validadores
- Cerrado para modificar código existente

L - Liskov Substitution
- Cualquier PaymentProcessor reemplaza otro
- Cualquier PaymentValidator es intercambiable

I - Interface Segregation
- PaymentProcessor define solo lo necesario
- PaymentValidator abstracta no tiene métodos innecesarios

D - Dependency Inversion
- PaymentService depende de abstracciones
- No de implementaciones concretas

---

## Compilación y Pruebas

Compilar:
```bash
mvn clean compile
```

Ejecutar pruebas:
```bash
mvn test
```

Generar reporte:
```bash
mvn test jacoco:report
```

---

**Estado:** Completado | **Última actualización:** 2026-04-04 | **Licencia:** Propietaria DOSW