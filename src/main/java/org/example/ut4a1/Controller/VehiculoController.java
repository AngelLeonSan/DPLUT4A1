package org.example.ut4a1.Controller;

import org.example.ut4a1.Model.Vehiculo;
import org.example.ut4a1.Service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService servicio;

    //EndPoints
    //Guardar
    @PostMapping
    public Vehiculo crear(@RequestBody Vehiculo vehiculo) {
        return  servicio.crearVehiculo(vehiculo);
    }

    //Listar
    @GetMapping
    public List<Vehiculo> listar() {
        return servicio.obtenerTodos();
    }

}
