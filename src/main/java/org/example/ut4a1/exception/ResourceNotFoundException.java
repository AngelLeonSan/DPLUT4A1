// Crear package org.example.ut4a1.exception
// Clase ResourceNotFoundException.java

package org.example.ut4a1.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}