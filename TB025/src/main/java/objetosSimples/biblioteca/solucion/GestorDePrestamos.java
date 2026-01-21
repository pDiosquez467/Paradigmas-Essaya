package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.util.*;

/**
 * Esta clase no valida la existencia de usuarios o stock en el catálogo; asume que
 * recibe entidades válidas y consistentes para operar.
 */
public class GestorDePrestamos {
    private final Map<String, List<Prestamo>> prestamos;

    /**
     * Inicializa un gestor de préstamos vacío.
     */
    public GestorDePrestamos() {
        this.prestamos = new HashMap<>();
    }

    /**
     * Registra un nuevo préstamo en el sistema.
     * <p>
     * Este método asume que la copia está disponible. La validación de estado
     * y el cambio a {@code PRESTADO} ocurren dentro de la creación de la entidad {@link Prestamo}.
     *
     * @param usuario El usuario que solicita el préstamo. No puede ser nulo.
     * @param copia   La copia física a prestar. No puede ser nula.
     * @throws IllegalStateException    Si la copia no se encuentra en estado {@code DISPONIBLE}.
     * @throws IllegalArgumentException Si alguno de los argumentos es nulo.
     */
    public void prestar(Usuario usuario, Copia copia) {
        Validaciones.validarNotNull(usuario, "usuario");
        Validaciones.validarNotNull(copia, "copia");
        Prestamo prestamo = new Prestamo(usuario, copia);
        this.prestamos.computeIfAbsent(usuario.id(), k -> new ArrayList<>()).add(prestamo);
    }

    /**
     * Registra la devolución de una copia física, cerrando el préstamo asociado.
     * <p>
     * Realiza una búsqueda exhaustiva en los préstamos activos para encontrar la transacción
     * correspondiente a la copia dada.
     *
     * @param copia La copia que está siendo devuelta. No puede ser nula.
     * @throws IllegalStateException    Si la copia no figura asociada a ningún préstamo activo actualmente.
     * @throws IllegalArgumentException Si la copia es nula.
     */
    public void devolver(Copia copia) {
        Validaciones.validarNotNull(copia, "copia");
        Optional<Prestamo> prestamoActivo = this.prestamos.values().stream()
                .flatMap(List::stream)
                .filter(p -> p.estaActivo() && p.getCopia().equals(copia))
                .findFirst();
        if (prestamoActivo.isEmpty()) {
            throw new IllegalStateException("La copia ID: " + copia.getId() + " no figura como prestada en el sistema.");
        }
        prestamoActivo.get().registrarDevolucion();
    }

    /**
     * Consulta todos los préstamos que aún no han sido devueltos por un usuario específico.
     *
     * @param usuario El usuario a consultar. No puede ser nulo.
     * @return Una lista inmutable con los préstamos activos. Si el usuario no tiene historial, retorna lista vacía.
     */
    public List<Prestamo> consultarPrestamosVigentes(Usuario usuario) {
        Validaciones.validarNotNull(usuario, "usuario");
        return this.prestamos.getOrDefault(usuario.id(), Collections.emptyList())
                .stream()
                .filter(Prestamo::estaActivo)
                .toList();
    }
}