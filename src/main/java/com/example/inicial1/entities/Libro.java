package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name="libro")

public class Libro extends Base {
@Column(name = "titulo")
    private String titulo;
@Column(name="fecha")
    private int fecha;
@Column(name="genero")
    private String genero;
@Column(name="paginas")
    private int paginas;


@ManyToMany(cascade = CascadeType.REFRESH)  //actualiza los autores

    private List<Autor> autores;
}
