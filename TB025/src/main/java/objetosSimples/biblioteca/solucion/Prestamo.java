package main.java.objetosSimples.biblioteca.solucion;

import main.java.objetosSimples.validaciones.Validaciones;

import java.time.LocalDate;
import java.util.Objects;

public class Prestamo {
    private static final int DIAS_DE_PRESTAMO_DEFAULT = 30;

    private final Usuario usuario;
    private final Copia copia;
    private final LocalDate fechaDeInicio;
    private final LocalDate fechaDeVencimiento;
    private LocalDate fechaDeDevolucion;

    public Prestamo(Usuario usuario, Copia copia) {
        Validaciones.validarNotNull(usuario, "usuario");
        Validaciones.validarNotNull(copia, "copia");
        copia.prestar();

        this.usuario = usuario;
        this.copia   = copia;
        this.fechaDeInicio = LocalDate.now();
        this.fechaDeVencimiento = this.fechaDeInicio.plusDays(DIAS_DE_PRESTAMO_DEFAULT);
        this.fechaDeDevolucion  = null;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Prestamo prestamo)) return false;
        return Objects.equals(usuario, prestamo.usuario) && Objects.equals(copia, prestamo.copia) && Objects.equals(fechaDeInicio, prestamo.fechaDeInicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, copia, fechaDeInicio);
    }

    public boolean estaActivo() {
        return this.fechaDeDevolucion == null;
    }

    public boolean estaVencido(LocalDate fechaDeReferencia) {
        return this.estaActivo() &&
                fechaDeReferencia.isAfter(this.fechaDeVencimiento);
    }

    public void registrarDevolucion() {
        if (!estaActivo()) {
            throw new IllegalStateException("El préstamo NO está activo.");
        }
        this.fechaDeDevolucion = LocalDate.now();
        this.copia.devolver();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Copia getCopia() {
        return copia;
    }

    public LocalDate getFechaDeInicio() {
        return fechaDeInicio;
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public LocalDate getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "usuario=" + usuario +
                ", copia=" + copia +
                ", fechaDeInicio=" + fechaDeInicio +
                ", fechaDeVencimiento=" + fechaDeVencimiento +
                ", fechaDeDevolucion=" + fechaDeDevolucion +
                '}';
    }
}
