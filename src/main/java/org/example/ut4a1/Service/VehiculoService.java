package org.example.ut4a1.Service;

import org.example.ut4a1.Model.Vehiculo;
import org.example.ut4a1.exception.ResourceNotFoundException;
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

    // En VehiculoService.java

    public Vehiculo actualizarVehiculo(Long id, Vehiculo vehiculoActualizado) {
        Vehiculo existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado con id: " + id));

        existente.setMarca(vehiculoActualizado.getMarca());
        existente.setModelo(vehiculoActualizado.getModelo());
        existente.setMatriculacion(vehiculoActualizado.getMatriculacion());
        existente.setPrecio(vehiculoActualizado.getPrecio());
        existente.setProximaITV(vehiculoActualizado.getProximaITV());

        return repository.save(existente);
    }

    public void eliminarVehiculo(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Vehículo no encontrado con id: " + id);
        }
        repository.deleteById(id);
    }

}
