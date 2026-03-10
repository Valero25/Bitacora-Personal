package dosw.bitacora.semana3.repaso.base.abstractfactory;

/**
 * ============================================================
 * PATRÓN: Abstract Factory  (Creacional)
 * ============================================================
 * PROBLEMA QUE RESUELVE:
 *   Necesitamos crear familias de objetos relacionados (ej. muebles
 *   de un mismo estilo) garantizando que todos sean compatibles
 *   entre sí, sin acoplar el cliente a clases concretas.
 *
 * DIFERENCIA CON FACTORY METHOD:
 *   Factory Method crea UN solo tipo de producto.
 *   Abstract Factory crea UNA FAMILIA de productos relacionados.
 *
 * CÓMO LEER ESTE EJERCICIO:
 *   1. FabricaMuebles (abstract factory) declara los métodos de creación
 *      para todos los productos de la familia: crearSilla() + crearMesa().
 *   2. FabricaModerna y FabricaVictoriana (concrete factories) implementan
 *      esos métodos y garantizan que sus productos sean del mismo estilo.
 *   3. El método amueblar() trabaja solo con FabricaMuebles; no importa
 *      si la fábrica es Moderna o Victoriana.
 *
 * ANALOGÍA EN LA VIDA REAL:
 *   Una app de UI themes: DarkThemeFactory crea Botón-Oscuro + Checkbox-Oscuro.
 *   LightThemeFactory crea Botón-Claro + Checkbox-Claro. El cliente solo
 *   pide "dame un botón" sin importar el tema activo.
 *
 * DIAGRAMA MENTAL:
 *   FabricaMuebles (interfaz)
 *       ├── FabricaModerna   →  SillaModerna,   MesaModerna
 *       └── FabricaVictoriana → SillaVictoriana, MesaVictoriana
 * ============================================================
 */
public class RepasoAbstractFactory {
    static void amueblar(FabricaMuebles fabrica) {
        fabrica.crearSilla().describir();
        fabrica.crearMesa().describir();
    }

    public static void main(String[] args) {
        System.out.println("-- Estilo Moderno --");
        amueblar(new FabricaModerna());

        System.out.println("-- Estilo Victoriano --");
        amueblar(new FabricaVictoriana());
    }
}
