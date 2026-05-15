package org.example.ut4a1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "vehiculos")
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La marca no puede estar vacía")
    private String marca;

    @NotBlank(message = "El modelo no puede estar vacío")
    private String modelo;

    @Min(value = 1900, message = "El año de matriculación debe ser mayor a 1900")
    @Max(value = 2026, message = "El año de matriculación no puede ser futuro")
    private int matriculacion;

    @Positive(message = "El precio debe ser mayor a 0")
    private double precio;

    @NotNull(message = "La fecha de próxima ITV es obligatoria")
    @FutureOrPresent(message = "La fecha de ITV no puede ser anterior a hoy")
    private LocalDate proximaITV;
}
