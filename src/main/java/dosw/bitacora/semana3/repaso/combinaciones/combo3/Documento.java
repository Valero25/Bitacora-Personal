package dosw.bitacora.semana3.repaso.combinaciones.combo3;

/** Receptor: el documento que recibe las acciones */
public class Documento {
    private StringBuilder texto = new StringBuilder();

    public void escribir(String palabra) {
        texto.append(palabra).append(" ");
        System.out.println("[Documento] escribe: \"" + palabra + "\" → " + texto.toString().trim());
    }

    public void borrarUltima() {
        if (texto.length() == 0) return;
        String actual = texto.toString().trim();
        int ultimo = actual.lastIndexOf(' ');
        texto = new StringBuilder(ultimo >= 0 ? actual.substring(0, ultimo + 1) : "");
        System.out.println("[Documento] borra última palabra → \"" + texto.toString().trim() + "\"");
    }
}
