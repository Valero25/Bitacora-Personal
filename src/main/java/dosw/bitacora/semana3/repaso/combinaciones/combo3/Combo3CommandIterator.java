package dosw.bitacora.semana3.repaso.combinaciones.combo3;

public class Combo3CommandIterator {
    public static void main(String[] args) {
        Documento doc = new Documento();
        MacroGrabador macro = new MacroGrabador();

        // Grabamos la macro (Command)
        macro.grabar(new EscribirAccion(doc, "Hola"));
        macro.grabar(new EscribirAccion(doc, "mundo"));
        macro.grabar(new EscribirAccion(doc, "ERROR"));
        macro.grabar(new BorrarAccion(doc));
        macro.grabar(new EscribirAccion(doc, "Java"));

        System.out.println("\n--- Reproduciendo macro ---");
        // Iterator recorre y ejecuta los comandos
        IteradorAcciones it = macro.iterador();
        while (it.hasNext()) {
            it.next().ejecutar();
        }
    }
}
