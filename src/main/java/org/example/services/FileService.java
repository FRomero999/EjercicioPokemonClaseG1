package org.example.services;

import org.example.models.Pokemon;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Servicio encargado de la lectura y escritura de ficheros.
 */
public class FileService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Lee un fichero JSON y devuelve la lista de Pokémon que contiene.
     *
     * @param ruta ruta del fichero JSON a leer
     * @return lista de Pokémon leídos del fichero
     */
    public List<Pokemon> leerPokemonJson(String ruta) {
        return objectMapper.readValue(new File(ruta), new TypeReference<List<Pokemon>>() {
        });
    }

    /**
     * Escribe las líneas indicadas en un fichero de texto, una línea por elemento.
     *
     * @param ruta   ruta del fichero de texto a crear
     * @param lineas líneas que se van a escribir en el fichero
     */
    public void escribirInforme(String ruta, List<String> lineas) {
        try {
            Files.write(Path.of(ruta), lineas, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir el informe: " + ruta, e);
        }
    }

}
