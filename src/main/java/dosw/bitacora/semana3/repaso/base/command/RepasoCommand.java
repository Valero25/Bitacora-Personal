package dosw.bitacora.semana3.repaso.base.command;

/**
 * ============================================================
 * PATRÓN: Command  (Comportamiento)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Quieres desacoplar al que pide una operación (invocador) del
 *   objeto que sabe cómo ejecutarla (receptor). También permite
 *   encolar, registrar y deshacer operaciones.
 *
 * ROL DE CADA CLASE:
 *   Comando     (interfaz)   → contrato: ejecutar()
 *   Luz         (receptor)   → sabe encender/apagar — nunca recibe órdenes
 *                              directamente del cliente
 *   EncenderLuz (comando concreto) → llama luz.encender() cuando se ejecuta
 *   ApagarLuz   (comando concreto) → llama luz.apagar() cuando se ejecuta
 *   ControlRemoto (invocador)→ solo llama comando.ejecutar(); no necesita
 *                              saber si enciende, apaga o hace otra cosa
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. El cliente (main) crea el receptor (Luz) y los comandos concretos,
 *      asignando el receptor a cada comando.
 *   2. Le pasa los comandos al invocador (ControlRemoto).
 *   3. El invocador solo llama ejecutar() — nunca toca la Luz directamente.
 *
 * BENEFICIO EXTRA:
 *   Para agregar "deshacer" (undo), agrega deshacer() en la interfaz
 *   y en EncenderLuz.deshacer() llamas luz.apagar().
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   Un mesero: el cliente (invocador) hace un pedido (comando). El mesero
 *   lo escribe y lo pasa a la cocina (receptor). La cocina prepara el plato
 *   sin hablar directamente con el cliente.
 * ============================================================
 */
public class RepasoCommand {
    public static void main(String[] args) {
        Luz luz = new Luz();
        ControlRemoto control = new ControlRemoto();

        control.presionar(new EncenderLuz(luz));
        control.presionar(new ApagarLuz(luz));
    }
}
