# Ejercicio de Informe Pokemon

Aplicación de aprendizaje que lee un json con pokemons y genera un informe con estadísticas.

# Funcionalidad
- Leer el contenido del fichero JSON y almacenar los Pokémon en una colección adecuada.
- Cálculo de estadísticas a partir de los datos cargados:
  - Número total de Pokémon.
  - Nivel medio.
  - PS medios.
  - Pokémon con mayor nivel.
  - Pokémon con mayor cantidad de PS.
  - Estadísticas por tipo
  - Número de Pokémon de cada tipo existente.
  - Listado de nombres agrupados por tipo.
- Crear un archivo de texto llamado informe_pokemon.txt
- No se permite escribir manualmente los resultados dentro del informe.

# Tecnologías
- Java JDK 27
- Jackson 3.24
- Maven 3

# Modelo de datos
- Especificado con Pokemon.java

# Arquitectura
- Separadas por paquetes
- Capa de Lógica de negocio
  - Servicio de Archivos (lectura y escritura de ficheros)
  - Servicio de informe (calculo estadísticas y generación de informes)

# Formato de salida del informe

El informe deberá tener una estructura similar a:
```
=========================
 INFORME DE POKÉMON
=========================

Total de Pokémon: 20

Nivel medio: 16.75

PS medios: 48.20

Pokémon con mayor nivel:
Pikachu (Nivel 25)

Pokémon con más PS:
Snorlax (PS 160)

-------------------------
POKÉMON POR TIPO
-------------------------

AGUA: 4
Squirtle
Psyduck
Poliwag
Magikarp

FUEGO: 3
Charmander
Vulpix
Growlithe

PLANTA: 2
Bulbasaur
Oddish
```

# Especificaciones del código
- Usa el esqueleto de las clases ya existentes. Antes de añadir o modificar algún método, preguntame.
- Incluye Javadoc en métodos y clases
- Variables en español
- Usa streams solo con .filter(), .map() .foreach(), .collect(), no uses funciones avanzadas.
- Usa un código sencillo de entender para los alumnos. No optimices.
- No imprimir por consola
