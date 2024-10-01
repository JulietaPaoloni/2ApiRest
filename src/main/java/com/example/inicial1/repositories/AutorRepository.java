package com.example.inicial1.repositories;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Base;
import org.springframework.stereotype.Repository;

@Repository //indica que es repositorio
public interface AutorRepository extends BaseRepository<Autor,Long> {
}
