package org.example.ut4a1.Service;

import org.example.ut4a1.Model.Vehiculo;
import org.example.ut4a1.repository.VehiculosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehiculoServicesTest {
    @Mock
    private VehiculosRepository repository;

    @InjectMocks
    private VehiculoService service;

    private Vehiculo vehiculo;

    @BeforeEach
    void setUp() {
        vehiculo = new Vehiculo();
        vehiculo.setId(1L);
        vehiculo.setMarca("Seat");
        vehiculo.setModelo("Leon");
        vehiculo.setMatriculacion(2021);
        vehiculo.setPrecio(18000);
        vehiculo.setProximaITV(LocalDate.of(2025, 12, 1));
    }

    @Test
    void testGuardarVehiculo() {
        when(repository.save(any(Vehiculo.class))).thenReturn(vehiculo);
        Vehiculo guardado = service.crearVehiculo(new Vehiculo());
        assertNotNull(guardado);
        assertEquals("Seat", guardado.getMarca());
        verify(repository, times(1)).save(any(Vehiculo.class));
    }
    @Test
    void testObtenerTodos() {
        when(repository.findAll()).thenReturn(List.of(vehiculo));

        List<Vehiculo> lista = service.obtenerTodos();

        assertFalse(lista.isEmpty());
        assertEquals(1 , lista.size());
        verify(repository, times(1)).findAll();
    }
}
