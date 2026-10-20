package org.example;

import org.example.models.Pokemon;
import org.example.services.FileService;
import org.example.services.InformeService;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        FileService fileService = new FileService();
        InformeService informeService = new InformeService();

        List<Pokemon> pokemones = fileService.leerPokemonJson("pokemon.json");

        List<String> informe = informeService.generarInforme(pokemones);

        fileService.escribirInforme("informe_pokemon.txt",informe);

    }
}
