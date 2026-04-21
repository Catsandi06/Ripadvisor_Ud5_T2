package net.salesianos;

import java.util.ArrayList;
import java.util.List;

public class GestorRestaurantes {
    private List<Restaurante> restaurantes;

    public GestorRestaurantes() {
        restaurantes = new ArrayList<>();
    }

    public void anadirRestaurante(Restaurante restaurante) {
        restaurantes.add(restaurante);
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }
}