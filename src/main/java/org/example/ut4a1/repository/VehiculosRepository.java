package org.example.ut4a1.repository;

import org.example.ut4a1.Model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculosRepository extends JpaRepository<Vehiculo,Long> {
    //Como extendemos de JpaRepository ya estan los metodos
    //guardar, buscartodos y buscar por id
}
