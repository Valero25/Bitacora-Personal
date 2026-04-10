package dosw.bitacora.corte2.semana3;

public enum Tipo {
    FUEGO,
    AGUA,
    TIERRA,
    VIENTO,
    LUZ,
    OSCURIDAD;

    public double getMultiplicador(Tipo defensor) {
        if (this == FUEGO && defensor == TIERRA) return 1.5;
        if (this == AGUA && defensor == FUEGO) return 1.5;
        if (this == TIERRA && defensor == VIENTO) return 1.5;
        if (this == VIENTO && defensor == AGUA) return 1.5;
        if (this == LUZ && defensor == OSCURIDAD) return 1.5;
        if (this == OSCURIDAD && defensor == LUZ) return 1.5;

        if (this == TIERRA && defensor == FUEGO) return 0.5;
        if (this == FUEGO && defensor == AGUA) return 0.5;
        if (this == VIENTO && defensor == TIERRA) return 0.5;
        if (this == AGUA && defensor == VIENTO) return 0.5;

        return 1.0;
    }
}
