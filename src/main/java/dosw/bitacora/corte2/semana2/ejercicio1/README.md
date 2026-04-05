# Ejercicio 1: Sistema de Notificaciones

Versión: 1.0.0 | Corte: 2 | Semana: 2

---

## Descripción

Sistema que envía notificaciones a usuarios a través de diferentes canales (Email, SMS, Push Notification). Implementa la combinación de tres patrones de diseño para lograr un sistema flexible, escalable y mantenible.

---

## Problema a Resolver

Una empresa necesita un sistema que:

1. Envíe notificaciones por múltiples canales (Email, SMS, Push)
2. Permita cambiar dinámicamente el canal de notificación
3. Garantice una única instancia del servicio de envío
4. Sea fácil de extender con nuevos canales sin modificar código existente

### Requisitos Funcionales

- Soportar Email como canal de notificación
- Soportar SMS con límite de 160 caracteres
- Soportar Push Notifications para aplicaciones móviles
- Cambiar el canal de envío en tiempo de ejecución
- Evitar múltiples instancias del servicio

### Requisitos Técnicos

- Una única instancia global del servicio (Singleton)
- Nuevos canales sin modificar código principal
- Interfaz uniforme para todos los canales

---

## Patrones de Diseño Implementados

### 1. Strategy Pattern (Patrón de Estrategia)

Tipo: Patrón de Comportamiento

Propósito: Encapsular diferentes algoritmos de envío en clases separadas y permitir cambiar entre ellos en tiempo de ejecución.

Implementación en el código:
- Interfaz: `Notification`
- Estrategias concretas: `EmailNotification`, `SMSNotification`, `PushNotification`

Ventajas:
- Elimina condicionales largos
- Cada estrategia es independiente
- Fácil agregar nuevas estrategias
- Cumple con el principio Open/Closed

Ejemplo de uso:
```java
Notification strategy = new EmailNotification();
strategy.send("user@example.com", "Mensaje");

// Cambiar de estrategia
strategy = new SMSNotification();
strategy.send("+573001234567", "Código: 1234");
```

---

### 2. Factory Pattern (Patrón Fábrica)

Tipo: Patrón de Creación

Propósito: Centralizar la creación de objetos Notification y desacoplar la creación de su uso.

Implementación en el código:
- Clase: `NotificationFactory`
- Método: `createNotification(String type)`

Ventajas:
- Centraliza lógica de creación
- Facilita agregar nuevas estrategias
- Los clientes no conocen las clases concretas
- Cambios futuros se hacen en un solo lugar

Ejemplo de uso:
```java
// Sin conocer la clase concreta
Notification notif = NotificationFactory.createNotification("EMAIL");
notif.send("user@example.com", "Mensaje");
```

---

### 3. Singleton Pattern (Patrón Singleton)

Tipo: Patrón de Creación

Propósito: Garantizar una única instancia del servicio de envío en toda la aplicación.

Implementación en el código:
- Clase: `NotificationSender`
- Constructor privado
- `getInstance()` sincronizado
- Estrategia inicial por defecto

Ventajas:
- Control centralizado del servicio
- Evita inconsistencias por múltiples instancias
- Acceso global controlado
- Menor consumo de recursos

Ejemplo de uso:
```java
// Siempre retorna la misma instancia
NotificationSender sender1 = NotificationSender.getInstance();
NotificationSender sender2 = NotificationSender.getInstance();
// sender1 == sender2 (misma instancia)
```

---

## Diagrama UML

```
Notification (interface)
    ^
    |
    | implements
    |
    +-- EmailNotification
    +-- SMSNotification
    +-- PushNotification

NotificationFactory
    | creates
    v
Notification

NotificationSender (Singleton)
    | uses
    v
Notification (estrategia actual)
```

---

## Estructura de Archivos

```
ejercicio1/
├── Notification.java              # Interfaz Strategy
├── EmailNotification.java         # Estrategia para Email
├── SMSNotification.java           # Estrategia para SMS
├── PushNotification.java          # Estrategia para Push
├── NotificationFactory.java       # Factory Pattern
└── NotificationSender.java        # Singleton Pattern
```

---

## Descripción de Clases

### Notification.java

Interfaz que define el contrato para enviar notificaciones.

Responsabilidades:
- Definir método `send(recipient, message)`

