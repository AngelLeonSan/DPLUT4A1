package org.example.ut4a1.Service;

import org.example.ut4a1.Model.Vehiculo;
import org.example.ut4a1.repository.VehiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    //Le decimos que construya un repositorio en memoria para trabajar e
    @Autowired
   private VehiculosRepository repository;

    //Creamos vehiculo
    public Vehiculo crearVehiculo(Vehiculo veh) {

        return repository.save(veh);
    }
    //Listar todos
    public List<Vehiculo> obtenerTodos() {
        return repository.findAll();
    }


}
