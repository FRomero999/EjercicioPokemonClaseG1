package org.example.services;

import org.example.models.Pokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Servicio encargado del cálculo de estadísticas y de la generación del informe de Pokémon.
 */
public class InformeService {

    /**
     * Calcula el número total de Pokémon de la lista.
     *
     * @param pokemones lista de Pokémon
     * @return número total de Pokémon
     */
    private Long calcularTotalPokemon(List<Pokemon> pokemones) {
        return (long) pokemones.size();
    }

    /**
     * Calcula el nivel medio de los Pokémon de la lista.
     *
     * @param pokemones lista de Pokémon
     * @return nivel medio, o 0.0 si la lista está vacía
     */
    public Double calcularNivelMedio(List<Pokemon> pokemones) {
        if (pokemones.isEmpty()) {
            return 0.0;
        }

        Integer sumaNiveles = 0;
        for (Pokemon pokemon : pokemones) {
            sumaNiveles = sumaNiveles + pokemon.getNivel();
        }

        return (double) sumaNiveles / pokemones.size();
    }

    /**
     * Calcula los PS medios de los Pokémon de la lista.
     *
     * @param pokemones lista de Pokémon
     * @return PS medios, o 0.0 si la lista está vacía
     */
    public Double calcularPsMedios(List<Pokemon> pokemones) {
        if (pokemones.isEmpty()) {
            return 0.0;
        }

        Integer sumaPs = 0;
        for (Pokemon pokemon : pokemones) {
            sumaPs = sumaPs + pokemon.getPs();
        }

        return (double) sumaPs / pokemones.size();
    }

    /**
     * Busca el Pokémon con mayor nivel. Si hay empate, devuelve el primero encontrado.
     *
     * @param pokemones lista de Pokémon
     * @return Pokémon con mayor nivel, o null si la lista está vacía
     */
    public Pokemon buscarPokemonMayorNivel(List<Pokemon> pokemones) {
        if (pokemones.isEmpty()) {
            return null;
        }

        Pokemon mayorNivel = pokemones.get(0);
        for (Pokemon pokemon : pokemones) {
            if (pokemon.getNivel() > mayorNivel.getNivel()) {
                mayorNivel = pokemon;
            }
        }

        return mayorNivel;
    }

    /**
     * Busca el Pokémon con más PS. Si hay empate, devuelve el primero encontrado.
     *
     * @param pokemones lista de Pokémon
     * @return Pokémon con más PS, o null si la lista está vacía
     */
    public Pokemon buscarPokemonMayorPs(List<Pokemon> pokemones) {
        if (pokemones.isEmpty()) {
            return null;
        }

        Pokemon mayorPs = pokemones.get(0);
        for (Pokemon pokemon : pokemones) {
            if (pokemon.getPs() > mayorPs.getPs()) {
                mayorPs = pokemon;
            }
        }

        return mayorPs;
    }

    /**
     * Agrupa los Pokémon por tipo.
     *
     * @param pokemones lista de Pokémon
     * @return mapa con los tipos como clave y la lista de Pokémon de cada tipo como valor
     */
    public Map<String, List<Pokemon>> agruparPorTipo(List<Pokemon> pokemones) {
        Map<String, List<Pokemon>> pokemonesPorTipo = new HashMap<>();

        for (Pokemon pokemon : pokemones) {
            List<Pokemon> listaTipo = pokemonesPorTipo.get(pokemon.getTipo());

            if (listaTipo == null) {
                listaTipo = new ArrayList<>();
                pokemonesPorTipo.put(pokemon.getTipo(), listaTipo);
            }

            listaTipo.add(pokemon);
        }

        return pokemonesPorTipo;
    }

    /**
     * Genera las líneas del informe de Pokémon a partir de la lista indicada.
     *
     * @param pokemones lista de Pokémon
     * @return lista de líneas que forman el informe
     */
    public List<String> generarInforme(List<Pokemon> pokemones) {
        List<String> lineas = new ArrayList<>();

        lineas.add("=========================");
        lineas.add(" INFORME DE POKÉMON");
        lineas.add("=========================");
        lineas.add("");
        lineas.add("Total de Pokémon: " + calcularTotalPokemon(pokemones));
        lineas.add("");
        lineas.add("Nivel medio: " + String.format(Locale.ROOT, "%.2f", calcularNivelMedio(pokemones)));
        lineas.add("");
        lineas.add("PS medios: " + String.format(Locale.ROOT, "%.2f", calcularPsMedios(pokemones)));
        lineas.add("");

        Pokemon mayorNivel = buscarPokemonMayorNivel(pokemones);
        if (mayorNivel != null) {
            lineas.add("Pokémon con mayor nivel:");
            lineas.add(mayorNivel.getNombre() + " (Nivel " + mayorNivel.getNivel() + ")");
            lineas.add("");
        }

        Pokemon mayorPs = buscarPokemonMayorPs(pokemones);
        if (mayorPs != null) {
            lineas.add("Pokémon con más PS:");
            lineas.add(mayorPs.getNombre() + " (PS " + mayorPs.getPs() + ")");
            lineas.add("");
        }

        lineas.add("-------------------------");
        lineas.add("POKÉMON POR TIPO");
        lineas.add("-------------------------");
        lineas.add("");

        Map<String, List<Pokemon>> pokemonesPorTipo = agruparPorTipo(pokemones);

        for (String tipo : pokemonesPorTipo.keySet()) {
            List<Pokemon> listaTipo = pokemonesPorTipo.get(tipo);

            lineas.add(tipo + ": " + listaTipo.size());

            for (Pokemon pokemon : listaTipo) {
                lineas.add(pokemon.getNombre());
            }

            lineas.add("");
        }

        return lineas;
    }

}
