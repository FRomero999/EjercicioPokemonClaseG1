package org.example.models;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class Pokemon {
    private Long id;
    private String nombre;
    private String tipo;
    private Integer nivel;
    private Integer ps;

}
