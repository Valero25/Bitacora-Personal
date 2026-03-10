package dosw.bitacora.semana3.repaso.base.command;

/** Invocador: ejecuta comandos sin saber qué hacen internamente */
public class ControlRemoto {
    public void presionar(Comando comando) {
        comando.ejecutar();
    }
}