### EmailNotification.java

Implementación de Notification para envíos por Email.

Lógica:
- Recibe correo electrónico y mensaje
- Valida formato básico
- Simula envío a través de SMTP

### SMSNotification.java

Implementación de Notification para envíos por SMS.

Lógica:
- Recibe número telefónico y mensaje
- Limita mensaje a 160 caracteres
- Simula envío a través de proveedor SMS

### PushNotification.java

Implementación de Notification para Push Notifications.

Lógica:
- Recibe ID de dispositivo y mensaje
- Simula envío a través de servicio push
- Dirigido a aplicaciones móviles

### NotificationFactory.java

Factory para crear instancias de Notification.

Responsabilidades:
- Recibir tipo de notificación (string)
- Retornar instancia apropiada
- Lanzar excepción si tipo no es válido

Tipos soportados:
- "EMAIL" -> EmailNotification
- "SMS" -> SMSNotification
- "PUSH" -> PushNotification

### NotificationSender.java

Singleton que gestiona el envío de notificaciones.

Responsabilidades:
- Mantener única instancia
- Gestionar estrategia actual
- Cambiar estrategia dinámicamente
- Enviar notificaciones

Métodos clave:
- `getInstance()` - obtiene la instancia singleton
- `setNotificationStrategy(String)` - cambia estrategia por tipo
- `send(recipient, message)` - envía con estrategia actual

---

## Flujo de Ejecución

```
1. Cliente solicita NotificationSender.getInstance()
   |
   v
2. Se retorna única instancia (singleton)
   |
   v
3. Cliente llama setNotificationStrategy("EMAIL")
   |
   v
4. NotificationSender obtiene factory y crea EmailNotification
   |
   v
5. Cliente llama send(recipient, message)
   |
   v
6. NotificationSender utiliza estrategia actual para enviar
   |
   v
7. EmailNotification.send() ejecuta lógica de envío
```

---

## Casos de Uso

### Caso 1: Cambiar dinámicamente el canal

```java
NotificationSender sender = NotificationSender.getInstance();

// Primero por Email
sender.setNotificationStrategy("EMAIL");
sender.send("admin@company.com", "Sistema en mantenimiento");

// Luego por SMS
sender.setNotificationStrategy("SMS");
sender.send("+573001234567", "Mantenimiento finalizado");

// Finalmente por Push
sender.setNotificationStrategy("PUSH");
sender.send("device-001", "Sistema restituido");
```

### Caso 2: Múltiples referencias a singleton

```java
// En diferentes clases/servicios
NotificationSender service1 = NotificationSender.getInstance();
NotificationSender service2 = NotificationSender.getInstance();

// Son la misma instancia
assert service1 == service2;

// Un cambio afecta a todos
service1.setNotificationStrategy("SMS");
// service2 también usa SMS
```

### Caso 3: Validación de entrada

```java
NotificationSender sender = NotificationSender.getInstance();

// Valida tipo inválido
try {
    sender.setNotificationStrategy("TELEGRAM"); // No soportado
} catch (IllegalArgumentException e) {
    System.out.println("Canal no soportado");
}

// Valida campos NULL
try {
    sender.send(null, "Mensaje");
} catch (IllegalArgumentException e) {
    System.out.println("Receptor requerido");
}
```

---

## Principios SOLID Aplicados

S - Single Responsibility
- EmailNotification solo envía por Email
- SMSNotification solo envía por SMS
- NotificationFactory solo crea instancias

O - Open/Closed
- Abierto para extender (nuevos canales)
- Cerrado para modificar (sin cambiar código existente)

L - Liskov Substitution
- Cualquier Notification puede reemplazar a otra
- El cliente no necesita conocer la implementación

I - Interface Segregation
- Notification es una interfaz específica
- Solo define lo necesario

D - Dependency Inversion
- Depende de abstracciones (Notification)
- No de implementaciones concretas

---

## Mejoras Futuras

- Agregar validación de email con regex
- Implementar reintentos en caso de fallo
- Agregar logging de envíos
- Implementar patrón Observer para notificar estado
- Agregar encriptación de mensajes sensibles

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

Generar reporte de cobertura:
```bash
mvn test jacoco:report
```

---

**Estado:** Completado | **Última actualización:** 2026-04-04 | **Licencia:** Propietaria DOSW