package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);
    //boolean existsByDni(int dni);
    //JPQL
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);


    //SQL
    @Query(
            value= "SELECT * FROM Persona WHERE Persona.nombre LIKE %:filtro% OR Persona.apellido LIKE %:filtro%" ,
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);



    //PAGINACION
    //METODO 1
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //METODO JPQL
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    //METODO SQL
    @Query(
            value= "SELECT * FROM Persona WHERE Persona.nombre LIKE %:filtro% OR Persona.apellido LIKE %:filtro%" ,
            countQuery = "SELECT count(*) FROM Persona",  //se hace porque no es automatico el tema de la paginacion
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}